package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.AccountEntity
import br.com.nicemc.account.adapter.entity.PunishEntity
import br.com.nicemc.account.domain.enums.PunishType
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.model.Punish
import br.com.nicemc.account.domain.model.Status
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.util.*

internal class PunishDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a db entity`() {
        val punish = Punish(
            punishId = UUID.randomUUID(),
            punished = Account(UUID.randomUUID(), "Notch"),
            type = PunishType.BAN,
            reason = "cheating",
            punishedBy = UUID.randomUUID(),
            punishedAt = LocalDateTime.now(),
            isPermanent = false,
            expiresIn = null,
            isRemoved = false,
            removedBy = null,
            removedAt = null
        )

        val dbEntity = punish.toDbEntity()

        with(dbEntity) {
            assertAll({
                assertEquals(punishId, punish.punishId)
                assertEquals(account.playerName, punish.punished.playerName)
                assertEquals(type, punish.type)
                assertEquals(reason, punish.reason)
                assertEquals(punishedBy, punish.punishedBy)
                assertEquals(punishedAt, punish.punishedAt)
                assertEquals(isPermanent, punish.isPermanent)
                assertEquals(expiresIn, punish.expiresIn)
                assertEquals(isRemoved, punish.isRemoved())
                assertEquals(removedBy, punish.removedBy())
                assertEquals(removedAt, punish.removedAt())
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val punishEntity = PunishEntity(
            punishId = UUID.randomUUID(),
            account = Account(UUID.randomUUID(), "Notch").toDbEntity(),
            type = PunishType.BAN,
            reason = "cheating",
            punishedBy = UUID.randomUUID(),
            punishedAt = LocalDateTime.now(),
            isPermanent = false,
            expiresIn = null,
            isRemoved = false,
            removedBy = null,
            removedAt = null
        )

        val domain = punishEntity.toDomainModel()

        with(domain) {
            assertAll({
                assertEquals(punishId, punishEntity.punishId)
                assertEquals(punished.playerName, punishEntity.account.playerName)
                assertEquals(type, punishEntity.type)
                assertEquals(reason, punishEntity.reason)
                assertEquals(punishedBy, punishEntity.punishedBy)
                assertEquals(punishedAt, punishEntity.punishedAt)
                assertEquals(isPermanent, punishEntity.isPermanent)
                assertEquals(expiresIn, punishEntity.expiresIn)
                assertEquals(isRemoved(), punishEntity.isRemoved)
                assertEquals(removedBy(), punishEntity.removedBy)
                assertEquals(removedAt(), punishEntity.removedAt)
            })
        }
    }
}