package app.ayahbreak

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.TextView
import android.graphics.Color
import android.view.Gravity
import android.webkit.WebSettings

class MainActivity : Activity() {
    private lateinit var webView: WebView
    private val appUrl = "https://ayahbreak-cqvfjl.v2.appdeploy.ai/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(12, 21, 18)
        window.navigationBarColor = Color.rgb(12, 21, 18)
        window.decorView.systemUiVisibility = 0

        val container = FrameLayout(this)
        container.setBackgroundColor(Color.rgb(12, 21, 18))
        webView = WebView(this)
        webView.setBackgroundColor(Color.rgb(12, 21, 18))
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webView.settings.allowFileAccess = false
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url?.toString() ?: return false
                return !url.startsWith("https://ayahbreak-cqvfjl.v2.appdeploy.ai/") &&
                    !url.startsWith("https://api.alquran.cloud/") &&
                    !url.startsWith("https://fonts.googleapis.com/") &&
                    !url.startsWith("https://fonts.gstatic.com/")
            }
        }
        container.addView(webView, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))
        setContentView(container)
        if (savedInstanceState == null) webView.loadUrl(appUrl) else webView.restoreState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }

    override fun onDestroy() {
        if (this::webView.isInitialized) webView.destroy()
        super.onDestroy()
    }
}
