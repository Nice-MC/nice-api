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
    override fun `should return a db entity`() {
        val integration = Integration(
            integrationId = UUID.randomUUID(),
            account = Account(UUID.randomUUID(), "Notch"),
            name = "email",
            value = "test_mail@test.com",
            integratedAt = LocalDateTime.now(),
            confirm = false,
            confirmedAt = null
        )

        val dbEntity = IntegrationDbMapper.mapToEntity(integration)

        with(dbEntity) {
            assertAll({
                assertEquals(integrationId, integration.integrationId)
                assertEquals(account.playerName, integration.account.playerName)
                assertEquals(name, integration.name)
                assertEquals(value, integration.value)
                assertEquals(integratedAt, integration.integratedAt)
                assertEquals(confirm, integration.isConfirmed())
                assertEquals(confirmedAt, integration.getConfirmDate())
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val integrationEntity = IntegrationEntity(
            integrationId = UUID.randomUUID(),
            account = AccountDbMapper.mapToEntity(Account(UUID.randomUUID(), "Notch")),
            name = "email",
            value = "test_mail@test.com",
            integratedAt = LocalDateTime.now(),
            confirm = false,
            confirmedAt = null
        )

        val domain = IntegrationDbMapper.mapToModel(integrationEntity)

        with(domain) {
            assertAll({
                assertEquals(integrationId, integrationEntity.integrationId)
                assertEquals(account.playerName, integrationEntity.account.playerName)
                assertEquals(name, integrationEntity.name)
                assertEquals(value, integrationEntity.value)
                assertEquals(integratedAt, integrationEntity.integratedAt)
                assertEquals(isConfirmed(), integrationEntity.confirm)
                assertEquals(getConfirmDate(), integrationEntity.confirmedAt)
            })
        }
    }
}