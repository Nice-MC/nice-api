package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.IntegrationDbAdapter
import br.com.nicemc.account.domain.model.Integration
import br.com.nicemc.account.domain.service.IntegrationWriteOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class IntegrationWriteOnlyServiceImpl(
    private val integrationDbAdapter: IntegrationDbAdapter
) : IntegrationWriteOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun create(integration: Integration): Integration {
        return integrationDbAdapter.create(integration).also {
            logger.info("integration ${integration.integrationId} successfully persisted")
        }
    }

    override fun update(integration: Integration): Integration {
        return integrationDbAdapter.update(integration).also {
            logger.info("integration ${integration.integrationId} successfully updated")
        }
    }
}