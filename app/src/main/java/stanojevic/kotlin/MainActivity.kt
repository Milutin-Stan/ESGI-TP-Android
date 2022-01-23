package stanojevic.kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        val toast = Toast.makeText(applicationContext, "Hello World", Toast.LENGTH_LONG)
        toast.show()

        //Picasso.get().load("https://i.imgur.com/JhYpzdR.jpeg").into(imageView4)

        //findViewById<TextView>(R.id.title).setText(product.nom)
        //findViewById<TextView>(R.id.subtitle).setText(product.marque)

        /*product_barcode.setBoldValue(
            getString(R.string.product_barcode, product.code_barres)
        )
        quantite.setBoldValue(
            getString(R.string.quantity, product.quantité)
        )
        sold_in.setBoldValue(
            getString(R.string.sell_in, product.liste_pays.toString())
        )
        ingredients.setBoldValue(
            getString(R.string.product_ingredients, product.liste_ingredients)
        )
        substances.setBoldValue(
            getString(R.string.product_substances, product.liste_substances)
        )
        additives.setBoldValue(
            getString(R.string.product_additive, product.liste_aditifs)
        )*/
/*
        findViewById<RecyclerView>(R.id.main_list).run {
            adapter = ListAdapter(listProduct, listener = object : ItemClickListener{
                override fun onItemClicked(position: Int) {
                    val intent = Intent(context, ProductItemActivity::class.java).apply {
                        startActivity(intent)
                    }
                }
            })
            layoutManager = LinearLayoutManager(this@MainActivity)

        }

    }
    class ListAdapter(val product: List<Product>, val listener: ItemClickListener) : RecyclerView.Adapter<ListItemCell>() {

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

    interface ItemClickListener{
        fun onItemClicked(position: Int)
    }*/
    }
}