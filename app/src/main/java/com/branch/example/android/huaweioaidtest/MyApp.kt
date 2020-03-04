package com.branch.example.android.huaweioaidtest

import android.app.Application
//import com.huawei.hms.ads.HwAds
import io.branch.referral.Branch
import io.branch.referral.PrefHelper

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Branch.enableLogging()
        Branch.getAutoInstance(this)
//        Branch.setPlayStoreReferrerCheckTimeout(0)
//        HwAds.init(this)
    }
}