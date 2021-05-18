package br.com.nicemc.account.domain.model

import java.time.LocalDateTime
import java.util.*

data class Integration(
    val integrationId: UUID,
    val account: Account,
    val name: String,
    val value: String,
    val integratedAt: LocalDateTime = LocalDateTime.now(),
    private var confirm: Boolean,
    private var confirmedAt: LocalDateTime?
) {

    constructor(integrationId: UUID, account: Account, name: String, value: String) : this(
        integrationId = integrationId,
        account = account,
        name = name,
        value = value,
        integratedAt = LocalDateTime.now(),
        confirm = false,
        confirmedAt = null
    )

    init {
        if ((confirm && confirmedAt == null) || (!confirm && confirmedAt != null)) {
            throw AssertionError("confirmation data is invalid.")
        }
    }

    fun confirmIntegration() {
        this.confirm = true
        this.confirmedAt = LocalDateTime.now()
    }

    fun isConfirmed() = confirm

    fun getConfirmDate() = confirmedAt

}