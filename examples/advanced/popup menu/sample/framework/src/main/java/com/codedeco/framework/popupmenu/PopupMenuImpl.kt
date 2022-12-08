package com.codedeco.framework.popupmenu;

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedeco.framework.databinding.WidgetPopupMenuBinding
import com.codedeco.framework.popupmenu.item.PopupMenuItem
import com.codedeco.framework.popupmenu.recyclerview.PopupMenuAdapter
import java.lang.ref.WeakReference
import javax.inject.Inject
import javax.inject.Provider

class PopupMenuImpl @Inject constructor(
    private val menuItemMap: Map<Class<out PopupMenuItem>, @JvmSuppressWildcards Provider<PopupMenuItem>>
) : PopupMenu() {
    private lateinit var binding: WidgetPopupMenuBinding
    private val adapter = PopupMenuAdapter()

    private var anchorContext = WeakReference<Context>(null)
    private var popupWindow = WeakReference<PopupWindow>(null)

    init {
        adapter.itemClickListener = object : PopupMenuAdapter.ItemClickListener {
            override fun onItemClick(item: PopupMenuItem) {
                item.performClick(_metadata)
            }
        }
    }

    override fun show(anchorView: View, menuItems: List<Class<out PopupMenuItem>>) {
        // Create the layout based on the anchor view existence
        val context = anchorView.context
        initLayout(context)
        anchorContext = WeakReference(context)

        // Get menu items that what to be shown
        menuItems.mapNotNull {
            menuItemMap[it]?.get()
        }.run {
            adapter.items = this@run
            adapter.notifyDataSetChanged()
        }

        // Any way you want to show the popup window
        /*
        PopupWindow(context).apply {
            this.contentView = binding.root
            isOutsideTouchable = true
            isTouchable = true
            isFocusable = true // to be dismissed by tapping device's back key
            setBackgroundDrawable(ColorDrawable(0))
            setTouchInterceptor(View.OnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_OUTSIDE) {
                    dismiss()
                    return@OnTouchListener true
                }
                false
            })
        }
        */
    }

    private fun initLayout(context: Context) {
        val inflater = LayoutInflater.from(context)
        binding = WidgetPopupMenuBinding.inflate(inflater, null, false)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PopupMenuImpl.adapter
        }
    }
}
