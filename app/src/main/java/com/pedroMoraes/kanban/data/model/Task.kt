package com.pedroMoraes.kanban.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task (
    val id: String,
    val description: String,
    // cria com to do por padrao
    val status: Status = Status.TODO

):Parcelable