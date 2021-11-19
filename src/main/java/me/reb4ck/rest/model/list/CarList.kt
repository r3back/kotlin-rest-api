package me.reb4ck.rest.model.list

import me.reb4ck.rest.model.Car
import me.reb4ck.rest.model.list.CarList

class CarList {
    var carList: List<Car>? = null

    constructor() {}
    protected constructor(carList: List<Car>?) {
        this.carList = carList
    }

    companion object {
        @JvmStatic
        fun of(carList: List<Car>?): CarList {
            return CarList(carList)
        }
    }
}