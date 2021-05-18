package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.AccountEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface AccountRepository : CrudRepository<AccountEntity, Long> {

    fun findByPlayerUniqueId(playerUniqueId: UUID): Optional<AccountEntity>

    fun findByPlayerName(playerName: String): Optional<AccountEntity>

}