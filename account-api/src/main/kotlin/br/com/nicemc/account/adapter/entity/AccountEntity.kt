package br.com.nicemc.account.adapter.entity

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account")
class AccountEntity(

    @field:Column(name = "player_uuid", unique = true, updatable = false, nullable = false)
    val playerUniqueId: UUID,

    @field:Column(name = "player_name", unique = true, updatable = false, nullable = false)
    val playerName: String,

    @field:Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: LocalDateTime

) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.SEQUENCE)
    @field:Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null

    @field:OneToOne(cascade = [CascadeType.ALL])
    var status: StatusEntity? = null

    @field:OneToOne(cascade = [CascadeType.ALL])
    var settings: SettingsEntity? = null

    @field:OneToOne(cascade = [CascadeType.ALL])
    var group: GroupEntity? = null

    @field:OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var integrations: Set<IntegrationEntity>? = null

    @field:OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var punishes: Set<PunishEntity>? = null

}