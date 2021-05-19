package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.PunishEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface PunishRepository : CrudRepository<PunishEntity, Long> {

    fun findByPunishId(punishId: UUID): Optional<PunishEntity>

    fun findAllByAccountPlayerUniqueId(id: UUID): List<PunishEntity>

    fun findAllByPunishedBy(id: UUID): List<PunishEntity>

}