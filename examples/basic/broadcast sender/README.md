# Broadcast Sender

Broadcast is one of the mechanism that we can communicate between / within application(s).

Broadcast (local/global) events could be sent via Intent. It could be implemented like this.

```kotlin
val intent = Intent("broadcast.event.action")
intent.putExtra("key", value)
context.sendBroadcast(intent)
```

Even the implementation could be centralized in shared module, feature-related implementation is still not decoupled.

With the idea that explained before, instead of putting all implementation in shared module, implementation are distributed to different feature modules and injected to the `Factory` class.

This is the idea for the final output

```kotlin
// broadcast
broadcastSenderFactory.get(SomeFeatureBroadcastSender::class.java)
        ?.createIntent(SomeFeatureBroadcastSender.Data(parameters))
        ?.run {
            context.sendBroadcast(this)
        }

// local broadcast
broadcastSenderFactory.get(SomeFeatureBroadcastSender::class.java)
        ?.createIntent(SomeFeatureBroadcastSender.Data(parameters))
        ?.run {
            LocalBroadcastManager.getInstance(context)
                .sendBroadcast(this)
        }
```

The decision of using broadcast / local broadcast could be also handled from the feature it self. It is mentioned in the sample project.

- It is recommended to implement [broadcast receiver](../../advanced/broadcast%20receiver) together with [broadcast sender](.) as pair.

**Sample project**

[Broadcast Sender Sample](./sample)
