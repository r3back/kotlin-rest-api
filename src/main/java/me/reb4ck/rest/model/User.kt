package me.reb4ck.rest.model

import java.text.SimpleDateFormat
import java.time.Clock
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity(name = "user")
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column
    var name: String = "",
    @Column
    var phone: String = "",
    @Column
    var email: String = "",
    @Column
    var date: String = "") {

    @PrePersist
    fun setDate() {
        val formato = SimpleDateFormat("dd/MM/yyyy")
        formato.timeZone = TimeZone.getTimeZone("UTC")
        val date = Date.from(Instant.now(Clock.systemUTC()))
        formato.applyPattern("dd-MM-yyyy")
        this.date = formato.format(date)
    }
}