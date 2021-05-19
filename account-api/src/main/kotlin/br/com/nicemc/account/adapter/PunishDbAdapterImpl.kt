package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.mapper.toDbEntity
import br.com.nicemc.account.adapter.mapper.toDomainModel
import br.com.nicemc.account.adapter.persistence.PunishRepository
import br.com.nicemc.account.domain.adapters.out.PunishDbAdapter
import br.com.nicemc.account.domain.model.Punish
import java.util.*
import javax.inject.Singleton

@Singleton
open class PunishDbAdapterImpl(
    private val punishRepository: PunishRepository
) : PunishDbAdapter {

    override fun findById(id: UUID): Optional<Punish> {
        return punishRepository.findByPunishId(id).map { it.toDomainModel() }
    }

    override fun findAllByPlayerId(id: UUID): List<Punish> {
        return punishRepository.findAllByAccountPlayerUniqueId(id).map { it.toDomainModel() }
    }

    override fun findAllByPunisher(id: UUID): List<Punish> {
        return punishRepository.findAllByPunishedBy(id).map { it.toDomainModel() }
    }

    override fun findAll(): List<Punish> {
        return punishRepository.findAll().map { it.toDomainModel() }
    }

    override fun create(punish: Punish): Punish {
        val dbEntity = punish.toDbEntity()
        return punishRepository.save(dbEntity).toDomainModel()
    }

    override fun update(punish: Punish): Punish {
        val dbEntity = punish.toDbEntity()
        return punishRepository.update(dbEntity).toDomainModel()
    }
}