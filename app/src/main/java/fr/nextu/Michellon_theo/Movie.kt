package fr.nextu.Michellon_theo

data class Movie(
    var id:Int = 0,
    var title:String ="test"
)

data class Movies(val movies: List<Movie>)