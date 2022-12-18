package alpha.dex.dexcard

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnCopy = findViewById<Button>(R.id.btnCopy)
        val card = findViewById<WebView>(R.id.card)


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
    }
}