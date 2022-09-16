package com.codedeco.feature.activityresultsample

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.navigator.ActivityResultSampleNavigator
import javax.inject.Inject

class ActivityResultSampleNavigatorImpl @Inject constructor() : ActivityResultSampleNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, ActivityResultSampleActivity::class.java)
    }

    override fun createFragment(): Fragment {
        return ActivityResultSampleFragment()
    }

    override fun createResult(result: ActivityResultSampleNavigator.Result): Intent {
        return Intent().apply {
            putExtra(Navigator.EXTRA_RESULT, result)
        }
    }

    override fun getResult(intent: Intent?): ActivityResultSampleNavigator.Result? {
        return runCatching {
            intent?.getParcelableExtra<ActivityResultSampleNavigator.Result>(Navigator.EXTRA_RESULT)
        }.getOrNull()
    }
}