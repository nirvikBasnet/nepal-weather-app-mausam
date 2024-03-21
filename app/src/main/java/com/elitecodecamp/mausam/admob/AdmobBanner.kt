package com.elitecodecamp.mausam.admob

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdmobBanner(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = { context ->

            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                //adUnitId = "ca-app-pub-3940256099942544/9214589741"
                adUnitId = "ca-app-pub-3873260443625418/3951995289"
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}