package stanojevic.kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFactsItem(
    val unite: String? = "",
    val parPortion: Number? = 0,
    val per100g: Number? = 0
) : Parcelable
