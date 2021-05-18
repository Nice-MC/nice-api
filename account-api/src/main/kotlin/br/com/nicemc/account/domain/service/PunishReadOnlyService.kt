package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Punish
import java.util.*

interface PunishReadOnlyService {

    fun findById(id: UUID): Optional<Punish>

    fun findAllByPlayerId(id: UUID): List<Punish>

    fun findAllByPunisher(id: UUID): List<Punish>

    fun findAll(): List<Punish>

}