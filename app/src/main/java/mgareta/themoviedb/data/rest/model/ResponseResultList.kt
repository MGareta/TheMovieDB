package mgareta.themoviedb.data.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by marc on 16/03/18.
 */

class ResponseResultList<T> {

    @SerializedName("page")
    @Expose
    var page:Int = 0

    @SerializedName("results")
    @Expose
    var results: List<T>? = null

    @SerializedName("total_results")
    @Expose
    var totalResults:Int = 0

    @SerializedName("total_pages")
    @Expose
    var totalPages:Int = 0
}