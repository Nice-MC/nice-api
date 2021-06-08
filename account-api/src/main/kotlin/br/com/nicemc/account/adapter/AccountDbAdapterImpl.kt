package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.mapper.AccountDbMapper
import br.com.nicemc.account.adapter.persistence.AccountRepository
import br.com.nicemc.account.adapter.persistence.GroupRepository
import br.com.nicemc.account.adapter.persistence.SettingsRepository
import br.com.nicemc.account.adapter.persistence.StatusRepository
import br.com.nicemc.account.domain.adapters.out.AccountDbAdapter
import br.com.nicemc.account.domain.exceptions.AccountGroupNotFoundException
import br.com.nicemc.account.domain.exceptions.AccountNotFoundException
import br.com.nicemc.account.domain.exceptions.AccountSettingsNotFoundException
import br.com.nicemc.account.domain.exceptions.AccountStatusNotFoundException
import br.com.nicemc.account.domain.model.Account
import java.util.*
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class AccountDbAdapterImpl(
    private val accountRepository: AccountRepository,
    private val statusRepository: StatusRepository,
    private val settingsRepository: SettingsRepository,
    private val groupRepository: GroupRepository
) : AccountDbAdapter {

    override fun findById(id: UUID): Optional<Account> {
        return accountRepository.findByPlayerUniqueId(id).map { AccountDbMapper.mapToModel(it) }
    }

    override fun findAll(): List<Account> {
        return accountRepository.findAll().map { AccountDbMapper.mapToModel(it) }
    }

    override fun create(account: Account): Account {
        val dbEntity = AccountDbMapper.mapToEntity(account)
        return AccountDbMapper.mapToModel(accountRepository.save(dbEntity))
    }

    @Transactional
    override fun updateStatus(account: Account): Account {
        val persistedAccount = accountRepository.findByPlayerUniqueId(account.accountId)
            .orElseThrow { throw AccountNotFoundException() }

        statusRepository.update(persistedAccount.status ?: throw AccountStatusNotFoundException())
        return account
    }

    @Transactional
    override fun updateSettings(account: Account): Account {
        val persistedAccount = accountRepository.findByPlayerUniqueId(account.accountId)
            .orElseThrow { throw AccountNotFoundException() }

        settingsRepository.update(persistedAccount.settings ?: throw AccountSettingsNotFoundException())
        return account
    }

    @Transactional
    override fun updateGroup(account: Account): Account {
        val persistedAccount = accountRepository.findByPlayerUniqueId(account.accountId)
            .orElseThrow { throw AccountNotFoundException() }

        groupRepository.update(persistedAccount.group ?: throw AccountGroupNotFoundException())
        return account
    }

}
