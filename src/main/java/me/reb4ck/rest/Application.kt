package me.reb4ck.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication(scanBasePackages = ["me.reb4ck"])
open class Application
    fun main(args: Array<String>){
        SpringApplication.run(Application::class.java, *args)
    }