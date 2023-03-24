package com.example.newottapp.Repository

import com.example.newottapp.models.Movie


interface UserRepository {


    fun getList(position: Int) : ArrayList<Movie>


}