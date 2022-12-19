package alpha.dex.dexcard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnCopy = findViewById<Button>(R.id.btnCopy)
        val card = findViewById<WebView>(R.id.card)
        val shareRepo = findViewById<Button>(R.id.shareRepo)
        val shareAppTxt = findViewById<Button>(R.id.shareAppTxt)
        val shareLinkTxt = findViewById<Button>(R.id.shareLinkTxt)


        val completeUrl = intent.getStringExtra("url")
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager


        if (completeUrl != null) {
            card.loadUrl(completeUrl)
        }


        btnBack.setOnClickListener(){
            onBackPressed()
            finish()
        }
        btnCopy.setOnClickListener(){
            val clipData = ClipData.newPlainText("url",completeUrl)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this,"Url copied!",Toast.LENGTH_SHORT).show()
        }
        shareRepo.setOnClickListener(){
            val url = "https://github.com/deveshp007/DeX-Card"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(url), "text/plain")
            val choose = Intent.createChooser(intent, "Share URL")
            startActivity(choose)
        }
        shareAppTxt.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SEND)
            val url = "https://github.com/deveshp007/DeX-Card/releases/download/v0.0.1-alpha/dex-card.apk"
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Hey, Checkout this github stats card making app. $url"
            )
            val chooser = Intent.createChooser(intent, "Share this app using...")
            startActivity(chooser)
        }
        shareLinkTxt.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Hey, Checkout my github stats card. $completeUrl"
            )
            val chooser = Intent.createChooser(intent, "Share this card using...")
            startActivity(chooser)
        }
    }
}