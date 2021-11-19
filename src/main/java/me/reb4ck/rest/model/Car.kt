package me.reb4ck.rest.model

data class Car(var ownerId: String? = "",
               var carId: String? = "",
               var title: String? = "",
               var doors: Int = 0,
               var cost: String = "",
               var url: String? = "",
               var fuelType: String? = "",
               var description: String? = "",
               var modelDescription: String? = "",
               var brandDescription: String? = "",
               var placeDescription: String? = "",
               var latitude: String = "",
               var longitude: String = "",
               var location: String? = "",
               var calificationsAvg: String = "",
               var currency: String? = "",
               var year: Int = 0,
               var rentsQuantity: Int = 0) {
}