package com.example.webtoapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        configureWebViewSettings()

        // Load URL from webview_url.txt
        val url = loadWebViewUrl()
        url?.let { webView.loadUrl(it) }
    }

    private fun configureWebViewSettings() {
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Enable JavaScript if your website relies on it
        webView.webViewClient = WebViewClient()
    }

    private fun loadWebViewUrl(): String? {
        try {
            val inputStream = resources.openRawResource(R.raw.webview_url)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val url = reader.readLine()
            inputStream.close()
            return url
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}


