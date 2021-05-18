package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.StatusEntity
import br.com.nicemc.account.domain.model.Status

fun Status.toDbEntity(): StatusEntity = StatusEntity(
    xpValue = xp.value.toBigDecimal(),
    coinsValue = coins.value.toBigDecimal(),
    cashValue = cash.value.toBigDecimal()
)

fun StatusEntity.toDomainModel(): Status = Status(
    xpValue = xpValue.intValueExact(),
    coinsValue = coinsValue.intValueExact(),
    cashValue = cashValue.intValueExact()
)