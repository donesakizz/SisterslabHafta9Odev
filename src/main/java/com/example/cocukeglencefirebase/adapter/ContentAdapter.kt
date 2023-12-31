package com.example.cocukeglencefirebase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocukeglencefirebase.databinding.ListCardDesignBinding
import com.example.cocukeglencefirebase.model.Content
import com.example.cocukeglencefirebase.util.downloadFromUrl

class ContentAdapter(
    private val contentList: List<Content>,
    private val onClick: (Content) -> Unit
) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    inner class ContentViewHolder(val binding: ListCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: Content) {
            with(binding) {
                listNameTv.text = content.contentName
                content.contentImage?.let { listIv.downloadFromUrl(it) }
                itemView.setOnClickListener {
                    onClick.invoke(content)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding =
            ListCardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun getItemCount(): Int = contentList.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val content = contentList[position]
        holder.bind(content)
    }
}