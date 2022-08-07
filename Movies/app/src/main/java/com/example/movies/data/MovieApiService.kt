import android.util.Log
import com.example.movies.data.MovieApiInterface

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieApiService {
    companion object{
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "5b2ce55d1f51bb12a7eef170b626eb71"
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

        fun getPostApi(): MovieApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttp())
                .build()
            return retrofit.create(MovieApiInterface::class.java)
        }

        private fun getOkHttp(): OkHttpClient {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(getLoggingInterceptor())
            return okHttpClient.build()
        }

        private fun getLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor(logger = object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.d("OkHttp", message)
                }
            }).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        //        private var retrofit: Retrofit? = null

//        fun getClient(): MovieApiInterface {
//            val requestInterceptor = Interceptor { chain ->
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .addQueryParameter("api_key", API_KEY)
//                    .build()
//
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//            }
//
//            val okHttpClient = okHttpClient.Builder()
//                .addInterceptor
//
//        }
//        fun getInstance(): Retrofit {
//            if(retrofit == null){
//                retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return retrofit!!
//        }
    }
}