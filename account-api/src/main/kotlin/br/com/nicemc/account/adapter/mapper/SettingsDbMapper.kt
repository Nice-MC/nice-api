package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.SettingsEntity
import br.com.nicemc.account.domain.model.Settings

object SettingsDbMapper : Mapper<Settings, SettingsEntity> {

    override fun mapToEntity(model: Settings) = SettingsEntity(
        receivePrivateMessages = model.receivePrivateMessages,
        receiveChatMessages = model.receiveChatMessages,
        receiveAlerts = model.receiveAlerts,
        language = model.language
    )

    override fun mapToModel(entity: SettingsEntity) = Settings(
        receivePrivateMessages = entity.receivePrivateMessages,
        receiveChatMessages = entity.receiveChatMessages,
        receiveAlerts = entity.receiveAlerts,
        language = entity.language
    )

}

