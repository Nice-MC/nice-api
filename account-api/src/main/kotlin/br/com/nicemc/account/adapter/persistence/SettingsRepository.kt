package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.SettingsEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface SettingsRepository: CrudRepository<SettingsEntity, Long>