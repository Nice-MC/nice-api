package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.IntegrationEntity
import br.com.nicemc.account.domain.model.Integration

object IntegrationDbMapper : Mapper<Integration, IntegrationEntity> {

    override fun mapToEntity(model: Integration) = IntegrationEntity(
        integrationId = model.integrationId,
        account = AccountDbMapper.mapToEntity(model.account),
        name = model.name,
        value = model.value,
        integratedAt = model.integratedAt,
        confirm = model.isConfirmed(),
        confirmedAt = model.getConfirmDate()
    )

    override fun mapToModel(entity: IntegrationEntity) = Integration(
        integrationId = entity.integrationId,
        account = AccountDbMapper.mapToModel(entity.account),
        name = entity.name,
        value = entity.value,
        integratedAt = entity.integratedAt,
        confirm = entity.confirm,
        confirmedAt = entity.confirmedAt
    )

}
