package fr.nextu.Michellon_theo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(val movies: Movies) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    init {
        Log.d("taggs", movies.movies.size.toString())
    }
    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView

        init {
            textView = view.findViewById(R.id.title_movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_item, parent, false)

        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.textView.text = movies.movies[position].title
        Log.d("azertyuiopqsdfjkk", movies.movies[position].title)

    }

    override fun getItemCount() = movies.movies.size
}