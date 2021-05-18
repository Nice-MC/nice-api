package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Integration

interface IntegrationWriteOnlyService {

    fun create(integration: Integration): Integration

    fun update(integration: Integration): Integration

}