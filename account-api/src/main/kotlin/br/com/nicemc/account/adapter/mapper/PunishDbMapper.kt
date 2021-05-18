package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.PunishEntity
import br.com.nicemc.account.domain.model.Punish

fun Punish.toDbEntity(): PunishEntity = PunishEntity(
    punishId = punishId,
    account = punished.toDbEntity(),
    type = type,
    reason = reason,
    punishedBy = punishedBy,
    punishedAt = punishedAt,
    isPermanent = isPermanent,
    expiresIn = expiresIn,
    isRemoved = isRemoved(),
    removedBy = removedBy(),
    removedAt = removedAt()
)

fun PunishEntity.toDomainModel(): Punish = Punish(
    punishId = punishId,
    punished = account.toDomainModel(),
    type = type,
    reason = reason,
    punishedBy = punishedBy,
    punishedAt = punishedAt,
    isPermanent = isPermanent,
    expiresIn = expiresIn,
    isRemoved = isRemoved,
    removedBy = removedBy,
    removedAt = removedAt
)