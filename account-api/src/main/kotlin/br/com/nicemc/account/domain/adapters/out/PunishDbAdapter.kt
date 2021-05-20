package br.com.nicemc.account.domain.adapters.out

import br.com.nicemc.account.domain.model.Punish
import java.util.*

interface PunishDbAdapter {

    fun findById(id: UUID): Optional<Punish>
    fun findAllByPlayerId(id: UUID): List<Punish>
    fun findAllByPunisher(id: UUID): List<Punish>
    fun findAll(): List<Punish>
    fun create(punish: Punish): Punish
    fun update(punish: Punish): Punish

}