package com.leo.naton.entity

import java.util.*
import javax.persistence.*

@Table(name = "user")
@Entity
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,
    open var userName: String = "",
    open var password: String = "",
    open var active: Boolean = false,
    open var dateCreation: Date? = Date(),
    open var email: String? = null
)
