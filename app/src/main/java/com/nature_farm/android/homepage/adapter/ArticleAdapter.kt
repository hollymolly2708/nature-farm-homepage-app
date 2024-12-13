package com.nature_farm.android.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nature_farm.android.homepage.databinding.ItemArticleBinding
import com.nature_farm.android.homepage.core.data.domain.model.Article

class ArticleAdapter(private val articles: ArrayList<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ArticleAdapter.ArticleViewHolder {
        return ArticleViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ArticleViewHolder, position: Int) {
        val data = articles[position]
        holder.binding.ivAuthorImage.setImageResource(data.authorImage)
        holder.binding.ivArticleImage.setImageResource(data.articleImage)
        holder.binding.tvInputArticleTitle.text = data.articleTitle
        holder.binding.tvInputArticleCategory.text = data.articleCategory
        holder.binding.tvInputAuthorName.text = data.authorName
        holder.binding.tvInputPublisherDate.text = data.publishDate
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ArticleViewHolder(var binding: ItemArticleBinding) : ViewHolder(binding.root)
}