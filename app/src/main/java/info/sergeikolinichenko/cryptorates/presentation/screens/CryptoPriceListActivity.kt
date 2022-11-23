package info.sergeikolinichenko.cryptorates.presentation.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import info.sergeikolinichenko.cryptorates.R
import info.sergeikolinichenko.cryptorates.databinding.ActivityCryptoPriceListBinding
import info.sergeikolinichenko.cryptorates.di.CryptoApplication
import info.sergeikolinichenko.cryptorates.presentation.adapters.CryptoInfoAdapter
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 13.10.2022 16:16 (GMT+3) **/

class CryptoPriceListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCryptoPriceListBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: CryptoInfoViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CryptoInfoViewModel::class.java]
    }

    private val adapter by lazy { CryptoInfoAdapter() }

    private val component by lazy {
        (application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvPriceListCrypto.adapter = adapter
        binding.rvPriceListCrypto.itemAnimator = null // no item animation
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
}