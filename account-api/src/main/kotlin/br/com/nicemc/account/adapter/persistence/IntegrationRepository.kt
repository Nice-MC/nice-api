package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.IntegrationEntity
import io.micronaut.data.repository.CrudRepository
import java.util.*

interface IntegrationRepository : CrudRepository<IntegrationEntity, Long> {

    fun findByIntegrationId(integrationId: UUID): Optional<IntegrationEntity>

    fun findAllByAccountPlayerUniqueId(id: UUID): List<IntegrationEntity>

}