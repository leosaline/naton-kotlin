package com.leo.naton.repository

import com.leo.naton.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}