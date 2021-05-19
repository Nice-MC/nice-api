package br.com.nicemc.account.adapter.mapper

import br.com.nicemc.account.adapter.entity.GroupEntity
import br.com.nicemc.account.domain.enums.GroupType
import br.com.nicemc.account.domain.model.Group
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class GroupDbMapperTest : EntityMapperTest {

    @Test
    override fun `should return a db entity`() {
        val group = Group()

        val dbEntity = group.toDbEntity()

        with(dbEntity) {
            assertAll({
                assertEquals(type, GroupType.MEMBER)
                assertEquals(definedAt, group.definedAt)
                assertEquals(definedBy, "CONSOLE")
                assertEquals(permanent, true)
                assertEquals(expiresIn, null)
            })
        }
    }

    @Test
    override fun `should return a domain model`() {
        val groupEntity = GroupEntity(
            type = GroupType.MEMBER,
            definedAt = LocalDateTime.now(),
            definedBy = "CONSOLE",
            permanent = true,
            expiresIn = null
        )

        val domain = groupEntity.toDomainModel()

        with(domain) {
            assertAll({
                assertEquals(type, GroupType.MEMBER)
                assertEquals(definedAt, groupEntity.definedAt)
                assertEquals(definedBy, "CONSOLE")
                assertEquals(isPermanent, true)
                assertEquals(expiresIn, null)
            })
        }
    }
}