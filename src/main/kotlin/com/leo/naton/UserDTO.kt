package com.leo.naton

import java.util.*

data class UserDTO(
    var id: String? = null,
    var userName: String,
    var password: String,
    var active: Boolean,
    var dateCreation: Date?,
    var email: String?
)
