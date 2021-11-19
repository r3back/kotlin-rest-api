package me.reb4ck.rest.controller.car

import me.reb4ck.rest.model.list.CarList.Companion.of
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import me.reb4ck.rest.serializer.ParsingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.ResponseEntity
import me.reb4ck.rest.model.list.CarList
import me.reb4ck.rest.model.Car
import org.springframework.beans.factory.annotation.Value
import java.util.stream.Collectors

@RestController
@RequestMapping
class CarController {
    @Autowired
    @Qualifier("parsingService")
    private val parsingService: ParsingService? = null

    @Value("\${cocoches.url}")
    private val cocochesUrl: String = ""

    @get:GetMapping("/get_ford_cars")
    val fordCards: ResponseEntity<*>
        get() = ResponseEntity.ok(of(
            parsingService!!.parse(cocochesUrl, CarList::class.java).carList
                ?.stream()
                ?.filter { (_, _, _, _, _, _, _, _, _, brandDescription) ->
                    brandDescription.equals(
                        "FORD",
                        ignoreCase = true
                    )
                }
                ?.collect(Collectors.toList())))
}