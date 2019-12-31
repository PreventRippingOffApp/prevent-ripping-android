package com.prevent.feature.record.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.prevent.feature.record.list.entity.RecordLogViewEntity

internal class RecordListAdapter(
    private val context: Context
) :
    ListAdapter<RecordLogViewEntity, RecordListViewHolder>(DIFF_UTIL) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<RecordLogViewEntity>() {
            override fun areItemsTheSame(
                oldItem: RecordLogViewEntity,
                newItem: RecordLogViewEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RecordLogViewEntity,
                newItem: RecordLogViewEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordListViewHolder {
        return RecordListViewHolder.create(
            LayoutInflater.from(context),
            parent
        )
    }

    override fun onBindViewHolder(holder: RecordListViewHolder, position: Int) {
        return holder.bindTo(getItem(position))
    }
}
