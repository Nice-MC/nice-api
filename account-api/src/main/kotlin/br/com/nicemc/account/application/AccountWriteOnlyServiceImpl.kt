package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.AccountDbAdapter
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.service.AccountWriteOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class AccountWriteOnlyServiceImpl(
    private val accountDbAdapter: AccountDbAdapter
) : AccountWriteOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun createAccount(account: Account): Account {
        accountDbAdapter.create(account)
        return account.also {
            logger.info("account ${account.accountId} successfully persisted")
        }
    }

    override fun updateAccount(account: Account): Account {
        accountDbAdapter.updateStatus(account)
        accountDbAdapter.updateGroup(account)
        accountDbAdapter.updateSettings(account)
        return account.also {
            logger.info("account ${account.accountId} successfully updated all fields")
        }
    }

    override fun updateStatus(account: Account): Account {
        accountDbAdapter.updateStatus(account)
        return account.also {
            logger.info("account ${account.accountId} successfully updated status")
        }
    }

    override fun updateSettings(account: Account): Account {
        accountDbAdapter.updateSettings(account)
        return account.also {
            logger.info("account ${account.accountId} successfully updated settings")
        }
    }

    override fun updateGroup(account: Account): Account {
        accountDbAdapter.updateGroup(account)
        return account.also {
            logger.info("account ${account.accountId} successfully updated group")
        }
    }
}