package com.aaryo.brainrush.core.ads
interface AdsController { fun preloadInterstitial(); fun showRewarded(onReward: () -> Unit) }
class NoOpAdsController : AdsController { override fun preloadInterstitial() = Unit; override fun showRewarded(onReward: () -> Unit) = onReward() }
