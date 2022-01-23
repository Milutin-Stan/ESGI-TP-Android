package stanojevic.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_product_details_nutritional.*

class ProductDetailsNutritionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details_nutritional, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        val product: Product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product

        this.grasText.text = product.nutririonFactsItem.grasSatures?.per100g.toString() +
                product.nutririonFactsItem.glucides?.unite + " Matieres Grasses"
        this.acidText.text = product.nutririonFactsItem.grasSatures?.per100g.toString() +
                product.nutririonFactsItem.glucides?.unite + " Acides Saturés"
        this.sucreText.text = product.nutririonFactsItem.sucre?.per100g.toString() +
                product.nutririonFactsItem.sucre?.unite + " Sucres"
        this.selText.text = product.nutririonFactsItem.sel?.per100g.toString() +
                product.nutririonFactsItem.sel?.unite+ " Sel"
    }
}