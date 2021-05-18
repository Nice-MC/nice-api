package br.com.nicemc.account.application

import br.com.nicemc.account.domain.adapters.out.PunishDbAdapter
import br.com.nicemc.account.domain.model.Punish
import br.com.nicemc.account.domain.service.PunishReadOnlyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class PunishReadOnlyServiceImpl(
    private val punishDbAdapter: PunishDbAdapter
) : PunishReadOnlyService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun findById(id: UUID): Optional<Punish> {
        return punishDbAdapter.findById(id).also {
            if (it.isEmpty) {
                logger.info("the punish $id was not found, returning empty")
            }
        }
    }

    override fun findAllByPlayerId(id: UUID): List<Punish> {
        return punishDbAdapter.findAllByPlayerId(id).also {
            if (it.isEmpty()) {
                logger.info("searching for all punishes by player id $id returned an empty list")
            }
        }
    }

    override fun findAllByPunisher(id: UUID): List<Punish> {
        return punishDbAdapter.findAllByPunisher(id).also {
            if (it.isEmpty()) {
                logger.info("searching for all punishes by punisher id $id returned an empty list")
            }
        }
    }

    override fun findAll(): List<Punish> {
        return punishDbAdapter.findAll().also {
            if (it.isEmpty()) {
                logger.info("searching for all punishes returned an empty list")
            }
        }
    }
}