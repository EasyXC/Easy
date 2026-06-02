package com.easy.demo

data class ApiItem(
    val id: Int,
    val name: String,
    val description: String,
    val tag: String = "",
    val isFavorite: Boolean = false
)