package br.com.nicemc.account.domain.service

import br.com.nicemc.account.domain.model.Punish

interface PunishWriteOnlyService {

    fun create(punish: Punish): Punish

    fun update(punish: Punish): Punish

}