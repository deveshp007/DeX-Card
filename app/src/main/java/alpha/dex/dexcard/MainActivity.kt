package alpha.dex.dexcard


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import com.jaredrummler.materialspinner.MaterialSpinner
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)


        // variable declaration ======================

        val userName = findViewById<TextInputLayout>(R.id.userName)
        val btnHideDialog = findViewById<Button>(R.id.hideDialog)
        val btn = findViewById<Button>(R.id.btnGen)
        val pvtCountRG = findViewById<RadioGroup>(R.id.pvtCountRG)
        val showIconRG = findViewById<RadioGroup>(R.id.showIconRG)
        val hideRankRG = findViewById<RadioGroup>(R.id.hideRankRG)
        val hideTitleRG = findViewById<RadioGroup>(R.id.hideTitleRG)
        val addAllComRG = findViewById<RadioGroup>(R.id.addAllComRG)
        val cardWidthSkBar = findViewById<SeekBar>(R.id.cardWidthSkBar)
        val skBarValue = findViewById<TextView>(R.id.skBarValue)


        // Themes Selection Spinner ================================

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


        // Hide Stats Items =============================================

        var hideItems = ""
        val listItems = arrayOf("stars", "commits", "prs", "issues", "contribs")
        val checkedItems = BooleanArray(listItems.size)
        val selectedItems = mutableListOf(*listItems)

        btnHideDialog.setOnClickListener() {
            val builder = MaterialAlertDialogBuilder(this)

                .setTitle("Item(s) to hide ?")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setMultiChoiceItems(listItems, checkedItems) { dialog, which, isChecked ->
                    checkedItems[which] = isChecked

                }
                .setPositiveButton("Done") { dialog, which ->
                    checkedItems.forEachIndexed { i, checked ->
                        hideItems = if (checked) {
                            String.format("%s%s,", hideItems, selectedItems[i])
                        } else {
                            hideItems.replace("${selectedItems[i]},", "")
                        }
                    }
                }
                .setNegativeButton("Reset") { dialog, which ->
                    hideItems = ""
                    Arrays.fill(checkedItems, false)
                }
            builder.show()
        }
        hideItems.dropLast(1)


        // Card Width Seekbar Implementation =====================

        var cardWidth = "300"
        cardWidthSkBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                skBarValue.text = p0?.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                cardWidth = p0?.progress.toString()

            }
        })


        // Generate Button =================

        btn.setOnClickListener() {
            val githubId = userName.editText?.text.toString() // userName

            // private Commit Count =====
            val pvtCountRBId = pvtCountRG.checkedRadioButtonId
            val pvtCountRb = pvtCountRG.findViewById<RadioButton>(pvtCountRBId)
            val countPvt = if (pvtCountRb?.text == "Yes") {
                "true"
            } else {
                "false"
            }

            // show Icons ===========
            val showIconRBId = showIconRG.checkedRadioButtonId
            val showIconRb = showIconRG.findViewById<RadioButton>(showIconRBId)
            val showIcon = if (showIconRb?.text == "Yes") {
                "true"
            } else {
                "false"
            }


            // Hide Rank ===========
            val hideRankRBId = hideRankRG.checkedRadioButtonId
            val hideRankRb = hideRankRG.findViewById<RadioButton>(hideRankRBId)
            val hideRank = if (hideRankRb?.text == "No") {
                "false"
            } else {
                "true"
            }


            // Hide Title ===========
            val hideTitleRBId = hideTitleRG.checkedRadioButtonId
            val hideTitleRb = hideTitleRG.findViewById<RadioButton>(hideTitleRBId)
            val hideTitle = if (hideTitleRb?.text == "No") {
                "false"
            } else {
                "true"
            }

            // Add all github commits ===========
            val addAllComRBId = addAllComRG.checkedRadioButtonId
            val addAllRb = addAllComRG.findViewById<RadioButton>(addAllComRBId)
            val addAllCom = if (addAllRb?.text == "No") {
                "false"
            } else {
                "true"
            }


            val completeUrl =
                "https://github-readme-stats.vercel.app/api?username=$githubId&theme=$theme&hide=$hideItems&count_private=$countPvt&show_icons=$showIcon&hide_rank=$hideRank&hide_title=$hideTitle&card_width=$cardWidth&include_all_commits=$addAllCom"


            val intent = Intent(this, Cards::class.java)
            intent.putExtra("url", completeUrl)
            startActivity(intent)
            Toast.makeText(this, "Card Generated 🤖", Toast.LENGTH_SHORT).show()
        }
    }
}




