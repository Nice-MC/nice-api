package br.com.nicemc.account.adapter

import br.com.nicemc.account.adapter.mapper.PunishDbMapper
import br.com.nicemc.account.adapter.persistence.PunishRepository
import br.com.nicemc.account.domain.adapters.out.PunishDbAdapter
import br.com.nicemc.account.domain.model.Punish
import java.util.*
import javax.inject.Singleton

@Singleton
class PunishDbAdapterImpl(
    private val punishRepository: PunishRepository
) : PunishDbAdapter {

    override fun findById(id: UUID): Optional<Punish> {
        return punishRepository.findByPunishId(id).map { PunishDbMapper.mapToModel(it) }
    }

    override fun findAllByPlayerId(id: UUID): List<Punish> {
        return punishRepository.findAllByAccountPlayerUniqueId(id).map { PunishDbMapper.mapToModel(it) }
    }

    override fun findAllByPunisher(id: UUID): List<Punish> {
        return punishRepository.findAllByPunishedBy(id).map { PunishDbMapper.mapToModel(it) }
    }

    override fun findAll(): List<Punish> {
        return punishRepository.findAll().map { PunishDbMapper.mapToModel(it) }
    }

    override fun create(punish: Punish): Punish {
        val dbEntity = PunishDbMapper.mapToEntity(punish)
        return PunishDbMapper.mapToModel(punishRepository.save(dbEntity))
    }

    override fun update(punish: Punish): Punish {
        val dbEntity = PunishDbMapper.mapToEntity(punish)
        return PunishDbMapper.mapToModel(punishRepository.update(dbEntity))
    }

}
