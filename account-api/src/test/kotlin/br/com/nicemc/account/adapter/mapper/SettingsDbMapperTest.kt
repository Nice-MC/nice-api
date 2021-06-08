package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.SettingsEntity
import br.com.nicemc.account.domain.enums.Language
import br.com.nicemc.account.domain.model.Settings
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class SettingsDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Settings(
            receivePrivateMessages = true,
            receiveChatMessages = true,
            receiveAlerts = true,
            language = Language.PORTUGUESE
        )

        val entity = SettingsDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(receivePrivateMessages, model.receivePrivateMessages)
                assertEquals(receiveChatMessages, model.receiveChatMessages)
                assertEquals(receiveAlerts, model.receiveAlerts)
                assertEquals(language, model.language)
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = SettingsEntity(
            receivePrivateMessages = true,
            receiveChatMessages = true,
            receiveAlerts = true,
            language = Language.PORTUGUESE
        )

        val model = SettingsDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(receivePrivateMessages, entity.receivePrivateMessages)
                assertEquals(receiveChatMessages, entity.receiveChatMessages)
                assertEquals(receiveAlerts, entity.receiveAlerts)
                assertEquals(language, entity.language)
            })
        }
    }
}