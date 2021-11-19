package me.reb4ck.rest.service

import me.reb4ck.rest.model.User
import java.util.*

interface UserService {
    fun findAll(): List<User>
    fun findByEmail(email: String): Optional<User>
    fun save(auto: User): User
}