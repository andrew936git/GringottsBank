package com.example.gringottsbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LogInFragment : Fragment() {

    private lateinit var userNameET: EditText
    private lateinit var enteringPasswordET: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)

        userNameET = view.findViewById(R.id.userNameET)
        enteringPasswordET = view.findViewById(R.id.enteringPasswordET)
        loginButton = view.findViewById(R.id.loginButton)

        val list = arguments?.getParcelableArrayList<User>("userList")

        loginButton.setOnClickListener {
            val loginEnt = userNameET.text.toString()
            val passwordEnt = enteringPasswordET.text.toString()
            val user = User(loginEnt, passwordEnt)

            if (list != null) {
                for (i in list){
                    if (user == i){
                        Toast.makeText(context, "Добро пожаловать!", Toast.LENGTH_LONG).show()
                        val mainScreenFragment = MainScreenFragment()
                        fragmentManager?.beginTransaction()
                            ?.replace(R.id.containerID, mainScreenFragment)
                            ?.commit()
                    }
                    else {
                        Toast.makeText(context, "Логин или пароль не найден!", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }
                }


            }
        }

        return view
    }

}