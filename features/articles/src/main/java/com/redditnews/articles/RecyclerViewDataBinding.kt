package com.redditnews.articles

import android.media.Image
import android.media.tv.TvContract
import android.provider.MediaStore.Audio.Artists
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.redditnews.domain.models.Article

@BindingAdapter("articles_list")
fun RecyclerView.setArticlesList(list: List<Article>?) {
    Log.d("sfdsfsddsf", "setArticlesList: $list")
    (adapter as? ArticlesAdapter)?.submitList(list)
}


