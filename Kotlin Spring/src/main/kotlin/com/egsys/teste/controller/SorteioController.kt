package com.egsys.teste.controller

import com.egsys.teste.model.Sorteio
import com.fasterxml.jackson.annotation.JsonAnyGetter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping(value=["/sorteio"])
class SorteioController {

    @PostMapping()
    fun sorteador(@RequestBody sorteio:Sorteio):ResponseEntity<Int>{
        return ResponseEntity((sorteio.valorMinimo..sorteio.valorMaximo).random(),HttpStatus.OK)

    }

}
