package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityAddnoteBinding
import com.example.notesapp.databinding.ActivityMainBinding
import android.view.Window
import android.view.WindowManager
import android.os.Build


class AddnoteActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAddnoteBinding
    private  lateinit var db:NotesDatabaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAddnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db =NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title =binding.titleEditText.text.toString()
            val content=binding.contentEdittext.text.toString()
            val note= Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }
        // Change the status bar color
        changeStatusBarColor("#7D7C7C") // Replace with your desired color code

    }

    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}