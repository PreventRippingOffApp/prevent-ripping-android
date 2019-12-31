package com.prevent.feature.record.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prevent.feature.record.databinding.ItemRecordListBinding
import com.prevent.feature.record.list.entity.RecordLogViewEntity

internal class RecordListViewHolder private constructor(
    private val binding: ItemRecordListBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            layoutInflater: LayoutInflater,
            container: ViewGroup
        ): RecordListViewHolder {
            return RecordListViewHolder(
                ItemRecordListBinding.inflate(
                    layoutInflater,
                    container,
                    false
                )
            )
        }
    }

    fun bindTo(viewEntity: RecordLogViewEntity) {
        binding.viewentity = viewEntity
    }
}
