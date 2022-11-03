package info.sergeikolinichenko.cryptorates.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/** Created by Sergei Kolinichenko on 02.11.2022 at 16:58 (GMT+3) **/

fun convertTimestampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp(timestamp * 1000)
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}