package uz.juo.currerapp.models

import android.location.Location

class Order(
    var id: Int,
    var from: String,
    var to: String,
    var curier: Curier,
    var oder_price: String,
    var delivery_price: String,
    var location: Location,
    var necessary: Boolean
)