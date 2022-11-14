package info.sergeikolinichenko.cryptorates.presentation.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import info.sergeikolinichenko.cryptorates.R
import info.sergeikolinichenko.cryptorates.databinding.ActivityCryptoPriceListBinding
import info.sergeikolinichenko.cryptorates.presentation.adapters.CryptoInfoAdapter

/** Created by Sergei Kolinichenko on 13.10.2022 16:16 (GMT+3) **/

class CryptoPriceListActivity : AppCompatActivity() {

    private val viewModelFactory by lazy { CryptoInfoViewModelFactory(application) }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CryptoInfoViewModel::class.java]
    }
    private val adapter by lazy { CryptoInfoAdapter() }

    private var _binding: ActivityCryptoPriceListBinding? = null
    private val binding: ActivityCryptoPriceListBinding
        get() = _binding ?: throw RuntimeException("ActivityCryptoPriceListBinding equals null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCryptoPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPriceListCrypto.adapter = adapter
        viewModel.cryptoInfoList.observe(this) {
            adapter.submitList(it)
        }

        adapter.onListItemClick = {
            startActivity(
                CryptoDetailActivity.newIntent(
                    this@CryptoPriceListActivity,
                    it.fromSymbol
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}