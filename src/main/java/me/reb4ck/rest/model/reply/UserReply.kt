package me.reb4ck.rest.model.reply

import me.reb4ck.rest.model.User

class UserReply {
    var id: Long? = null
    var date: String? = null

    constructor(user: User) {
        id = user.id
        date = user.date
    }

    constructor() {}
}