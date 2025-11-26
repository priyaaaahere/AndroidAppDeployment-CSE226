package unit6.expressoTesting.notesTask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cse226_etp.R
import com.example.cse226_etp.databinding.ActivityNoteMainBinding
import unit4.roomdb.NoteAdapter

class NoteMain : AppCompatActivity() {

    private lateinit var binding: ActivityNoteMainBinding

    private val notes = mutableListOf<Note>()
    private lateinit var adapter: NotesAdapter
    private var idCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note_main)
        binding = ActivityNoteMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NotesAdapter(notes) { note ->
            notes.remove(note)
            adapter.notifyDataSetChanged()
        }

        binding.recyclerNotes.layoutManager = LinearLayoutManager(this)
        binding.recyclerNotes.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val text = binding.etNote.text.toString()
            if (text.isNotEmpty()) {
                notes.add(Note(idCounter++, text))
                adapter.notifyDataSetChanged()
                binding.etNote.text.clear()
            }
        }
    }
}