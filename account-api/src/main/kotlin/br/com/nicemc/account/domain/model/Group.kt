package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.GroupType
import java.time.LocalDateTime

data class Group(
    val type: GroupType,
    val definedAt: LocalDateTime = LocalDateTime.now(),
    val definedBy: String,

    val isPermanent: Boolean,
    val expiresIn: LocalDateTime?
) {

    constructor() : this(
        type = GroupType.MEMBER,
        definedAt = LocalDateTime.now(),
        definedBy = "CONSOLE",
        isPermanent = true,
        expiresIn = null
    )
}