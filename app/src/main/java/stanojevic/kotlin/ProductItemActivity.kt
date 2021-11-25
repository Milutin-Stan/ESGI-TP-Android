package stanojevic.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_item)

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
    }
}