package com.rahulumak.mobiquity.mobiquityassignment.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class City(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city") val name: String?,
    @ColumnInfo(name = "latitude") val latitude: Double?,
    @ColumnInfo(name = "longitude") val longitude: Double?
):Parcelable {
    constructor(name: String?, latitude: Double?, longitude: Double?): this(0, name, latitude, longitude)
}
