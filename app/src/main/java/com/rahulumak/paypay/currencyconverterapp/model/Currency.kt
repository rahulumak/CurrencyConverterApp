package com.rahulumak.paypay.currencyconverterapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Currency(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "code") val code: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "rate") val rate: Double?,
    @ColumnInfo(name = "timestamp") val timestamp: Long?,
):Parcelable{
    constructor(code: String?, name: String?): this(0, code, name, 0.0,0)
}
