package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tematihonov.effectivemobiletest.utils.RoomConstants.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    val firstName: String,
    val secondName: String,
    val phoneNumber: String
)