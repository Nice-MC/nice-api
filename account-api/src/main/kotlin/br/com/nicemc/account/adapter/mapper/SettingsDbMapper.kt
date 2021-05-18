package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.SettingsEntity
import br.com.nicemc.account.domain.model.Settings

fun Settings.toDbEntity(): SettingsEntity = SettingsEntity(
    receivePrivateMessages = receivePrivateMessages,
    receiveChatMessages = receiveChatMessages,
    receiveAlerts = receiveAlerts,
    language = language
)

fun SettingsEntity.toDomainModel(): Settings = Settings(
    receivePrivateMessages = receivePrivateMessages,
    receiveChatMessages = receiveChatMessages,
    receiveAlerts = receiveAlerts,
    language = language
)