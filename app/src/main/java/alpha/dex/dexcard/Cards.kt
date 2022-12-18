package alpha.dex.dexcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView

class Cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        val card = findViewById<WebView>(R.id.card)

        val completeUrl = intent.getStringExtra("url")

        if (completeUrl != null) {
            card.loadUrl(completeUrl)
        }


        btnBack.setOnClickListener(){
            onBackPressed()
            finish()
        }
    }
}