package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.SettingsEntity
import io.micronaut.data.repository.CrudRepository

interface SettingsRepository: CrudRepository<SettingsEntity, Long>