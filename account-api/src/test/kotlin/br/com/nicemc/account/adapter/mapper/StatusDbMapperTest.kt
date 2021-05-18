package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.StatusEntity
import br.com.nicemc.account.domain.model.Status
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class StatusDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a db entity`() {
        val status = Status(
            xpValue = 150,
            coinsValue = 270,
            cashValue = 360
        )

        val dbEntity = status.toDbEntity()

        with(dbEntity) {
            assertAll({
                assertEquals(xpValue.intValueExact(), status.xp.value)
                assertEquals(coinsValue.intValueExact(), status.coins.value)
                assertEquals(cashValue.intValueExact(), status.cash.value)
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val statusEntity = StatusEntity(
            xpValue = 1312.0.toBigDecimal(),
            coinsValue = 151.0.toBigDecimal(),
            cashValue = 6161.0.toBigDecimal()
        )

        val domain = statusEntity.toDomainModel()

        with(domain) {
            assertAll({
                assertEquals(xp.value, statusEntity.xpValue.intValueExact())
                assertEquals(coins.value, statusEntity.coinsValue.intValueExact())
                assertEquals(cash.value, statusEntity.cashValue.intValueExact())
            })
        }
    }
}