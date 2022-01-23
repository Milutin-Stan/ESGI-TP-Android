package stanojevic.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_product_details_nutritional_table.*

class ProductDetailsNutritionalValuesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_product_details_nutritional_table,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        val product: Product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product

        this.energy100.text = product.nutririonFactsItem.calories?.per100g.toString();
        this.energy.text = product.nutririonFactsItem.calories?.parPortion.toString();
        this.grasses100.text = product.nutririonFactsItem.grasSatures?.per100g.toString();
        this.grasses.text = product.nutririonFactsItem.grasSatures?.parPortion.toString();
        this.acide100.text = product.nutririonFactsItem.grasSatures?.per100g.toString();
        this.acide.text = product.nutririonFactsItem.grasSatures?.parPortion.toString();
        this.glucide100.text = product.nutririonFactsItem.glucides?.per100g.toString();
        this.glucide.text = product.nutririonFactsItem.glucides?.parPortion.toString();
        this.sucres100.text = product.nutririonFactsItem.sucre?.per100g.toString();
        this.sucres.text = product.nutririonFactsItem.sucre?.parPortion.toString();
        this.fibres100.text = product.nutririonFactsItem.fibre?.per100g.toString();
        this.fibres.text = product.nutririonFactsItem.fibre?.parPortion.toString();
        this.proteins100.text = product.nutririonFactsItem.proteines?.per100g.toString();
        this.proteins.text = product.nutririonFactsItem.proteines?.parPortion.toString();
        this.sel100.text = product.nutririonFactsItem.sel?.per100g.toString();
        this.sel.text = product.nutririonFactsItem.sel?.parPortion.toString();
        this.sodium100.text = product.nutririonFactsItem.sodium?.per100g.toString();
        this.sodium.text = product.nutririonFactsItem.sodium?.parPortion.toString();
    }
}