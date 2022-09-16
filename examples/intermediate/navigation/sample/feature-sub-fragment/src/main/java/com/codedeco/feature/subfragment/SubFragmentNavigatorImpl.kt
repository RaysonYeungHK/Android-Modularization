package com.codedeco.feature.subfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.navigator.SubFragmentNavigator
import javax.inject.Inject

class SubFragmentNavigatorImpl @Inject constructor() : SubFragmentNavigator {
    override fun createFragment(param: SubFragmentNavigator.Param): Fragment {
        return SubFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Navigator.EXTRA_PARAM, param)
            }
        }
    }

    override fun getParam(bundle: Bundle?): SubFragmentNavigator.Param? {
        return runCatching {
            bundle?.getParcelable<SubFragmentNavigator.Param>(Navigator.EXTRA_PARAM)
        }.getOrNull()
    }
}