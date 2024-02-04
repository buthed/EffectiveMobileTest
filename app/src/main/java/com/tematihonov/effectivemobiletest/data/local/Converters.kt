package com.tematihonov.effectivemobiletest.data.local

import androidx.room.TypeConverter
import com.tematihonov.effectivemobiletest.domain.models.Feedback
import com.tematihonov.effectivemobiletest.domain.models.Info
import com.tematihonov.effectivemobiletest.domain.models.Price

class Converters {

    @TypeConverter
    fun feedbackToString(feedback: Feedback): String {
        return "${feedback.count},${feedback.rating}"
    }

    @TypeConverter
    fun stringToFeedback(value: String): Feedback {
        val parts = value.split(",")
        return Feedback(parts[0].toInt(), parts[1].toDouble())
    }

    @TypeConverter
    fun infoListToString(infoList: List<Info>): String {
        return infoList.joinToString(";") { "${it.title}:${it.value}" }
    }

    @TypeConverter
    fun stringToInfoList(value: String): List<Info> {
        val parts = value.split(";")
        return parts.map { part ->
            val (title, infoValue) = part.split(":")
            Info(title, infoValue)
        }
    }

    @TypeConverter
    fun priceToString(price: Price): String {
        return "${price.discount},${price.price},${price.priceWithDiscount},${price.unit}"
    }

    @TypeConverter
    fun stringToPrice(value: String): Price {
        val parts = value.split(",")
        return Price(parts[0].toInt(), parts[1], parts[2], parts[3])
    }

    @TypeConverter
    fun tagsToString(tags: List<String>): String {
        return tags.joinToString(",")
    }

    @TypeConverter
    fun stringToTags(value: String): List<String> {
        return value.split(",")
    }
}