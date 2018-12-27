package http

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Multipart
import retrofit2.http.Part

class TextOkhttp {

    fun a1() {
        val body = RequestBody.create(MediaType.parse(""), "")
        val builder = okhttp3.Request.Builder()
        builder.url("")
                .addHeader("", "")
                .post(body)
                .build()

//        RequestBody.create()
//        val fromBodybuilder = FormBody.Builder()
//        fromBodybuilder.add("", "")
//        val frombody = fromBodybuilder.build()
//
//
//        val multipartBodyBuilder = MultipartBody.Builder()
//        val headers = Headers.Builder().add("", "").build()
//        MultipartBody.Part.create(headers, body)
//        multipartBodyBuilder.addFormDataPart()
    }

    fun a2() {
        val aa = HttpLoggingInterceptor()
    }

    var dddd = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            request.headers()
            return chain.proceed(request)
        }

    }

    fun a4() {
        Http.okHttpClient
    }
}


