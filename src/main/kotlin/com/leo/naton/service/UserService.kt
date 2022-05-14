package com.leo.naton.service

import com.leo.naton.UserDTO
import com.leo.naton.entity.User

interface UserService {
    fun userDTO(user: User): UserDTO
    fun findAll(): List<UserDTO>
    fun saveUser(userDTO: UserDTO): UserDTO
    fun getById(id: Long): UserDTO?
    fun updateUser(userDTO: UserDTO): UserDTO
    fun deleteById(id: Long)
}