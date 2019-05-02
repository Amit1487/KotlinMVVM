package com.mvvmprogrammingtask.feature.classification

import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvvmprogrammingtask.base.BaseRecyclerAdapter
import com.mvvmprogrammingtask.databinding.ItemClassificationBinding
import com.mvvmprogrammingtask.displaymodel.ClassificationItemDisplay


class ClassificationAdapter  : BaseRecyclerAdapter<ClassificationItemDisplay>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): ViewHolder {
        val binding = ItemClassificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemClassificationBinding) : BaseRecyclerAdapter.ViewHolder<ClassificationItemDisplay>(binding){
        override fun bind(t: ClassificationItemDisplay) {
            binding.data = t
            itemView.setOnClickListener{
                t.isActive.set(!(t.isActive.get()?: false))
            }
        }

    }

}