package br.com.nicemc.account.adapter.entity

import br.com.nicemc.account.domain.enums.PunishType
import br.com.nicemc.account.domain.model.Account
import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account_punishes")
class PunishEntity(

    @field:Column(name = "punish_id", unique = true, updatable = false, nullable = false)
    val punishId: UUID,

    @field:ManyToOne
    val account: AccountEntity,

    @field:Column(nullable = false, updatable = false)
    val type: PunishType,

    @field:Column(nullable = false)
    val reason: String,

    @field:Column(nullable = false, updatable = false)
    val punishedBy: UUID,

    @field:Column(nullable = false, updatable = false)
    val punishedAt: LocalDateTime,

    @field:Column(nullable = false)
    val isPermanent: Boolean,

    @field:Column
    val expiresIn: LocalDateTime?,

    @field:Column(nullable = false)
    val isRemoved: Boolean,

    @field:Column
    val removedBy: String?,

    @field:Column
    val removedAt: LocalDateTime?
) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    @field:Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null

}