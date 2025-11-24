package unit4.roomdb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse226_etp.R
import com.example.cse226_etp.databinding.ActivityMainBinding
import com.example.cse226_etp.databinding.ActivityRoomDatabaseMainBinding
import kotlin.getValue
import kotlin.text.clear
import kotlin.toString


//added versions, libraries and dependencies in build.gradle.kts file
//added viewBinding inside android block(in that i made wrote buildFeatures { viewBinding = true }) build.gradle.kts file
//added id("kotlin-kapt") inside plugins in build.gradle.kts file
//after all that made files (all those files i kept in roomdb)

class RoomDatabaseMain : AppCompatActivity() {

    private lateinit var binding: ActivityRoomDatabaseMainBinding
    private val viewModel: NoteViewModel by viewModels()
    private val adapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDatabaseMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observe LiveData
        viewModel.allNotes.observe(this) { notes ->
            adapter.submitList(notes)
        }

        // Add note
        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()
            if (title.isNotEmpty() || content.isNotEmpty()) {
                val note = Note(title = title, content = content)
                viewModel.insert(note)
                binding.etTitle.text?.clear()
                binding.etContent.text?.clear()
            }
        }
    }
}