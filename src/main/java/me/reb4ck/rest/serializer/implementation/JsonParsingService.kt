package me.reb4ck.rest.serializer.implementation

import me.reb4ck.rest.serializer.ParsingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service("parsingService")
class JsonParsingService : ParsingService {
    @Autowired
    private val restTemplate: RestTemplate? = null
    override fun <T> parse(url: String, tClass: Class<T>): T {
        return restTemplate!!.getForObject(url, tClass)
    }
}