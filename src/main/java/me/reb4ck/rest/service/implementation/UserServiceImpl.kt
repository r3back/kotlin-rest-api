package me.reb4ck.rest.service.implementation

import me.reb4ck.rest.model.User
import me.reb4ck.rest.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import me.reb4ck.rest.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service("userService")
@Transactional
open class UserServiceImpl : UserService {
    @Autowired
    private val repository: UserRepository? = null
    @Transactional(readOnly = true)
    override fun findAll(): List<User> {
        return repository!!.findAll()
    }

    override fun findByEmail(email: String): Optional<User> {
        return findAll().stream()
            .filter { (_, _, _, email1) -> email1.equals(email, ignoreCase = true) }
            .findFirst()
    }

    @Transactional
    override fun save(auto: User): User {
        return repository!!.save(auto)
    }
}