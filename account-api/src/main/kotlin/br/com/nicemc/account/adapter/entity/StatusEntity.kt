package br.com.nicemc.account.adapter.entity

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account_status")
class StatusEntity(

    @field:Column(name = "xp")
    val xpValue: BigDecimal,

    @field:Column(name = "coins")
    val coinsValue: BigDecimal,

    @field:Column(name = "cash")
    val cashValue: BigDecimal
) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.SEQUENCE)
    @field:Column(updatable = false, unique = true)
    val id: Long? = null

}