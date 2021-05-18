package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.IntegrationEntity
import br.com.nicemc.account.domain.model.Integration

fun Integration.toDbEntity(): IntegrationEntity = IntegrationEntity(
    integrationId = integrationId,
    account = account.toDbEntity(),
    name = name,
    value = value,
    integratedAt = integratedAt,
    confirm = isConfirmed(),
    confirmedAt = getConfirmDate()
)

fun IntegrationEntity.toDomainModel(): Integration = Integration(
    integrationId = integrationId,
    account = account.toDomainModel(),
    name = name,
    value = value,
    integratedAt = integratedAt,
    confirm = confirm,
    confirmedAt = confirmedAt
)