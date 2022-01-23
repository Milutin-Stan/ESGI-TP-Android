package stanojevic.kotlin

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_products_list,
            container,false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "A",
            "234kCal",
            "https://i.imgur.com/JhYpzdR.jpeg",
            "400 g (280 g net égoutté)",
            arrayOf("France", "Japon", "Suisse"),
            arrayOf(
                "Petits pois 66%",
                "eau",
                "garniture 2,8%",
                "salade",
                "oignon",
                "grelot",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            arrayOf("Aucune"),
            arrayOf("Aucune"),
            nutririonFactsItem = NutritionFacts(
                calories = NutritionFactsItem(unite = "kg", parPortion = 1, per100g = 120),
                grasSatures = NutritionFactsItem(unite = "g", parPortion = 0.6, per100g = 0.30),
                sucre = NutritionFactsItem(unite = "g", parPortion = 0.93, per100g = 0.20),
                sel = NutritionFactsItem(unite = "g", parPortion = 0.12, per100g = 0.50),
                glucides = NutritionFactsItem(unite = "g", parPortion = 0.54, per100g = 0.10),
                fibre = NutritionFactsItem(unite = "g", parPortion = 0.23, per100g = 0.70),
                proteines = NutritionFactsItem(unite = "g", parPortion = 0.23, per100g = 0.10),
                sodium = NutritionFactsItem(unite = "g", parPortion = 0.64, per100g = 0.123),
            )
        )

        val productKebab = Product(
            "Kebab",
            "Turc",
            "40593402950",
            "E",
            "1000kCal",
            "https://i.imgur.com/s2dHXJ6.jpeg",
            "400 g (280 g net égoutté)",
            arrayOf("93", "92", "91"),
            arrayOf(
                "Petits pois 66%",
                "eau",
                "garniture 2,8%",
                "salade",
                "oignon",
                "grelot",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            arrayOf("Aucune"),
            arrayOf("Aucune"),
            nutririonFactsItem = NutritionFacts(
                calories = NutritionFactsItem(unite = "kg", parPortion = 1, per100g = 520),
                grasSatures = NutritionFactsItem(unite = "g", parPortion = 0.5, per100g = 0.34),
                sucre = NutritionFactsItem(unite = "g", parPortion = 0.12, per100g = 0.63),
                sel = NutritionFactsItem(unite = "g", parPortion = 0.4, per100g = 0.12),
                glucides = NutritionFactsItem(unite = "g", parPortion = 0.6, per100g = 0.53),
                fibre = NutritionFactsItem(unite = "g", parPortion = 0.2, per100g = 0.12),
                proteines = NutritionFactsItem(unite = "g", parPortion = 0.42, per100g = 0.743),
                sodium = NutritionFactsItem(unite = "g", parPortion = 0.64, per100g = 0.12),
            )
        )
        val productPizza = Product(
            "Pizza",
            "Italiano",
            "40593402950",
            "C",
            "1000kCal",
            "https://i.imgur.com/VUEGlFp.jpeg",
            "400 g (280 g net égoutté)",
            arrayOf("93", "92", "91"),
            arrayOf(
                "Petits pois 66%",
                "eau",
                "garniture 2,8%",
                "salade",
                "oignon",
                "grelot",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            arrayOf("Aucune"),
            arrayOf("Aucune"),
            nutririonFactsItem = NutritionFacts(
                calories = NutritionFactsItem(unite = "kg", parPortion = 1, per100g = 300),
                grasSatures = NutritionFactsItem(unite = "g", parPortion = 0.2, per100g = 0.214),
                sucre = NutritionFactsItem(unite = "g", parPortion = 0.14, per100g = 0.642),
                sel = NutritionFactsItem(unite = "g", parPortion = 0.5, per100g = 0.3),
                glucides = NutritionFactsItem(unite = "g", parPortion = 0.67, per100g = 0.623),
                fibre = NutritionFactsItem(unite = "g", parPortion = 0.23, per100g = 0.346),
                proteines = NutritionFactsItem(unite = "g", parPortion = 0.5, per100g = 0.53),
                sodium = NutritionFactsItem(unite = "g", parPortion = 0.7, per100g = 0.6),
            )
        )


        val listProduct: Array<Product> = arrayOf(product, productKebab, productPizza)
        println("HENRI LE BG : " + listProduct)

        view.findViewById<RecyclerView>(R.id.recyclerview).apply {
            adapter = ListAdapter(listProduct, object : ItemClickListener{
                override fun onItemClicked(position: Int) {
                    println("Dans le on click de sa mere la pute qui me fais chier depuis 2 jours")
                    findNavController().navigate(
                        ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(listProduct[position])
                    )

                }
            }
            )
            layoutManager = GridLayoutManager(requireContext(), 1)

        }
    }


    class ListAdapter(val product: Array<Product>,
                      val listener: ItemClickListener) : RecyclerView.Adapter<ListItemCell>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
            return ListItemCell(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.food_card, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ListItemCell, position: Int) {

            Picasso.get().load(product[position].url).into(holder.url)
            holder.title.text = product[position].nom
            holder.subTitle.text = product[position].marque
            holder.nutriScore.text = "NutriScore : " + product[position].nutriscore
            holder.calories.text = "Calories : " + product[position].calories

            holder.itemView.setOnClickListener{
                Log.d("CLICKED", position.toString())
                listener.onItemClicked(position)
            }
        }

        override fun getItemCount(): Int {
            return product.size
        }

    }

    class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

        val url = v.findViewById<ImageView>(R.id.imageView)
        val title = v.findViewById<TextView>(R.id.title)
        val subTitle = v.findViewById<TextView>(R.id.subtitle)
        val nutriScore = v.findViewById<TextView>(R.id.nutrition_score)
        val calories = v.findViewById<TextView>(R.id.calory_score)

    }



    fun TextView.setBoldValue(value: String) {
        val index = value.indexOf(':')
        val spannable = SpannableString(value)

        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, index, 0)
        setText(spannable)
    }

    interface ItemClickListener {
        fun onItemClicked(position: Int)
    }


}


