package com.example.kidsdrawingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.net.toUri
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class ShowImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)

        var textView = findViewById<MaterialTextView>(R.id.imageview)
        val imageView = findViewById<ImageView>(R.id.imageview_main)
        //imageView = intent.getIntExtra("Image")
        textView.text = intent.getStringExtra("Path").toString()

        val uri : Uri = Uri.parse(textView.text as String)
        imageView.setImageURI(uri)

        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        shareIntent.type = "image/*"
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        startActivity(Intent.createChooser(shareIntent, "Share"))
    }
}