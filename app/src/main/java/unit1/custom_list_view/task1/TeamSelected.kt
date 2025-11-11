package unit1.custom_list_view.task1

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import kotlin.toString

class TeamSelected : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_team_selected)

        val team = intent.getParcelableExtra<PlayerModel>("player")

        val imgFlag: ImageView = findViewById(R.id.img_flag)
        val txtName: TextView = findViewById(R.id.txt_name)
        val txtRanking: Chip = findViewById(R.id.txt_ranking)
        val txtTeamInfo: TextView = findViewById(R.id.txt_team_info)
        val ratingBar: RatingBar = findViewById(R.id.rating_bar)
        val txtRatingValue: TextView = findViewById(R.id.txt_rating_value)
        val btnPlayAnthem: MaterialButton = findViewById(R.id.btn_play_anthem)

        // Set values from PlayerModel
        team?.let { teamData ->
            imgFlag.setImageResource(teamData.imageResId)
            txtName.text = teamData.name
            txtRanking.text = teamData.rank
            txtTeamInfo.text = teamData.info
            ratingBar.rating = teamData.rating
            txtRatingValue.text = teamData.rating.toString()

            btnPlayAnthem.setOnClickListener {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(this, teamData.nationalAnthem) // ✅ now clear
                mediaPlayer?.start()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // release media player when activity is closed
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
