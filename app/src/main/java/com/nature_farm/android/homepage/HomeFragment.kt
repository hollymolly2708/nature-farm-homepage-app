package com.nature_farm.android.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nature_farm.android.homepage.databinding.FragmentHomeBinding
import com.nature_farm.android.homepage.recyclerview.ArticleAdapter
import com.nature_farm.android.homepage.recyclerview.CategoryAdapter
import com.nature_farm.android.homepage.recyclerview.ExclusiveBrandAdapter
import com.nature_farm.android.homepage.recyclerview.HealthConditionAdapter
import com.nature_farm.android.homepage.recyclerview.ProductAdapter
import com.nature_farm.android.homepage.utils.Data


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCategoryAdapter()
        setFlashSaleRecyclerView()
        setHealthConditionRecyclerView()
        setExclusiveBrandRecyclerView()
        setBestSellerRecyclerview()
        setArticleRecyclerview()
    }

    private fun setCategoryAdapter() {
        val adapter = CategoryAdapter(Data.categories())
        binding.rvCategories.adapter = adapter
        binding.rvCategories.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.setHasFixedSize(true)
    }

    private fun setFlashSaleRecyclerView() {
        val adapter = ProductAdapter(Data.products())
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProducts.setHasFixedSize(true)
    }

    private fun setHealthConditionRecyclerView(){
        val adapter = HealthConditionAdapter(Data.healthConditions())
        binding.rvHealthCondition.adapter = adapter
        binding.rvHealthCondition.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHealthCondition.setHasFixedSize(true)
    }
    private fun setExclusiveBrandRecyclerView(){
        val adapter = ExclusiveBrandAdapter(Data.exclusiveBrand())
        binding.rvExclusiveBrand.adapter = adapter
        binding.rvExclusiveBrand.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvExclusiveBrand.setHasFixedSize(true)

    }

    private fun setBestSellerRecyclerview(){
        val adapter = ProductAdapter(Data.products())
        binding.rvBestSellerProducts.adapter = adapter
        binding.rvBestSellerProducts.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBestSellerProducts.setHasFixedSize(true)
    }

    private fun setArticleRecyclerview(){
        val adapter = ArticleAdapter(Data.article())
        binding.rvArticle.adapter = adapter
        binding.rvArticle.layoutManager= LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvArticle.setHasFixedSize(true)
    }
}