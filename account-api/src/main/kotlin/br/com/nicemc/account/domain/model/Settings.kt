package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.Language

data class Settings(
    var receivePrivateMessages: Boolean,
    var receiveChatMessages: Boolean,
    var receiveAlerts: Boolean,
    var language: Language
) {

    constructor() : this(
        receivePrivateMessages = true,
        receiveChatMessages = true,
        receiveAlerts = true,
        language = Language.PORTUGUESE
    )
}