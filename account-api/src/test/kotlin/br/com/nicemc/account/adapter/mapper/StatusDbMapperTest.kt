package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.StatusEntity
import br.com.nicemc.account.domain.model.Status
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class StatusDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Status(
            xpValue = 150,
            coinsValue = 270,
            cashValue = 360
        )

        val entity = StatusDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(xpValue.intValueExact(), model.xp.value)
                assertEquals(coinsValue.intValueExact(), model.coins.value)
                assertEquals(cashValue.intValueExact(), model.cash.value)
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = StatusEntity(
            xpValue = 1312.0.toBigDecimal(),
            coinsValue = 151.0.toBigDecimal(),
            cashValue = 6161.0.toBigDecimal()
        )

        val model = StatusDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(xp.value, entity.xpValue.intValueExact())
                assertEquals(coins.value, entity.coinsValue.intValueExact())
                assertEquals(cash.value, entity.cashValue.intValueExact())
            })
        }
    }
}