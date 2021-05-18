package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.PunishType
import java.time.LocalDateTime
import java.util.*

data class Punish(
    val punishId: UUID,
    val punished: Account,

    val type: PunishType,
    val reason: String,
    val punishedBy: UUID,
    val punishedAt: LocalDateTime,

    val isPermanent: Boolean,
    val expiresIn: LocalDateTime?,

    private var isRemoved: Boolean,
    private var removedBy: String?,
    private var removedAt: LocalDateTime?
) {

    init {
        if ((isPermanent && expiresIn == null) || (!isPermanent && expiresIn != null)) {
            throw AssertionError("expire data is invalid.")
        }

        if ((isRemoved && (removedBy == null)) || (!isPermanent && expiresIn != null)) {
            throw AssertionError("removed data is invalid.")
        }
    }

    fun removePunish(author: String) {
        this.isRemoved = true
        this.removedBy = author
        this.removedAt = LocalDateTime.now()
    }

    fun isRemoved(): Boolean = isRemoved

    fun removedBy(): String? = removedBy

    fun removedAt(): LocalDateTime? = removedAt

}