package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.IntegrationDbAdapter
import br.com.nicemc.account.domain.model.Integration
import br.com.nicemc.account.domain.service.IntegrationReadOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class IntegrationReadOnlyServiceImpl(
    private val integrationDbAdapter: IntegrationDbAdapter
) : IntegrationReadOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun findById(id: UUID): Optional<Integration> {
        return integrationDbAdapter.findById(id).also {
            if (it.isEmpty) {
                logger.info("the integration was not found, returning empty")
            }
        }
    }

    override fun findAllByAccount(id: UUID): List<Integration> {
        return integrationDbAdapter.findAllByAccount(id).also {
            if (it.isEmpty()) {
                logger.info("searching for all integrations by account id $id returned an empty list")
            }
        }
    }

    override fun findAll(): List<Integration> {
        return integrationDbAdapter.findAll().also {
            if (it.isEmpty()) {
                logger.info("searching for all integrations returned an empty list")
            }
        }
    }
}