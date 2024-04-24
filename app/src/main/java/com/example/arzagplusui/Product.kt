package com.example.arzagplusui

data class Product(
    val id: String,
    val name: String,
    val imageUrl: String,
    val specification: String,
    val price: Float,
    val category: String = "البحريات"
)
