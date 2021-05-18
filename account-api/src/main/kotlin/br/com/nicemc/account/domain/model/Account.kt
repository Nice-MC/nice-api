package br.com.nicemc.account.domain.model

import com.google.common.collect.ImmutableSet
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashSet

data class Account(
    val accountId: UUID,
    val playerName: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    val status: Status,
    val settings: Settings,
    val group: Group = Group(),
) {

    private val integrations: MutableSet<Integration> = HashSet()
    private val punishes: MutableSet<Punish> = HashSet()

    constructor(accountId: UUID, playerName: String): this(
        accountId = accountId,
        playerName = playerName,
        createdAt = LocalDateTime.now(),
        status = Status(),
        settings = Settings(),
        group = Group()
    )

    init {
        Validation<Account> {
            Account::playerName {
                minLength(2)
                maxLength(16)
            }
        }.validate(this)
    }

    fun addAllIntegrations(integrations: Set<Integration>) {
        this.integrations.addAll(integrations)
    }

    fun addIntegration(integration: Integration) {
        this.integrations.add(integration)
    }

    fun removeIntegration(integration: Integration) {
        this.integrations.remove(integration)
    }

    fun getIntegrations(): ImmutableSet<Integration> = ImmutableSet.copyOf(integrations)

    fun addAllPunishes(punish: Set<Punish>) {
        this.punishes.addAll(punish)
    }

    fun addPunish(punish: Punish) {
        this.punishes.add(punish)
    }

    fun removePunish(punish: Punish) {
        this.punishes.remove(punish)
    }

    fun getPunishes(): ImmutableSet<Punish> = ImmutableSet.copyOf(punishes)

    /**
     * Usages: id and playerName
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (playerName != other.playerName) return false
        if (accountId != other.accountId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = playerName.hashCode()
        result = 31 * result + accountId.hashCode()
        return result
    }
}