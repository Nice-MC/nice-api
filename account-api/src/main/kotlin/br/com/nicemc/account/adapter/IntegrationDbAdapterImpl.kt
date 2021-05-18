package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.mapper.toDbEntity
import br.com.nicemc.account.adapter.mapper.toDomainModel
import br.com.nicemc.account.adapter.persistence.IntegrationRepository
import br.com.nicemc.account.domain.adapters.out.IntegrationDbAdapter
import br.com.nicemc.account.domain.model.Integration
import java.util.*
import javax.inject.Singleton

@Singleton
class IntegrationDbAdapterImpl(
    private val integrationRepository: IntegrationRepository
) : IntegrationDbAdapter {

    override fun findById(id: UUID): Optional<Integration> {
        return integrationRepository.findByIntegrationId(id).map { it.toDomainModel() }
    }

    override fun findAllByAccount(id: UUID): List<Integration> {
        return integrationRepository.findAllByAccountPlayerUniqueId(id).map { it.toDomainModel() }
    }

    override fun findAll(): List<Integration> {
        return integrationRepository.findAll().map { it.toDomainModel() }
    }

    override fun create(integration: Integration): Integration {
        val dbEntity = integration.toDbEntity()
        return integrationRepository.save(dbEntity).toDomainModel()
    }

    override fun update(integration: Integration): Integration {
        val dbEntity = integration.toDbEntity()
        return integrationRepository.update(dbEntity).toDomainModel()
    }
}