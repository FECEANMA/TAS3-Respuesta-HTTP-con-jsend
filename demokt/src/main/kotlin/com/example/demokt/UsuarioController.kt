package com.example.demokt

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    @GetMapping("/{id}")
    fun crearUsuario(
        @PathVariable("id") id: Int,
        @RequestParam(value = "origen", defaultValue = "desconocido") origen: String,
        @RequestBody usuario: Usuario
    ): ResponseEntity<Map<String, Any>> {
        val response = mapOf(
            "status" to "success",
            "data" to mapOf(
                "id" to id,
                "name" to usuario.name,
                "age" to usuario.age,
                "origen" to origen
            ),
            "message" to "Usuario creado exitosamente."
        )
        return ResponseEntity.ok(response)
    }
}