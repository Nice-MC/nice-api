package br.com.nicemc.account.adapter.persistence

import br.com.nicemc.account.adapter.entity.GroupEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface GroupRepository: CrudRepository<GroupEntity, Long>