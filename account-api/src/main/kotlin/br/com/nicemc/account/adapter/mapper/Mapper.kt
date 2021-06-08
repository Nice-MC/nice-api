package br.com.nicemc.account.adapter.mapper

interface Mapper<M, E> {

    fun mapToEntity(model: M): E

    fun mapToModel(entity: E): M

}