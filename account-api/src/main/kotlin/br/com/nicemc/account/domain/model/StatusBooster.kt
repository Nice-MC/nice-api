package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.StatusBoosterStatus
import br.com.nicemc.account.domain.enums.CurrencyType

data class StatusBooster(
    val type: CurrencyType,
    val status: StatusBoosterStatus = StatusBoosterStatus.DISABLED,
    val multiplier: Double
)