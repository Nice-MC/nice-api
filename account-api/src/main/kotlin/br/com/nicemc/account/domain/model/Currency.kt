package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.CurrencyType
import br.com.nicemc.account.domain.exceptions.IllegalCurrencyActionException
import java.util.function.Consumer
import kotlin.math.roundToInt

data class Currency(
    val type: CurrencyType,
    private val receiverValue: Int = 0
) {

    var value: Int
        private set

    init {
        value = receiverValue
    }

    fun add(value: Int) = consumeValue { it + value }

    fun add(value: Int, booster: StatusBooster) = add(value * booster.multiplier.roundToInt())

    fun remove(value: Int) {
        if (value < this.value) {
            throw IllegalCurrencyActionException("this currency doesn't have enough balance for this")
        }
        consumeValue { it - value }
    }

    private fun consumeValue(consumer: Consumer<Int>) = consumer.accept(value)
}