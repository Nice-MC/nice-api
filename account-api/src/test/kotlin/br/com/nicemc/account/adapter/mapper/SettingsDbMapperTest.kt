package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.SettingsEntity
import br.com.nicemc.account.domain.enums.Language
import br.com.nicemc.account.domain.model.Settings
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class SettingsDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a db entity`() {
        val settings = Settings(
            receivePrivateMessages = true,
            receiveChatMessages = true,
            receiveAlerts = true,
            language = Language.PORTUGUESE
        )

        val dbEntity = settings.toDbEntity()

        with(dbEntity) {
            assertAll({
                assertEquals(receivePrivateMessages, settings.receivePrivateMessages)
                assertEquals(receiveChatMessages, settings.receiveChatMessages)
                assertEquals(receiveAlerts, settings.receiveAlerts)
                assertEquals(language, settings.language)
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val settingEntity = SettingsEntity(
            receivePrivateMessages = true,
            receiveChatMessages = true,
            receiveAlerts = true,
            language = Language.PORTUGUESE
        )

        val domain = settingEntity.toDomainModel()

        with(domain) {
            assertAll({
                assertEquals(receivePrivateMessages, settingEntity.receivePrivateMessages)
                assertEquals(receiveChatMessages, settingEntity.receiveChatMessages)
                assertEquals(receiveAlerts, settingEntity.receiveAlerts)
                assertEquals(language, settingEntity.language)
            })
        }
    }
}