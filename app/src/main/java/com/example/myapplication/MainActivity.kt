package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyRecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      var button=findViewById<Button>(R.id.buttonclick)

button.setOnClickListener {

    BottomSheetFragment().show(supportFragmentManager, "bottomSheet")
    showDialogOne()
//    Log.d("clciked","clcik")
}




    }
    fun showDialogOne() {

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.sample_dialog_one)
        val btnEdit= dialog.findViewById<RelativeLayout>(R.id.rl_edit)
        val btnDelete= dialog.findViewById<RelativeLayout>(R.id.rl_delete)
        val btnAdd= dialog.findViewById<RelativeLayout>(R.id.rl_add)

        btnEdit?.setOnClickListener {
            Toast.makeText(this, "Clicked on Edit", Toast.LENGTH_SHORT).show()
        }
        btnDelete?.setOnClickListener {
            Toast.makeText(this, "Clicked on Delete", Toast.LENGTH_SHORT).show()
        }
        btnAdd?.setOnClickListener {
            Toast.makeText(this, "Clicked on Add", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }
}