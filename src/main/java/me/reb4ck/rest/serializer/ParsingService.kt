package me.reb4ck.rest.serializer

interface ParsingService {
    fun <T> parse(url: String, tClass: Class<T>): T
}