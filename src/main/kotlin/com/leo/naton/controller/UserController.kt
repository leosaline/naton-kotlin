package com.leo.naton.controller

import com.leo.naton.UserDTO
import com.leo.naton.service.serviceImpl.UserServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserServiceImpl) {

    @GetMapping(produces = ["application/json"])
    @ResponseBody
    fun getAllUsers(): List<UserDTO> {
        return userService.findAll()
    }

    @PostMapping(
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewUser(@RequestBody userDTO: UserDTO): UserDTO {
        return userService.saveUser(userDTO)
    }

    @GetMapping("/{id}", produces = ["application/json"])
    @ResponseBody
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserDTO>? {
        val userDto = userService.getById(id)
        return if (userDto != null) {
            ResponseEntity.ok(userDto)
        } else {
            ResponseEntity.noContent().build();
        }
    }

    @PutMapping(
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateUser(@RequestBody userDTO: UserDTO): UserDTO {
        return userService.updateUser(userDTO)
    }

    @DeleteMapping("/{id}", produces = ["application/json"])
    @ResponseBody
    fun deleteUserById(@PathVariable id: Long) {
        userService.deleteById(id)
    }
}