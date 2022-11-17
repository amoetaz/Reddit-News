package com.redditnews.data.models

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.redditnews.domain.models.Article
import com.redditnews.domain.utils.Resource

fun ArticleDto.toArticle() = Article(
    title = title, thumbnail = media?.oembed?.thumbnailUrl, desc = selftext?.trim().toSpannedText().toString()

)

fun String?.toSpannedText(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}

fun <T, R> Resource<T>.toDataResource(): Resource<R> where R : Any {
    return when (this) {
        is Resource.Failure -> {
            this
        }
        is Resource.Loading -> {
            this
        }
        else -> {
            Resource.Default
        }
    }
}