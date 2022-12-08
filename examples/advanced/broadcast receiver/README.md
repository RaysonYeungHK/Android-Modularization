# Broadcast Receiver

Broadcast is one of the mechanism that we can communicate between / within application(s).

Broadcast (local/global) events could be received via BroadcastReceiver. It could be implemented like this.

```kotlin
context.registerReceiver(
        receiver,
        filter
)
```

```
LocalBroadcastManager.getInstance(context)
        .registerReceiver(
                receiver,
                filter
        )
```

However, when there are lots of receiver registered, it could result in

```
Fatal Exception: java.lang.AssertionError
Register too many Broadcast Receivers
```

Instead of register multiple broadcast receivers, only 1 broadcast receiver is registered. Broadcast event will be forwarded to multiple broadcast listeners.

Here is the solution design of integrating broadcast to activity

![](solution%20design.png)

Implementation of `BroadcastReceiver`, `IntentFilter`, `BroadcastListener` are consolidated in `Broadcast` class

```kotlin
abstract class Broadcast {
    abstract val receiver: BroadcastReceiver
    abstract val filter: IntentFilter

    protected lateinit var listeners: List<WeakReference<BroadcastListener>>

    ...
}
```

With the idea that explained before, actual broadcast are implemented in different feature modules and injected to the `Factory` class.

`BroadcastRegister` connects `Activity`, `Broadcast` and `BroadcastListener`

```kotlin
interface BroadcastRegister {
    // Attach to activity that listening any broadcast
    fun attach(activity: AppCompatActivity)

    // Add listener for broacast event handling
    fun register(behaviour: BroadcastListener)

    // Remove listener for broacast event handling
    fun unregister(behaviour: BroadcastListener)
}
```

```kotlin
class BroadcastRegisterImpl @Inject constructor(
    broadcastFactory: BroadcastFactory
) {
    private var activity: WeakREference<AppCompatActivity>? = null

    // Get all broadcasts of the application
    private val broadcasts: List<Broadcast> = broadcastFactory.getBroadcasts()

    // Keep all listeners as weak reference
    private val listeners = ConcurrentLinkedDeqeue<WeakReference<BroadcastListeners>>()

    // some implementation to forward listeners to Broadcast class
    ...

    override fun attach(activity: AppCompatActivity) {
        this.activity = WeakReference(activity)
    }

    override fun register(behaviour: BroadcastListener) {
        // Just example to show the relationship
        listeners.add(WeakReference(behaviour))
    }

    override fun unregister(behaviour: BroadcastListener) {
        // Just example to show the relationship
        listeners.remove(WeakReference(behaviour))
    }
}
```

For more detail, please check the sample project.

This sample project is based on [Broadcast Sender](../../basic/broadcast%20sender) 's sample.

**Sample project**

[Broadcast Register Sample](./sample)
