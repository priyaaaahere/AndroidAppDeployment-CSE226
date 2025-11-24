package unit4.sqlite.task1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlLiteHelper(context : Context):
    SQLiteOpenHelper(context, "database.db", null, 2) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE users(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "email TEXT," +
                    "course TEXT," +
                    "number TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }


    fun insertuser(name: String, email: String, course: String, number: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("email", email)
            put("course", course)
            put("number", number)
        }
        return db.insert("users", null, values)

    }

    fun readusers(): List<String> {
        val db = readableDatabase
        val cursor = db.query("users", arrayOf("id", "name", "email", "course", "number"), null, null, null, null, null)
        val users = mutableListOf<String>()
        try { // Add try block
            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id")) // Use getColumnIndexOrThrow for robustness
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val course = cursor.getString(cursor.getColumnIndexOrThrow("course"))
                val number = cursor.getString(cursor.getColumnIndexOrThrow("number"))
                users.add("ID: $id, Name: $name, Email: $email, Course: $course, Number: $number")
            }
        } finally { // Add finally block
            cursor.close() // Close the cursor
        }
        return users
    }
    fun updateuser(id: Int,newEmail : String): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("email",newEmail)
        }
        return db.update("users",values,"id = ?", arrayOf(id.toString()))

    }

    fun deleteuser(id: Int): Int {
        val db = writableDatabase
        return db.delete("users", "id = ?", arrayOf(id.toString()))
    }
}