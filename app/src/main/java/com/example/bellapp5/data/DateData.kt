package com.example.bellapp5.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.Text

/**
 * A data class to represent the information presented in the dog card
 */
data class DateData(
    val date: Int

)
val dateList = listOf(
    DateData(1),
    DateData(2),
    DateData(3),
    DateData(4),
    DateData(5),
    DateData(6),
    DateData(7),
    DateData(8),
    DateData(9),
    DateData(10),
    DateData(11),
    DateData(12),
    DateData(13),
    DateData(14),
    DateData(15),
    DateData(16),
    DateData(17),
    DateData(18),
    DateData(19),
    DateData(20),
    DateData(21),
    DateData(22),
    DateData(23),
    DateData(24),
    DateData(25),
    DateData(26),
    DateData(27),
    DateData(28),
    DateData(29),
    DateData(30)

)



data class InputWrapper(
    val value: String = "",
    val errorId: Int? = null
)




