package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.PunishDbAdapter
import br.com.nicemc.account.domain.model.Punish
import br.com.nicemc.account.domain.service.PunishWriteOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class PunishWriteOnlyServiceImpl(
    private val punishDbAdapter: PunishDbAdapter
) : PunishWriteOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun create(punish: Punish): Punish {
        punishDbAdapter.create(punish)
        return punish.also {
            logger.info("punish ${punish.punishId} successfully persisted")
        }
    }

    override fun update(punish: Punish): Punish {
        punishDbAdapter.update(punish)
        return punish.also {
            logger.info("punish ${punish.punishId} successfully updated")
        }
    }
}