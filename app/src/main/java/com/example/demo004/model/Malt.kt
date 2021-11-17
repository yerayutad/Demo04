package com.example.demo004.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Malt(
    @SerializedName("amount")
    @Expose
    val amount: AmountX,
    @SerializedName("name")
    @Expose
    val name: String
)