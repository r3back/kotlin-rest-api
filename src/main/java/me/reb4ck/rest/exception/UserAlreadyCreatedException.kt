package me.reb4ck.rest.exception

import java.lang.RuntimeException

class UserAlreadyCreatedException(message: String?) : RuntimeException(message)