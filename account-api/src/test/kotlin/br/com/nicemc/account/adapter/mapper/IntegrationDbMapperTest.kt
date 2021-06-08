package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.IntegrationEntity
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.model.Integration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.util.*

internal class IntegrationDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Integration(
            integrationId = UUID.randomUUID(),
            account = Account(UUID.randomUUID(), "Notch"),
            name = "email",
            value = "test_mail@test.com",
            integratedAt = LocalDateTime.now(),
            confirm = false,
            confirmedAt = null
        )

        val entity = IntegrationDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(integrationId, model.integrationId)
                assertEquals(account.playerName, model.account.playerName)
                assertEquals(name, model.name)
                assertEquals(value, model.value)
                assertEquals(integratedAt, model.integratedAt)
                assertEquals(confirm, model.isConfirmed())
                assertEquals(confirmedAt, model.getConfirmDate())
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = IntegrationEntity(
            integrationId = UUID.randomUUID(),
            account = AccountDbMapper.mapToEntity(Account(UUID.randomUUID(), "Notch")),
            name = "email",
            value = "test_mail@test.com",
            integratedAt = LocalDateTime.now(),
            confirm = false,
            confirmedAt = null
        )

        val model = IntegrationDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(integrationId, entity.integrationId)
                assertEquals(account.playerName, entity.account.playerName)
                assertEquals(name, entity.name)
                assertEquals(value, entity.value)
                assertEquals(integratedAt, entity.integratedAt)
                assertEquals(isConfirmed(), entity.confirm)
                assertEquals(getConfirmDate(), entity.confirmedAt)
            })
        }
    }

}
