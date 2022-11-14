package info.sergeikolinichenko.cryptorates.presentation.screens

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import info.sergeikolinichenko.cryptorates.R
import info.sergeikolinichenko.cryptorates.data.database.CryptoMapper.Companion.EMPTY_STRING
import info.sergeikolinichenko.cryptorates.databinding.ActivityCryptoDetailBinding
import info.sergeikolinichenko.cryptorates.databinding.ActivityCryptoPriceListBinding

class CryptoDetailActivity : AppCompatActivity() {

    private val viewModelFactory by lazy { CryptoInfoViewModelFactory(application) }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CryptoInfoViewModel::class.java]
    }

    private var _binding: ActivityCryptoDetailBinding? = null
    private val binding: ActivityCryptoDetailBinding
        get() = _binding ?: throw RuntimeException("ActivityCryptoDetailBinding equals null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCryptoDetailBinding.inflate(layoutInflater)
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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