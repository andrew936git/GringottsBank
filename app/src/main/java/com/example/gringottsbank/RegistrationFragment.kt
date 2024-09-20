package com.example.gringottsbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationFragment : Fragment() {

    private lateinit var loginET: EditText
    private lateinit var passwordET: EditText
    private lateinit var saveButton: Button
    private var userList = arrayListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        loginET = view.findViewById(R.id.loginET)
        passwordET = view.findViewById(R.id.passwordET)
        saveButton = view.findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val login = loginET.text.toString()
            val password = passwordET.text.toString()
            if (loginET.text.isEmpty() || passwordET.text.isEmpty()){
                Toast.makeText(context, "Данные не введены", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val user = User(login, password)
            userList.add(user)
            val bundle = Bundle()
            val logInFragment = LogInFragment()
            bundle.putParcelableArrayList("userList", userList)
            logInFragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.containerID, logInFragment)
                ?.commit()
            Toast.makeText(context, "Регистрация прошла успешно", Toast.LENGTH_LONG).show()
        }

        return view
    }
}