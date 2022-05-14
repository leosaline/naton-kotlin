package com.leo.naton.service.serviceImpl

import com.leo.naton.UserDTO
import com.leo.naton.entity.User
import com.leo.naton.repository.UserRepository
import com.leo.naton.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun userDTO(user: User): UserDTO {
        return UserDTO(
            user.id.toString(), user.userName, user.password, user.active, user.dateCreation, user.email
        );
    }

    override fun findAll(): List<UserDTO> {
        return userRepository.findAll().map { user -> this.userDTO(user) };
    }

    override fun saveUser(userDTO: UserDTO): UserDTO {
        val user = User(
            userName = userDTO.userName,
            password = userDTO.password,
            active = userDTO.active,
            dateCreation = Date(),
            email = userDTO.email
        );

        userRepository.save(user)
        return this.userDTO(user)
    }

    override fun updateUser(userDTO: UserDTO): UserDTO {
        val user = User(
            id = userDTO.id?.toLong(),
            userName = userDTO.userName,
            password = userDTO.password,
            active = userDTO.active,
            dateCreation = Date(),
            email = userDTO.email
        );

        userRepository.save(user)
        return this.userDTO(user)
    }

    override fun getById(id: Long): UserDTO? {
        val user = userRepository.findById(id);
        return if (user.isPresent) {
            this.userDTO(user.get());
        } else {
            null;
        }
    }

    override fun deleteById(id: Long) {
        userRepository.deleteById(id)
    }
}