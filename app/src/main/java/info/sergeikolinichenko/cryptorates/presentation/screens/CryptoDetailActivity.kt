package info.sergeikolinichenko.cryptorates.presentation.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import info.sergeikolinichenko.cryptorates.data.CryptoMapper.Companion.EMPTY_STRING
import info.sergeikolinichenko.cryptorates.databinding.ActivityCryptoDetailBinding
import info.sergeikolinichenko.cryptorates.di.CryptoApplication
import javax.inject.Inject

class CryptoDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCryptoDetailBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: CryptoInfoViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CryptoInfoViewModel::class.java]
    }

    private val component by lazy {
        (application as CryptoApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val fromSymbol: String

        if (parseExtra(intent)) {
            fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: EMPTY_STRING
        } else {
            finish()
            return
        }

        viewModel.getDetailInfo(fromSymbol).observe(this) {
            with(binding) {
                Picasso.get().load(it.imageUrl).into(ivLogoCryptoDetail)
                tvPriceCryptoDetail.text = it.price
                tvFromSymbolCryptoDetail.text = it.fromSymbol
                tvToSymbolCryptoDetail.text = it.toSymbol
                tvMinPriceCryptoDetail.text = it.lowDay
                tvMaxPriceCryptoDetail.text = it.highDay
                tvLastMarketCryptoDetail.text = it.lastMarket
                tvLastUpdateCryptoDetail.text = it.lastUpdate
            }
        }
    }

    private fun parseExtra(intent: Intent): Boolean {
        return intent.hasExtra(EXTRA_FROM_SYMBOL)
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CryptoDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}