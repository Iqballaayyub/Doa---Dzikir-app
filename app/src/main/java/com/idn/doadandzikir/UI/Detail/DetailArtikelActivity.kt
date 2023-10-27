package com.idn.doadandzikir.UI.Detail

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityDetailArtikelBinding
import com.idn.doadandzikirapp.model.Artikel

class   DetailArtikelActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

//    companion object {
//        const val DATA_TITLE = "title"
//        const val DATA_DESC = "data"
//        const val DATA_IMAGE = "image"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val data = when {
        SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
        else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as? Artikel
    }

//        val dataTitle = intent.getStringExtra(DATA_TITLE)
//        val dataDesc = intent.getStringExtra(DATA_DESC)
//        val dataImage = intent.getStringExtra(DATA_IMAGE)

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let {imgDetail.setImageResource(it) }
        }

    }
}