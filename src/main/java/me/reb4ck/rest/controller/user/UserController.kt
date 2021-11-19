package me.reb4ck.rest.controller.user

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import me.reb4ck.rest.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import me.reb4ck.rest.exception.UserAlreadyCreatedException
import me.reb4ck.rest.model.User
import org.springframework.http.HttpStatus
import me.reb4ck.rest.model.reply.UserReply
import java.util.*

@RestController
@RequestMapping
class UserController {
    @Autowired
    private val userService: UserService? = null
    @PostMapping("/create_user")
    fun create(@RequestBody user: User): ResponseEntity<*> {
        var optionalUser = userService!!.findByEmail(user.email)
        return if (optionalUser.isPresent) {
            throw UserAlreadyCreatedException("You Already created an user with that email!")
        } else {
            optionalUser = Optional.ofNullable(userService.save(user))
            if (optionalUser.isPresent) ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserReply(optionalUser.get())) else ResponseEntity
                .notFound()
                .build<Any>()
        }
    }
}