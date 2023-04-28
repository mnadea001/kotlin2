package com.example.myapplication

import java.io.Serializable

class Magasin(
    val storeId: String,
    val name: String,
    val description: String,
    val pictureStore: String,
    val address: String,
    val zipcode: String,
    val city: String,
    val longitude: Double,
    val latitude: Double,
): Serializable



