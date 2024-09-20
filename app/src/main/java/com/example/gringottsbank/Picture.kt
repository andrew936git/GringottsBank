package com.example.gringottsbank

import java.io.Serializable

class Picture(val title: String, val image: Int, val isCheck: Boolean): Serializable {

    companion object{
        val pictureList = listOf(
            Picture("Добро пожаловать в мобильное приложение Гринготтс банка", R.drawable.logo, true),
            Picture("Здесь вы можете сохранить и приумножить Ваши богатства", R.drawable.stonks, true),
            Picture("После быстрой регистрации Вы можете начать работу с приложением", R.drawable.queue, false)
        )
    }
}
