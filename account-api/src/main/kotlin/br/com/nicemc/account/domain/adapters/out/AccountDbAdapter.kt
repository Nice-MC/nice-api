package br.com.nicemc.account.domain.adapters.out

import br.com.nicemc.account.domain.model.Account
import java.util.*

interface AccountDbAdapter {

    fun findById(id: UUID): Optional<Account>
    fun findAll(): List<Account>
    fun create(account: Account): Account
    fun updateStatus(account: Account): Account
    fun updateSettings(account: Account): Account
    fun updateGroup(account: Account): Account

}