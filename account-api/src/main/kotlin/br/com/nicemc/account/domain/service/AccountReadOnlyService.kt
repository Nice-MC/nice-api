package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Account
import java.util.*

interface AccountReadOnlyService {

    fun findById(id: UUID): Optional<Account>

    fun findAll(): List<Account>

}