package br.com.nicemc.account.domain.model

import br.com.nicemc.account.domain.enums.CurrencyType
import br.com.nicemc.account.domain.enums.Rank
import com.google.common.collect.ImmutableSet

class Status(
    xpValue: Int = 0,
    coinsValue: Int = 0,
    cashValue: Int = 0,
) {

    val xp: Currency = Currency(CurrencyType.XP, xpValue)
    val coins: Currency = Currency(CurrencyType.COINS, coinsValue)
    val cash: Currency = Currency(CurrencyType.CASH, cashValue)

    private val boosters: MutableSet<StatusBooster> = HashSet()

    var rank: Rank? = null
        private set

    init {
        updateRankByXp()
    }

    fun updateRankByXp() {
        this.rank = Rank.findByXp(xp.value)
    }

    fun addBooster(booster: StatusBooster) {
        this.boosters.add(booster)
    }

    fun removeBooster(booster: StatusBooster) {
        this.boosters.remove(booster)
    }

    fun getBoosters(): ImmutableSet<StatusBooster> = ImmutableSet.copyOf(boosters)
}