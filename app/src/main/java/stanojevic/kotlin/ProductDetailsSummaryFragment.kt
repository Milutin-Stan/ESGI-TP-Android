package stanojevic.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details_summary.*

class ProductDetailsSummaryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsFragment: ProductDetailsFragment =
        requireParentFragment().requireParentFragment() as ProductDetailsFragment
        val product: Product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product

        Picasso.get().load(product?.url).into(imageView4)
        if(product.nutriscore == "A"){
            this.imageView5.setImageResource(R.drawable.nutri_score_a)
        }
        else if(product.nutriscore == "B"){
            this.imageView5.setImageResource(R.drawable.nutri_score_b)
        }
        else if(product.nutriscore == "C"){
            this.imageView5.setImageResource(R.drawable.nutri_score_c)
        }
        else if(product.nutriscore == "D"){
            this.imageView5.setImageResource(R.drawable.nutri_score_d)
        }
        else if(product.nutriscore == "E"){
            this.imageView5.setImageResource(R.drawable.nutri_score_e)
        }
        this.title.text = product?.nom
        this.subtitle.text = product?.marque
        this.product_barcode.setText(getString(R.string.product_barcode, product?.code_barres))
        this.quantite.setText(getString(R.string.quantity, product?.quantité))
        this.sold_in.setText(getString(R.string.sell_in, product?.liste_pays.joinToString()))
        this.ingredients.setText(getString(R.string.product_ingredients, product?.liste_ingredients.joinToString()))
        this.substances.setText(getString(R.string.product_substances, product?.liste_substances.joinToString()))
        this.additives.setText(getString(R.string.product_additive, product?.liste_aditifs.joinToString()))
    }


}