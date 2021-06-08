package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.GroupEntity
import br.com.nicemc.account.domain.enums.GroupType
import br.com.nicemc.account.domain.model.Group
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class GroupDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a entity`() {
        val model = Group()

        val entity = GroupDbMapper.mapToEntity(model)

        with(entity) {
            assertAll({
                assertEquals(type, GroupType.MEMBER)
                assertEquals(definedAt, model.definedAt)
                assertEquals(definedBy, "CONSOLE")
                assertEquals(permanent, true)
                assertEquals(expiresIn, null)
            })
        }
    }

    @Test
    override fun `should return a model`() {
        val entity = GroupEntity(
            type = GroupType.MEMBER,
            definedAt = LocalDateTime.now(),
            definedBy = "CONSOLE",
            permanent = true,
            expiresIn = null
        )

        val model = GroupDbMapper.mapToModel(entity)

        with(model) {
            assertAll({
                assertEquals(type, GroupType.MEMBER)
                assertEquals(definedAt, entity.definedAt)
                assertEquals(definedBy, "CONSOLE")
                assertEquals(isPermanent, true)
                assertEquals(expiresIn, null)
            })
        }
    }
}