package com.aaryo.brainrush.core.analytics
interface AnalyticsTracker { fun track(event: String, params: Map<String, String> = emptyMap()) }
class NoOpAnalyticsTracker : AnalyticsTracker { override fun track(event: String, params: Map<String, String>) = Unit }
