package com.ugurcangal.kisilerapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "kisiler")
data class Kisiler(
    @PrimaryKey(true)
    @ColumnInfo(name = "kisi_id") @NotNull
    var kisiId : Int,
    @ColumnInfo(name = "kisi_ad") @NotNull
    var kisiAd : String,
    @ColumnInfo(name = "kisi_tel") @NotNull
    var kisiTel : String
) : Serializable{
}