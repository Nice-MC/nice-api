package br.com.nicemc.account.adapter.entity

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account_integrations")
class IntegrationEntity(

    @field:Column(name = "integration_id", unique = true, updatable = false, nullable = false)
    val integrationId: UUID,

    @field:ManyToOne
    val account: AccountEntity,

    @field:Column(nullable = false, updatable = false)
    val name: String,

    @field:Column(nullable = false, unique = true)
    val value: String,

    @field:Column(nullable = false, updatable = false)
    val integratedAt: LocalDateTime,

    @field:Column(nullable = false)
    val confirm: Boolean,

    @field:Column
    val confirmedAt: LocalDateTime?
) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.SEQUENCE)
    @field:Column(nullable = false, updatable = false, unique = true)
    val id: Long? = null

}