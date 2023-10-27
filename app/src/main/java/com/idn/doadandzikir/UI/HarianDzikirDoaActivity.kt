package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoaDanDzikirAdapter
import com.idn.doadandzikir.Model.DoaDanDzikirItem
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {

    private var _binding : ActivityHarianDzikirDoaBinding ?= null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar ?. setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_harian_dzikir_doa)
        setContentView(binding.root)

        providingDzikirData()
        initView()
    }

    private fun initView() {
        val mAdapter = DoaDanDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirData() : List<DoaDanDzikirItem> {
        val titleDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val transDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDanDzikirItem>()
        for (i in titleDoa.indices) {
            val data = DoaDanDzikirItem(
                titleDoa[i],
                arabDoa[i],
                transDoa[i]
            )
            listData.add(data)
        }
        return listData
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}