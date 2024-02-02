package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Entity
import com.tematihonov.effectivemobiletest.utils.RoomConstants.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    val firstName: String,
    val secondName: String,
    val phoneNumber: String
)