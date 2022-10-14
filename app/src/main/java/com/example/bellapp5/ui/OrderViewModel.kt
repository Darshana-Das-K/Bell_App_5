package com.example.bellapp5.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.bellapp5.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

/** Price for a single meal */
private const val PRICE_PER_MEAL = 70.00

/**
 * [OrderViewModel] holds information about a meal order in terms of quantity.
 * It also knows how to calculate the total price based on these order details.
 */
class OrderViewModel : ViewModel() {
    /**
     * meal state for this order
     */
    private val _uiState = MutableStateFlow(OrderUiState(price = calculatePrice()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()


    /**
     * Set the quantity [number of checkboxes checked]] of meal for this order's state and update the price
     */
    fun setQuantity(numberOfCheckBoxes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberOfCheckBoxes,
                price = calculatePrice(numberOfMeals = numberOfCheckBoxes)
            )
        }
    }


    /**
     * Returns the calculated price based on the order details.
     */
    private fun calculatePrice(
        numberOfMeals: Int = _uiState.value.quantity,

    ): String {
        var calculatedPrice = numberOfMeals * PRICE_PER_MEAL
        // If the user selected the first option (today) for pickup, add the surcharge
      //  if (pickupOptions()[0] == pickupDate) {
       //     calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
      //  }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }




}

