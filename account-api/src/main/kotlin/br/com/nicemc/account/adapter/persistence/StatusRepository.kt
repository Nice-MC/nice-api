package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.StatusEntity
import io.micronaut.data.repository.CrudRepository

interface StatusRepository: CrudRepository<StatusEntity, Long>