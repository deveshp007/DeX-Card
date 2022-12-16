package alpha.dex.dexcard

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.jaredrummler.materialspinner.MaterialSpinner


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val userName = findViewById<TextInputLayout>(R.id.userName)
        val btn = findViewById<Button>(R.id.btnGen)
        val card = findViewById<ImageView>(R.id.card)
        val githubId = userName.editText?.text.toString()
        var theme = ""



        val spinner = findViewById<View>(R.id.spinner) as MaterialSpinner
        spinner.setItems(
            "default",
            "transparent",
            "dark",
            "radical",
            "merko",
            "gruvbox",
            "gruvbox_light",
            "tokyonight",
            "onedark",
            "cobalt",
            "synthwave",
            "highcontrast",
            "dracula",
            "prussian",
            "monokai",
            "vue",
            "vue-dark",
            "shades-of-purple",
            "nightowl",
            "buefy",
            "blue-green",
            "algolia",
            "great-gatsby",
            "darcula",
            "bear",
            "solarized-dark",
            "solarized-light",
            "chartreuse-dark",
            "nord",
            "gotham",
            "material-palenight",
            "graywhite",
            "vision-friendly-dark",
            "ayu-mirage",
            "midnight-purple",
            "calm",
            "flag-india",
            "omni",
            "react",
            "jolly",
            "maroongold",
            "yeblu",
            "blueberry",
            "slateorange",
            "kacho_ga",
            "outrun",
            "ocean_dark",
            "city_lights",
            "github_dark",
            "discord_old_blurple",
            "aura_dark",
            "panda",
            "noctis_minimus",
            "cobalt2",
            "swift",
            "aura",
            "apprentice",
            "moltack",
            "codeSTACKr",
            "rose_pine",
            "date_night"
        )

        spinner.setOnItemSelectedListener { view, position, id, item ->
            theme = "$item"
            Toast.makeText(this, "$theme theme selected", Toast.LENGTH_SHORT).show()
        }
        val url =
           "https://github-readme-stats.vercel.app/api?username=$githubId&show_icons=true&theme=$theme"

        var links = listOf<String>("https://i.gifer.com/Lt5S.gif", "https://i.gifer.com/PPy.gif", "https://i.gifer.com/4JZ4.gif", "https://i.gifer.com/7ynw.gif", "https://i.gifer.com/xK.gif", "https://i.gifer.com/2qQQ.gif", "https://i.gifer.com/77rr.gif", "https://i.gifer.com/8qG.gif", "https://i.gifer.com/AcU9.gif", "https://i.gifer.com/6ElP.gif", "https://i.gifer.com/77rn.gif", "https://i.gifer.com/33HI.gif", "https://i.gifer.com/OSOD.gif", "https://i.gifer.com/fxk6.gif", "https://i.gifer.com/7Tzm.gif", "https://i.gifer.com/g3Ys.gif", "https://i.gifer.com/bo5.gif", "https://i.gifer.com/7TwX.gif", "https://i.gifer.com/OvZ.gif", "https://i.gifer.com/58yR.gif", "https://i.gifer.com/fxU6.gif", "https://i.gifer.com/BilS.gif", "https://i.gifer.com/LLJE.gif", "https://i.gifer.com/fxk4.gif", "https://i.gifer.com/8Wm3.gif", "https://i.gifer.com/6nOF.gif", "https://i.gifer.com/4N10.gif", "https://i.gifer.com/1zfb.gif", "https://i.gifer.com/CVb.gif", "https://i.gifer.com/AjP.gif", "https://i.gifer.com/QJFj.gif")

        btn.setOnClickListener() {
            val urr = links.random()
            Glide.with(this)
                .load(urr)
                .into(card)


            Toast.makeText(this, "Card Generated !!", Toast.LENGTH_SHORT).show()
        }


    }
}




