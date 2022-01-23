package stanojevic.kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFacts(
    val calories: NutritionFactsItem? = null,
    val grasSatures: NutritionFactsItem? = null,
    val glucides: NutritionFactsItem? = null,
    val sucre: NutritionFactsItem? = null,
    val fibre: NutritionFactsItem? = null,
    val proteines: NutritionFactsItem? = null,
    val sel: NutritionFactsItem? = null,
    val sodium: NutritionFactsItem? = null,
) : Parcelable