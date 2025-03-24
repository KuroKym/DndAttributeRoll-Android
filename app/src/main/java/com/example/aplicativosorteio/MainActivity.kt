package com.example.aplicativosorteio

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var strengthTextView: TextView
    private lateinit var dexterityTextView: TextView
    private lateinit var constitutionTextView: TextView
    private lateinit var intelligenceTextView: TextView
    private lateinit var wisdomTextView: TextView
    private lateinit var charismaTextView: TextView
    private lateinit var hitpointsTextView: TextView
    private lateinit var charNameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        strengthTextView = findViewById(R.id.strength)
        dexterityTextView = findViewById(R.id.dexterity)
        constitutionTextView = findViewById(R.id.constitution)
        intelligenceTextView = findViewById(R.id.intelligence)
        wisdomTextView = findViewById(R.id.wisdom)
        charismaTextView = findViewById(R.id.charisma)
        hitpointsTextView = findViewById(R.id.hitpoints)
        charNameText = findViewById(R.id.editName)


        showNameInputDialog()
        sortearInit()

    }
    fun showNameInput(view: View){
        showNameInputDialog()
    }

    private fun showNameInputDialog(){
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_character_name, null)
        val nameInput = dialogLayout.findViewById<EditText>(R.id.dialog_name_input)

        builder.setTitle("Enter Character Name")
        builder.setView(dialogLayout)
        builder.setCancelable(false)
        builder.setPositiveButton("OK"){_, _ ->
            val characterName = nameInput.text.toString().ifEmpty { "Adventurer" }
            charNameText.setText(characterName)

        }
        builder.show()
    }
    fun sortear(view: View){
        sortearInit()
    }
    private fun sortearInit(){
        val character = DndCharacter()

        strengthTextView.text = "Stregth: ${character.strength}"
        dexterityTextView.text = "Dexterity: ${character.dexterity}"
        constitutionTextView.text = "Constitution: ${character.constitution}"
        intelligenceTextView.text = "Intelligence: ${character.intelligence}"
        wisdomTextView.text = "Wisdom: ${character.wisdom}"
        charismaTextView.text = "Charisma: ${character.charisma}"
        hitpointsTextView.text = "HP: ${character.hitpoints}"
    }

}