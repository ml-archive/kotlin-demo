package com.fuzz.android.kotlin.fuzztest

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    //savedInstanceState is of type Bundle and can be null thanks to ?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "Also handled in kotlin", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        //get functions can be called as instance varibales
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //initialize without using the new keyword
        val simpleFragment = SimpleFragment()
        //Otherwise same as normal java here
        fragmentTransaction.add(R.id.container, simpleFragment)
        fragmentTransaction.commit();
    }

    //menu is of type Menu and will never be null
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.add("Menu Test").setOnMenuItemClickListener {
            nameLocal -> //Names the MenuItem name to a local variable for use

            //Use {} to call a method within a varibale otherwise $ will call the toString method
            Snackbar.make(findViewById(R.id.fab), "${nameLocal.title} in kotlin $nameLocal.title", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            true  //Return not needed in lamda functions
        }
        return true
    }

    //return type is of type boolean
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        //Used as a switch statement
        when (id) {
            R.id.action_settings -> {
                return true
            }
            R.id.fab -> fakeFunction()
            else -> {
                //MUST define if using else -> at very least like this
                //otherwise else does not need to be defined
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun fakeFunction() {
        //private function define
    }
}
