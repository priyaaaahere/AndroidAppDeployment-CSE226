package unit4.sqlite.task1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class SqlMainActivity : AppCompatActivity() {

    private lateinit var dbHelper: SqlLiteHelper
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etCourse: EditText
    private lateinit var etNumber: EditText
    private lateinit var etUserIdUpdate: EditText
    private lateinit var etNewEmailUpdate: EditText
    private lateinit var etdeleteId: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var tvResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sql_main)

        dbHelper = SqlLiteHelper(this)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etCourse = findViewById(R.id.etCourse)
        etNumber = findViewById(R.id.etNumber)
        etUserIdUpdate = findViewById(R.id.etUpdateId)
        etNewEmailUpdate = findViewById(R.id.etUpdateEmail)
        etdeleteId = findViewById(R.id.etDeleteId)
        btnAdd = findViewById(R.id.btnInsert)
        btnView = findViewById(R.id.btnRead)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        tvResults = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val course = etCourse.text.toString()
            val number = etNumber.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && course.isNotEmpty()) {
                val id = dbHelper.insertuser(name, email, course,number)
                if (id > -1) {
                    Toast.makeText(this, "User Inserted with ID: $id", Toast.LENGTH_SHORT).show()
                    etName.text.clear()
                    etEmail.text.clear()
                    etCourse.text.clear()
                    etNumber.text.clear()
                } else {
                    Toast.makeText(this, "Error inserting user", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        btnView.setOnClickListener {
            val users = dbHelper.readusers()
            if (users.isNotEmpty()) {
                val resultText = users.joinToString("\n")
                tvResults.text = resultText
            } else {
                tvResults.text = "No users found"
            }
        }


        btnUpdate.setOnClickListener {
            val userIdStr = etUserIdUpdate.text.toString()
            val newEmail = etNewEmailUpdate.text.toString()

            if (userIdStr.isNotEmpty() && newEmail.isNotEmpty()) {
                try {
                    val userId = userIdStr.toInt()
                    val rowsAffected = dbHelper.updateuser(userId, newEmail)
                    if (rowsAffected > 0) {
                        Toast.makeText(this, "User email updated successfully", Toast.LENGTH_SHORT).show()
                        etUserIdUpdate.text.clear()
                        etNewEmailUpdate.text.clear()
                        btnView.performClick()
                    } else {
                        Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid User ID format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter User ID and Email", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            val userid = etdeleteId.text.toString()
            if (userid.isNotEmpty()) {
                try {
                    val userId = userid.toInt()
                    val rowsAffected = dbHelper.deleteuser(userId)
                    if (rowsAffected > 0) {
                        Toast.makeText(this, "User deleted successfully", Toast.LENGTH_SHORT).show()
                        etUserIdUpdate.text.clear()
                        btnView.performClick()
                    } else {
                        Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid User ID format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter User ID to delete", Toast.LENGTH_SHORT).show()
            }
        }

    }
}