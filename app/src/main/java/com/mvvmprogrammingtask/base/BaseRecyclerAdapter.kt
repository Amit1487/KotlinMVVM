package com.mvvmprogrammingtask.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import java.util.ArrayList




abstract class BaseRecyclerAdapter<T> constructor(protected val listItems: MutableList<T> = ArrayList()) : RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder<T>>() {

    protected  lateinit var layouInflater : LayoutInflater

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(listItems[position])
        holder.dataBinding.executePendingBindings()

    }


    override fun getItemCount(): Int {
        return listItems.size
    }


    /**
     * Replace listitems with new list
     * @param listItems needs to replace
     */
    fun replaceAll(listItems: List<T>) {
        this.listItems.clear()
        this.listItems.addAll(listItems)
        notifyDataSetChanged()
    }


    /**
     * Insert more items in the list
     * @param listItems items to add
     */
    fun insertMoreItems(listItems: List<T>) {
        val size = this.listItems.size
        this.listItems.addAll(listItems)
        notifyItemRangeInserted(size, this.listItems.size)
    }


    /**
     * Insert more items in the list
     * @param listItem items to add
     */
    fun insertMoreItem(listItem: T) {
        val size = this.listItems.size
        this.listItems.add(listItem)
        notifyItemInserted(size)
    }


    abstract class ViewHolder<T>(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.getRoot()) {
        abstract fun bind(t: T)

    }
}
