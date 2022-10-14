package com.example.bellapp5.data


/**
 * Data class that represents the current UI state in terms of [quantity] and [price]
 */
data class OrderUiState(
    /** Selected meal quantity  */
    val quantity: Int = 0,
    /** Total price for the order */
    val price: String = "",

)