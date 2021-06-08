package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.mapper.IntegrationDbMapper
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
        return integrationRepository.findByIntegrationId(id).map { IntegrationDbMapper.mapToModel(it) }
    }

    override fun findAllByAccount(id: UUID): List<Integration> {
        return integrationRepository.findAllByAccountPlayerUniqueId(id).map { IntegrationDbMapper.mapToModel(it) }
    }

    override fun findAll(): List<Integration> {
        return integrationRepository.findAll().map { IntegrationDbMapper.mapToModel(it) }
    }

    override fun create(integration: Integration): Integration {
        val dbEntity = IntegrationDbMapper.mapToEntity(integration)
        return IntegrationDbMapper.mapToModel(integrationRepository.save(dbEntity))
    }

    override fun update(integration: Integration): Integration {
        val dbEntity = IntegrationDbMapper.mapToEntity(integration)
        return IntegrationDbMapper.mapToModel(integrationRepository.update(dbEntity))
    }

}
