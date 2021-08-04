package com.example.application.util

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.application.R

fun ImageView.setImageUrl(context: Context, url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.img_rick).centerCrop().into(this)
    this.scaleType = ImageView.ScaleType.FIT_XY
    this.adjustViewBounds = true
}

fun share(context: Context, url: String) {
    context.startActivity(Intent.createChooser(Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, url)
        putExtra(Intent.EXTRA_TITLE, context.getString(R.string.label_share_url))
        type = "text/plain"
    }, null))
}