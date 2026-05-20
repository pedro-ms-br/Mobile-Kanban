package com.pedroMoraes.kanban.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task (
    var id: String = "",
    var description: String = "",
    // cria com to do por padrao
    var status: Status = Status.TODO

):Parcelable