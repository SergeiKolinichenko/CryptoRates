package info.sergeikolinichenko.cryptorates.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import info.sergeikolinichenko.cryptorates.domain.model.CryptoInfo

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:57 (GMT+3) **/

class CryptoListDiffCallback: DiffUtil.ItemCallback<CryptoInfo>() {

    override fun areItemsTheSame(oldItem: CryptoInfo, newItem: CryptoInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CryptoInfo, newItem: CryptoInfo): Boolean {
        return oldItem == newItem
    }
}