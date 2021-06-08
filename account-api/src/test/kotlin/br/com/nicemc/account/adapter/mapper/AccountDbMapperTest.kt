package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.AccountEntity
import br.com.nicemc.account.adapter.entity.GroupEntity
import br.com.nicemc.account.adapter.entity.SettingsEntity
import br.com.nicemc.account.adapter.entity.StatusEntity
import br.com.nicemc.account.domain.enums.GroupType
import br.com.nicemc.account.domain.enums.Language
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.model.Group
import br.com.nicemc.account.domain.model.Settings
import br.com.nicemc.account.domain.model.Status
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

internal class AccountDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Account(
            accountId = UUID.randomUUID(),
            playerName = "Notch",
            createdAt = LocalDateTime.now(),
            status = Status(),
            settings = Settings(),
            group = Group()
        )

        val entity = AccountDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(playerUniqueId, model.accountId)
                assertEquals(playerName, model.playerName)
                assertEquals(createdAt, model.createdAt)

                assertNotNull(status)
                assertNotNull(settings)
                assertNotNull(group)

                assertTrue(integrations.isNullOrEmpty())
                assertTrue(punishes.isNullOrEmpty())
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = AccountEntity(
            playerUniqueId = UUID.randomUUID(),
            playerName = "Notch",
            createdAt = LocalDateTime.now(),
        ).apply {
            this.status = StatusEntity(0.0.toBigDecimal(), 0.0.toBigDecimal(), 0.0.toBigDecimal())
            this.settings = SettingsEntity(
                receivePrivateMessages = true,
                receiveChatMessages = true,
                receiveAlerts = true,
                language = Language.PORTUGUESE
            )
            this.group = GroupEntity(
                type = GroupType.MEMBER,
                definedAt = LocalDateTime.now(),
                definedBy = "Steve",
                permanent = true,
                expiresIn = null
            )
        }

        val model = AccountDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(accountId, entity.playerUniqueId)
                assertEquals(playerName, entity.playerName)
                assertEquals(createdAt, entity.createdAt)
                assertNotNull(status)
                assertNotNull(settings)
                assertNotNull(group)
            })
        }
    }

}
