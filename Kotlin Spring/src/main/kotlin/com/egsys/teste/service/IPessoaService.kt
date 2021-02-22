package com.egsys.teste.service

import com.egsys.teste.model.Pessoa

interface IPessoaService {
    fun create(pessoa: Pessoa)
    fun update(id:Long, pessoa: Pessoa)
    fun delete(id: Long)
    fun getById(id: Long): Pessoa ?
    fun getAll(): List<Pessoa>
    fun count(): Long
}