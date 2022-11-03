package info.sergeikolinichenko.cryptorates.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.sergeikolinichenko.cryptorates.R

/** Created by Sergei Kolinichenko on 02.11.2022 at 17:14 (GMT+3) **/

class CryptoInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ivLogoCrypto = itemView.findViewById<ImageView>(R.id.iv_logo_crypto)
    val tvFromSymbol = itemView.findViewById<TextView>(R.id.tv_from_symbol)
    val tvToSymbol = itemView.findViewById<TextView>(R.id.tv_to_symbol)
    val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
    val tvLastUpdate = itemView.findViewById<TextView>(R.id.tv_last_update)
}