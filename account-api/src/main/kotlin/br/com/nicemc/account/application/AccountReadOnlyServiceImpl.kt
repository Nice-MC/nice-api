package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.AccountDbAdapter
import br.com.nicemc.account.domain.model.Account
import br.com.nicemc.account.domain.service.AccountReadOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class AccountReadOnlyServiceImpl(
    private val accountDbAdapter: AccountDbAdapter
) : AccountReadOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun findById(id: UUID): Optional<Account> {
        return accountDbAdapter.findById(id).also {
            if (it.isEmpty) {
                logger.info("the account $id was not found, returning empty")
            }
        }
    }

    override fun findAll(): List<Account> {
        return accountDbAdapter.findAll().also {
            if (it.isEmpty()) {
                logger.info("searching for all accounts returned an empty list")
            }
        }
    }

}