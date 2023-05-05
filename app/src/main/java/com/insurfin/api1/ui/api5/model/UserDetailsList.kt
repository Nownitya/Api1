package com.insurfin.api1.ui.api5.model

data class UserDetailsList(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)