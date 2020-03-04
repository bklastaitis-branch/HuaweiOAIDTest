package com.branch.example.android.huaweioaidtest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.huawei.hms.ads.identifier.AdvertisingIdClient
//import com.huawei.hms.ads.identifier.AdvertisingIdClient
//import com.huawei.hms.api.HuaweiApiAvailability
import io.branch.referral.Branch
import io.branch.referral.BranchError
import io.branch.referral.PrefHelper
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        GoogleApiAvailability.getInstance()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
    }

    override fun onStart() {
        super.onStart()
        PrefHelper.Debug("MainActivity.onStart")
        Branch.getInstance().initSession(branchListener, this.intent.data, this)

//        HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this)
//        getOaid(this, object : OaidCallback {
//            override fun onSuccess(id : String, isLimitAdTrackingEnabled : Boolean) {
//                PrefHelper.Debug("onSuccess, id = " + id + ", isLimitAdTrackingEnabled = " + isLimitAdTrackingEnabled)
//            }
//            override fun onFail(errorMessage : String) {
//                PrefHelper.Debug("onFail, errorMessage = " + errorMessage)
//            }
//        })
    }

    object branchListener : Branch.BranchReferralInitListener {
        override fun onInitFinished(referringParams: JSONObject?, error: BranchError?) {
            PrefHelper.Debug("referringParams = $referringParams, error = $error")
        }
    }

//    fun getOaid(context: Context?, callback: OaidCallback?) {
//        if (null == context || null == callback) {
//            PrefHelper.Debug("invalid input param")
//            return
//        }
//        try {
//            val info = AdvertisingIdClient.getAdvertisingIdInfo(context)
//            if (null != info) {
//                callback.onSuccess(info.id, info.isLimitAdTrackingEnabled)
//            } else {
//                callback.onFail("oaid is null")
//            }
//        } catch (e: IOException) {
//            PrefHelper.LogAlways("getAdvertisingIdInfo IOException")
//            callback.onFail("getAdvertisingIdInfo IOException")
//        }
//    }
//
//    interface OaidCallback {
//        fun onSuccess(id : String, isLimitAdTrackingEnabled : Boolean)
//        fun onFail(errorMessage : String)
//    }
}
