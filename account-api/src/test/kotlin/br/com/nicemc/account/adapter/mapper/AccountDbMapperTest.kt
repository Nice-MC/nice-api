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
    override fun `should return a db entity`() {
        val account = Account(
            accountId = UUID.randomUUID(),
            playerName = "Notch",
            createdAt = LocalDateTime.now(),
            status = Status(),
            settings = Settings(),
            group = Group()
        )

        val dbEntity = AccountDbMapper.mapToEntity(account)

        with(dbEntity) {
            assertAll({
                assertEquals(playerUniqueId, account.accountId)
                assertEquals(playerName, account.playerName)
                assertEquals(createdAt, account.createdAt)

                assertNotNull(status)
                assertNotNull(settings)
                assertNotNull(group)

                assertTrue(integrations.isNullOrEmpty())
                assertTrue(punishes.isNullOrEmpty())
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val account = AccountEntity(
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

        val domain = AccountDbMapper.mapToModel(account)

        with(domain) {
            assertAll({
                assertEquals(accountId, account.playerUniqueId)
                assertEquals(playerName, account.playerName)
                assertEquals(createdAt, account.createdAt)
                assertNotNull(status)
                assertNotNull(settings)
                assertNotNull(group)
            })
        }
    }
}