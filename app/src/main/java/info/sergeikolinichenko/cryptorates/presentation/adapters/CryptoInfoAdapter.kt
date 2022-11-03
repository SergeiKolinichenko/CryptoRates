package info.sergeikolinichenko.cryptorates.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import info.sergeikolinichenko.cryptorates.R
import info.sergeikolinichenko.cryptorates.data.model.CryptoNameDto

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:52 (GMT+3) **/

class CryptoInfoAdapter: ListAdapter<CryptoNameDto, CryptoInfoViewHolder> (CryptoListDiffCallback())
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_crypto_info,
            parent,
            false
        )
        return CryptoInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoInfoViewHolder, position: Int) {
        val cryptoCoin = getItem(position)
        Picasso.get().load(cryptoCoin.getFullImageUrl()).into(holder.ivLogoCrypto)
        holder.tvFromSymbol.text = cryptoCoin.fromSymbol
        holder.tvToSymbol.text = cryptoCoin.toSymbol
        holder.tvPrice.text = cryptoCoin.price
        holder.tvLastUpdate.text = cryptoCoin.getFormattedTime()
    }

}