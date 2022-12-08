package com.codedeco.framework.popupmenu.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.codedeco.framework.databinding.ItemPopupMenuItemBinding
import com.codedeco.framework.popupmenu.item.PopupMenuItem

class PopupMenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<PopupMenuItem> = emptyList()
    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PopupMenuItemViewHolder(
            ItemPopupMenuItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopupMenuItemViewHolder) {
            holder.update(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface ItemClickListener {
        fun onItemClick(item: PopupMenuItem)
    }

    private inner class PopupMenuItemViewHolder(
        private val binding: ItemPopupMenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var item: PopupMenuItem

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(item)
            }
        }

        fun update(item: PopupMenuItem) {
            this.item = item

            binding.menuItem.apply {
                setText(item.stringRes)
                val prefixDrawable = item.prefixDrawableRes?.let { drawableRes ->
                    ContextCompat.getDrawable(context, drawableRes)
                }
                val suffixDrawable = item.suffixDrawableRes?.let { drawableRes ->
                    ContextCompat.getDrawable(context, drawableRes)
                }
                setCompoundDrawablesWithIntrinsicBounds(prefixDrawable, null, suffixDrawable, null)
                alpha = if (item.isEnabled) {
                    1f
                } else {
                    0.3f
                }
            }
        }
    }
}