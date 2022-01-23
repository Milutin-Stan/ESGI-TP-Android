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
            arrayOf("Aucune")
        )

        val productKebab = Product(
            "Kebab",
            "Turc",
            "40593402950",
            "GROS",
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
            arrayOf("Aucune")
        )


        val listProduct: Array<Product> = arrayOf(product, productKebab)

        view.findViewById<RecyclerView>(R.id.recyclerview).run {
            val listAdapter = ListAdapter(listProduct, object : ItemClickListener{
                override fun onItemClicked(position: Int) {
                    Log.d("Produit", position.toString())
                    //findNavController().navigate(
                   //     ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(listProduct[position])
                  //  )

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


