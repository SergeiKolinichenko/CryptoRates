package info.sergeikolinichenko.cryptorates.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import info.sergeikolinichenko.cryptorates.data.model.CryptoNameDto

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:57 (GMT+3) **/

class CryptoListDiffCallback: DiffUtil.ItemCallback<CryptoNameDto>() {
    override fun areItemsTheSame(oldItem: CryptoNameDto, newItem: CryptoNameDto): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CryptoNameDto, newItem: CryptoNameDto): Boolean {
        return oldItem == newItem
    }
}