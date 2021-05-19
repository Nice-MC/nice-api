package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.GroupEntity
import br.com.nicemc.account.domain.model.Group

fun Group.toDbEntity(): GroupEntity = GroupEntity(
    type = type,
    definedAt = definedAt,
    definedBy = definedBy,
    permanent = isPermanent,
    expiresIn = expiresIn
)

fun GroupEntity.toDomainModel(): Group = Group(
    type = type,
    definedAt = definedAt,
    definedBy = definedBy,
    isPermanent = permanent,
    expiresIn = expiresIn
)