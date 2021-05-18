package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Integration
import java.util.*

interface IntegrationReadOnlyService {

    fun findById(id: UUID): Optional<Integration>

    fun findAllByAccount(id: UUID): List<Integration>

    fun findAll(): List<Integration>

}