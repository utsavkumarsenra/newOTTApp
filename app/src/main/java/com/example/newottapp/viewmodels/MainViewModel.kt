package com.example.newottapp.viewmodels
import androidx.lifecycle.ViewModel
import com.example.newottapp.Repository.MovieRepository
import com.example.newottapp.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    //saves data during orientation change,has both current data and searched data

    val currentlist:ArrayList<Movie> = arrayListOf()

    fun getList(position:Int) : ArrayList<Movie> {
        val resultlist  = movieRepository.getList(position)
        currentlist.addAll(resultlist)
        return resultlist
    }

    fun getsearchlist(text:String) : ArrayList<Movie>
    {
        return ArrayList(currentlist.filter { it.name.contains(text, ignoreCase = true)})
    }
}