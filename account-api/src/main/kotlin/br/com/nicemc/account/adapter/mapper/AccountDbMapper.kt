package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.AccountEntity
import br.com.nicemc.account.domain.model.Account

fun Account.toDbEntity(): AccountEntity = AccountEntity(
    playerUniqueId = accountId,
    playerName = playerName,
    createdAt = createdAt
).let {
    it.status = this.status.toDbEntity()
    it.settings = this.settings.toDbEntity()
    it.group = this.group.toDbEntity()
    it.integrations = this.getIntegrations().map { integration -> integration.toDbEntity() }.toSet()
    it.punishes = this.getPunishes().map { punish -> punish.toDbEntity() }.toSet()
    it
}

fun AccountEntity.toDomainModel(): Account = Account(
    accountId = playerUniqueId,
    playerName = playerName,
    createdAt = createdAt,
    status = status!!.toDomainModel(),
    settings = settings!!.toDomainModel(),
    group = group!!.toDomainModel()
).apply {
    if (!integrations.isNullOrEmpty()) {
        addAllIntegrations(integrations!!.map { it.toDomainModel() }.toSet())
    }
    if (!punishes.isNullOrEmpty()) {
        addAllPunishes(punishes!!.map { it.toDomainModel() }.toSet())
    }
}