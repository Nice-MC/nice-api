package br.com.nicemc.account.adapter.entity

import br.com.nicemc.account.domain.enums.GroupType
import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account_group")
class GroupEntity(

    @field:Enumerated(EnumType.STRING)
    @field:Column(nullable = false)
    val type: GroupType,

    @field:Column(name = "defined_at", nullable = false)
    val definedAt: LocalDateTime,

    @field:Column(name = "defined_by", nullable = false)
    val definedBy: String,

    @field:Column(name = "is_permanent", nullable = false)
    val permanent: Boolean,

    @field:Column(name = "expires_in")
    val expiresIn: LocalDateTime?

) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.SEQUENCE)
    @field:Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null

}