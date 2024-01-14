package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyRecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var epoxyview=view.findViewById<EpoxyRecyclerView>(R.id.epoxyview)
        var size2=50
        var currentPage = 0
         val totalPageCount = 5
        epoxyview?.withModels {
            for(i in 0 until size2){

                viewholder {
                    id(i)
                    textvalue("number"+i)
                }
            }


        }
        epoxyview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount

                if (currentPage < totalPageCount && lastVisibleItemPosition == totalItemCount - 1) {
                    // Load more data when the user scrolls to the end of the list
                    size2+=10
                    epoxyview.requestModelBuild()
                    Log.d("loaddata","load")
                }
            }
        })


    }



}