package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.AccountEntity
import br.com.nicemc.account.domain.model.Account

object AccountDbMapper : Mapper<Account, AccountEntity> {

    override fun mapToEntity(model: Account) = AccountEntity(
        playerUniqueId = model.accountId,
        playerName = model.playerName,
        createdAt = model.createdAt
    ).apply {
        status = StatusDbMapper.mapToEntity(model.status)
        settings = SettingsDbMapper.mapToEntity(model.settings)
        group = GroupDbMapper.mapToEntity(model.group)
        integrations = model.getIntegrations().map { integration -> IntegrationDbMapper.mapToEntity(integration) }.toSet()
        punishes = model.getPunishes().map { punish -> PunishDbMapper.mapToEntity(punish) }.toSet()
    }

    override fun mapToModel(entity: AccountEntity) = Account(
        accountId = entity.playerUniqueId,
        playerName = entity.playerName,
        createdAt = entity.createdAt,
        status = StatusDbMapper.mapToModel(entity.status!!),
        settings = SettingsDbMapper.mapToModel(entity.settings!!),
        group = GroupDbMapper.mapToModel(entity.group!!)
    ).apply {
        if (!entity.integrations.isNullOrEmpty()) {
            addAllIntegrations(entity.integrations!!.map { IntegrationDbMapper.mapToModel(it) }.toSet())
        }
        if (!entity.punishes.isNullOrEmpty()) {
            addAllPunishes(entity.punishes!!.map { PunishDbMapper.mapToModel(it) }.toSet())
        }
    }

}
