package info.sergeikolinichenko.cryptorates.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import info.sergeikolinichenko.cryptorates.databinding.ItemCryptoInfoBinding
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:52 (GMT+3) **/

class CryptoInfoAdapter : ListAdapter<CryptoInfo, CryptoInfoViewHolder>(CryptoListDiffCallback()) {
    var onListItemClick: ((CryptoInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoInfoViewHolder {
        val binding = ItemCryptoInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CryptoInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoInfoViewHolder, position: Int) {

        val cryptoCoin = getItem(position)
        with(holder.binding) {
            Picasso.get().load(cryptoCoin.imageUrl).into(ivLogoCrypto)
            tvFromSymbol.text = cryptoCoin.fromSymbol
            tvToSymbol.text = cryptoCoin.toSymbol
            tvPrice.text = cryptoCoin.price
            tvLastUpdate.text = cryptoCoin.lastUpdate
        }



        holder.itemView.setOnClickListener { onListItemClick?.invoke(cryptoCoin) }
    }

}