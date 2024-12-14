package com.nature_farm.android.homepage.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nature_farm.android.homepage.ui.detail.DescriptionFragment
import com.nature_farm.android.homepage.ui.detail.DetailProductFragment

class DetailProductTabLayoutAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DescriptionFragment()
            1 -> fragment = DetailProductFragment()


        }
        return fragment as Fragment
    }
}