package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.StatusEntity
import br.com.nicemc.account.domain.model.Status

object StatusDbMapper : Mapper<Status, StatusEntity> {

    override fun mapToEntity(model: Status) = StatusEntity(
        xpValue = model.xp.value.toBigDecimal(),
        coinsValue = model.coins.value.toBigDecimal(),
        cashValue = model.cash.value.toBigDecimal()
    )

    override fun mapToModel(entity: StatusEntity) = Status(
        xpValue = entity.xpValue.intValueExact(),
        coinsValue = entity.coinsValue.intValueExact(),
        cashValue = entity.cashValue.intValueExact()
    )

}
