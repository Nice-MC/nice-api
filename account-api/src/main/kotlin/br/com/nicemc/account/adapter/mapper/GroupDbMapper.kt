package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.GroupEntity
import br.com.nicemc.account.domain.model.Group

object GroupDbMapper : Mapper<Group, GroupEntity> {

    override fun mapToEntity(model: Group) = GroupEntity(
        type = model.type,
        definedAt = model.definedAt,
        definedBy = model.definedBy,
        permanent = model.isPermanent,
        expiresIn = model.expiresIn
    )

    override fun mapToModel(entity: GroupEntity) = Group(
        type = entity.type,
        definedAt = entity.definedAt,
        definedBy = entity.definedBy,
        isPermanent = entity.permanent,
        expiresIn = entity.expiresIn
    )

}
