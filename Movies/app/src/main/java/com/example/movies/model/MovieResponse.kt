import android.os.Parcelable
import com.example.movies.model.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
//    val movie: Movie(val id: String?, val title: String?, val poster: String?, val release: String?)
): Parcelable {
    constructor(): this(mutableListOf())
}