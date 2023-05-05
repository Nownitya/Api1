package com.insurfin.api1.ui.api3.model

data class UserData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
//    val support: Support,
    val total: Int,
    val total_pages: Int
)