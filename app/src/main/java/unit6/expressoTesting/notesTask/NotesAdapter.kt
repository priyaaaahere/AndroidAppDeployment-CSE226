package unit6.expressoTesting.notesTask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.databinding.ItemNoteBinding
import com.example.cse226_etp.databinding.ItemNotesBinding

class NotesAdapter(
    private val notes: MutableList<Note>,
    private val onDelete: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteVH>() {

    inner class NoteVH(val binding: ItemNotesBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val binding = ItemNotesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NoteVH(binding)
    }

    override fun onBindViewHolder(holder: NotesAdapter.NoteVH, position: Int) {
        val note = notes[position]
        holder.binding.tvNote.text = note.text

        holder.binding.btnDelete.setOnClickListener {
            onDelete(note)
        }
    }

    override fun getItemCount() = notes.size
}