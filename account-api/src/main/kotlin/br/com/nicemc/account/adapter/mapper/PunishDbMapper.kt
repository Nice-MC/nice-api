package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.PunishEntity
import br.com.nicemc.account.domain.model.Punish

object PunishDbMapper : Mapper<Punish, PunishEntity> {

    override fun mapToEntity(model: Punish) = PunishEntity(
        punishId = model.punishId,
        account = AccountDbMapper.mapToEntity(model.punished),
        type = model.type,
        reason = model.reason,
        punishedBy = model.punishedBy,
        punishedAt = model.punishedAt,
        isPermanent = model.isPermanent,
        expiresIn = model.expiresIn,
        isRemoved = model.isRemoved(),
        removedBy = model.removedBy(),
        removedAt = model.removedAt()
    )

    override fun mapToModel(entity: PunishEntity) = Punish(
        punishId = entity.punishId,
        punished = AccountDbMapper.mapToModel(entity.account),
        type = entity.type,
        reason = entity.reason,
        punishedBy = entity.punishedBy,
        punishedAt = entity.punishedAt,
        isPermanent = entity.isPermanent,
        expiresIn = entity.expiresIn,
        isRemoved = entity.isRemoved,
        removedBy = entity.removedBy,
        removedAt = entity.removedAt
    )

}
