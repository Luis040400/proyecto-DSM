package com.example.proyectodsm

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    lateinit var spCantidadPreguntas: Spinner
    lateinit var spCantidadTiempo: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setCheckedItem(R.id.nav_home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()
        navView.setCheckedItem(R.id.nav_home)
        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
                R.id.nav_home -> replaceFregment(HomeFragment(),it.title.toString())
                R.id.nav_create_exam -> {
                    val dialog = Dialog(this)
                    dialog.setContentView(R.layout.dialog_input)

                    spCantidadPreguntas = dialog.findViewById(R.id.spCantidadPreguntas)
                    spCantidadTiempo = dialog.findViewById(R.id.spTiempo)

                    dialog.findViewById<Button>(R.id.buttonAceptar).setOnClickListener{
                        dialog.dismiss()

                        val fragment = CreateExamFragment(spCantidadPreguntas.selectedItem.toString().toInt(),spCantidadTiempo.selectedItem.toString().toInt())
                        replaceFregment(fragment,"Titulo")
                    }

                    dialog.show()
                }
                R.id.nav_message -> Toast.makeText(applicationContext,"CLICKED MESSAGE",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun replaceFregment(fragment: Fragment,title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}