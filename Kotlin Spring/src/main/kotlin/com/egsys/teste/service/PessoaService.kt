package com.egsys.teste.service

import com.egsys.teste.model.Pessoa
import com.egsys.teste.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PessoaService: IPessoaService {
    @Autowired
    lateinit var pessoaRepository: PessoaRepository

    override fun create(pessoa: Pessoa) {
        pessoaRepository.save(pessoa)
    }

    override fun update(id: Long, pessoa: Pessoa) {
        create(pessoa)
    }

    override fun delete(id: Long) {
        pessoaRepository.deleteById(id)
    }

    override fun getById(id: Long): Pessoa?{
        return if(pessoaRepository.existsById(id))
            return pessoaRepository.findById(id).orElseGet(null)
        else null
    }

    override fun getAll(): List<Pessoa> {
        return pessoaRepository.findAll().toList()
    }

    override fun count(): Long {
        return pessoaRepository.count()
    }
}