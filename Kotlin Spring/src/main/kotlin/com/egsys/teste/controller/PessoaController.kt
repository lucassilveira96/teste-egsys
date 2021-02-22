package com.egsys.teste.controller

import com.egsys.teste.model.ErrorMessage
import com.egsys.teste.model.Pessoa
import com.egsys.teste.advice.ErrorHandler
import com.egsys.teste.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/pessoa"])
class PessoaController {
    @Autowired
    lateinit var pessoaService: PessoaService

    @GetMapping()
    fun getAll(@RequestParam(required = false,defaultValue = "") localFilter: String): ResponseEntity<List<Pessoa>> {
        val listPessoas = this.pessoaService.getAll()
        val status= if (listPessoas.size==0) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(listPessoas,status)
    }


    @GetMapping("/{id}")
    fun getById(@PathVariable id:Long): ResponseEntity<Any> {
        val pessoa = pessoaService.getById(id)
        return if(pessoa != null)
            return ResponseEntity(pessoa, HttpStatus.OK)
        else
            return ResponseEntity(ErrorMessage("Pessoa não localizada", "Pessoa ${id} não localizada"), HttpStatus.NOT_FOUND)

    }

    @PostMapping()
    fun create(@RequestBody pessoa: Pessoa): ResponseEntity<Unit> {
        pessoaService.create(pessoa)
        var status = HttpStatus.CREATED
        return ResponseEntity(Unit,status)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.pessoaService.getById(id) != null){
            status = HttpStatus.ACCEPTED
            pessoaService.delete(id)
        }
        return ResponseEntity(Unit,status)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody pessoa: Pessoa): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.pessoaService.getById(id) != null){
            status = HttpStatus.ACCEPTED
            pessoaService.update(id,pessoa)
        }
        return ResponseEntity(Unit,status)
    }
    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String, Long>> =
        ResponseEntity.ok().body(mapOf("count" to this.pessoaService.count()))
}