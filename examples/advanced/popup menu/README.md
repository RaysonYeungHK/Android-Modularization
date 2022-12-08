# Popup Menu

Popup menu is commonly used in the application. It usually contain multiple functions.

Those implementation could be distributed to different modules instead of centralized location.

Here is the solution design to break down the popup menu.

![](solution%20design.png)

`PopupMenuItem` defines item inside `PopupMenu`, assume there is prefix image, suffix image, text, availability in the item.

`PopupMenuItem` also define its action after user clicked on it

```kotlin
abstract class PopupMenuItem {
    @get:DrawableRes
    abstract val prefixDrawableRes: Int?

    @get:DrawableRes
    abstract val suffixDrawableRes: Int?

    @get:StringRes
    abstract val stringRes: Int

    abstract val isEnabled: Boolean

    abstract fun performClick(
        metadata: PopupMenu.Metadata
    ): Boolean
}
```

With the idea that explained before, actual `PopupMenuItem` are implemented in different feature modules.



`PopupMenu` define the metadata and access point to shows the actual UI

```kotlin
abstract class PopupMenu {
    protected lateinit var _metadata: Metadata

    fun setMetadata(metadata: Metadata) = apply {
        this._metadata = metadata
    }

    // function to show the actual UI
    abstract fun show(
        anchorView: View,
        menuItems: List<Class<out PopupMenuItem>>
    )

    // this data class should include all different meta data
    @Parcelize
    data class Metadata(
        val commonMetadata: PopupMenuItem.Metadata? = null
    ) : Parcelable
}
```

```kotlin
class PopupMenuImpl @Inject constructor (
    private val menuItemMap: Map<Class<out PopupMenuItem>, @JvmSuppressWildcards Provider<PopupMenuItem>>
) : PopupMenu {
    ...
    override fun show(
        anchorView: View,
        menuItems: List<Class<out PopupMenuItem>>
    ) {
        ...
        // The tricky part to get the actual implementation of PopupMenuItem
        // In order to show the item
        // 1. Consumer need to define the item from parameter
        // 2. Implementation of menu item is provided
        val itemsToShow = menuItems.mapNotNull {
            menuItemMap[it]?.get()
        }
        ...
    }
}
```

In order to use the `PopupMenu`, consumer need to pass `Metadata`, `AnchorView` and list of the `PopupMenuItem` that shows up.

```kotlin
popupMenu.setMetadata(metadata)
popupMenu.show(
    anchorView,
    listOf(
        MyPopupMenuItem::class,
        YourPopupMenuItem::class,
        CommomnPopupMenuItem::class
    )
)
```

For more detail, please check the sample project.

**Sample project**

[Popup Menu Sample](./sample)
