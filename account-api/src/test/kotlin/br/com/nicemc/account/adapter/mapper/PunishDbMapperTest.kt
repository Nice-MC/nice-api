package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.PunishEntity
import br.com.nicemc.account.domain.enums.PunishType
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.model.Punish
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.util.*

internal class PunishDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Punish(
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

        val entity = PunishDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(punishId, model.punishId)
                assertEquals(account.playerName, model.punished.playerName)
                assertEquals(type, model.type)
                assertEquals(reason, model.reason)
                assertEquals(punishedBy, model.punishedBy)
                assertEquals(punishedAt, model.punishedAt)
                assertEquals(isPermanent, model.isPermanent)
                assertEquals(expiresIn, model.expiresIn)
                assertEquals(isRemoved, model.isRemoved())
                assertEquals(removedBy, model.removedBy())
                assertEquals(removedAt, model.removedAt())
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = PunishEntity(
            punishId = UUID.randomUUID(),
            account = AccountDbMapper.mapToEntity(Account(UUID.randomUUID(), "Notch")),
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

        val model = PunishDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(punishId, entity.punishId)
                assertEquals(punished.playerName, entity.account.playerName)
                assertEquals(type, entity.type)
                assertEquals(reason, entity.reason)
                assertEquals(punishedBy, entity.punishedBy)
                assertEquals(punishedAt, entity.punishedAt)
                assertEquals(isPermanent, entity.isPermanent)
                assertEquals(expiresIn, entity.expiresIn)
                assertEquals(isRemoved(), entity.isRemoved)
                assertEquals(removedBy(), entity.removedBy)
                assertEquals(removedAt(), entity.removedAt)
            })
        }
    }

}
