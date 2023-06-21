package com.pancake.footballfever.utilities

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun Int.toDate(): String {
    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong()
    val format = SimpleDateFormat("HH:mm", Locale.getDefault())
    return format.format(calender.time)


}