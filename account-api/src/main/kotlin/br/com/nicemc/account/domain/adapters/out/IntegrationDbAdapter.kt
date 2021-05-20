package br.com.nicemc.account.domain.adapters.out

import br.com.nicemc.account.domain.model.Integration
import java.util.*

interface IntegrationDbAdapter {

    fun findById(id: UUID): Optional<Integration>
    fun findAllByAccount(id: UUID): List<Integration>
    fun findAll(): List<Integration>
    fun create(integration: Integration): Integration
    fun update(integration: Integration): Integration

}