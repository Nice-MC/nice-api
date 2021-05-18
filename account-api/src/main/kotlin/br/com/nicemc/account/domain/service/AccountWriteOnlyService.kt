package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Account

interface AccountWriteOnlyService {

    fun createAccount(account: Account): Account

    fun updateAccount(account: Account): Account

    fun updateStatus(account: Account): Account

    fun updateSettings(account: Account): Account

    fun updateGroup(account: Account): Account

}