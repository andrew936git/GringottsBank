package com.example.gringottsbank

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textTV = view.findViewById<TextView>(R.id.textTV)
        val imageViewIV = view.findViewById<ImageView>(R.id.imageViewIV)
        val startButton = view.findViewById<Button>(R.id.startButton)
        val viewPagerItem = arguments?.getSerializable("picture") as Picture
        textTV.text = viewPagerItem.title
        imageViewIV.setImageResource(viewPagerItem.image)

        val check = viewPagerItem.isCheck

        if (!check){
            startButton.visibility = View.VISIBLE
            startButton.setOnClickListener{
                startActivity(Intent(activity, RegistrationActivity::class.java))
            }
        }
    }

}