package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.persistence.AccountRepository
import br.com.nicemc.account.domain.adapters.out.AccountDbAdapter
import br.com.nicemc.account.domain.model.Account
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

@MicronautTest
internal class AccountDbAdapterImplTest(
    private val accountRepository: AccountRepository,
    private val accountDbAdapter: AccountDbAdapter
) {

    companion object {
        val ID: UUID = UUID.randomUUID()
    }

    @AfterEach
    fun setup() {
        accountRepository.deleteAll()
    }

    @Test
    fun `should find account by id`() {
        val account = Account(
            accountId = ID,
            playerName = "Notch"
        )

        accountDbAdapter.create(account)

        with(accountDbAdapter.findById(ID)) {
            assertTrue(isPresent)
            assertEquals(get().playerName, account.playerName)
        }
    }

}
