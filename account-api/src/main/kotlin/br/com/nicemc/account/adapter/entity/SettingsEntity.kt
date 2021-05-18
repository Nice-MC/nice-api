package br.com.nicemc.account.adapter.entity

import br.com.nicemc.account.domain.enums.Language
import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Introspected
@Entity
@Table(name = "account_settings")
class SettingsEntity(

    @field:Column(name = "receive_private_messages", nullable = false)
    val receivePrivateMessages: Boolean,

    @field:Column(name = "receive_chat_messages", nullable = false)
    val receiveChatMessages: Boolean,

    @field:Column(name = "receive_alerts", nullable = false)
    val receiveAlerts: Boolean,

    @field:Enumerated(EnumType.STRING)
    @field:Column(nullable = false)
    val language: Language
) {

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    @field:Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null

}