package com.example.aplicativosorteio

class DndCharacter {
    val strength = ability()
    val dexterity = ability()
    val constitution = ability()
    val intelligence = ability()
    val wisdom = ability()
    val charisma = ability()
    val hitpoints =  10 + modifier(constitution)

    companion object {
        fun ability(): Int {
            val rolls = List(4) { (1..6).random() }

            return rolls.sorted().drop(1).sum()
        }

        fun modifier(score: Int): Int {

            return kotlin.math.floor((score - 10) / 2.0).toInt()
        }
    }
}