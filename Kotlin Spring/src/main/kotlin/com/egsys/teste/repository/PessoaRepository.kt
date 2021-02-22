package com.egsys.teste.repository

import com.egsys.teste.model.Pessoa
import org.springframework.data.repository.CrudRepository

interface PessoaRepository : CrudRepository<Pessoa,Long> {
}