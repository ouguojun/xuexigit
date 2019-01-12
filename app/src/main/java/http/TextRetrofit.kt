package http

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.http.*
import java.lang.reflect.Type

interface TextRetrofit {
    @POST
    @GET(value = "http://www.163.com")
    @HTTP(method = "GET", path = "aaaa", hasBody = true)
    @FormUrlEncoded
    @Multipart
    @Headers("45", "45", "89")

    fun method1(@Header("aa") heaer1: String)

    fun method2(@HeaderMap heaer1: Map<String, String>, @HeaderMap heaer2: Map<String, String>) {
    }

    fun method3(@Url url: String, @Body path: String)

    @POST
    @Multipart
    @Headers("name: ogj", "age: 18")
    fun method4(@Part part1: MultipartBody.Part, @Part part2: MultipartBody.Part)

    fun asdfsd() {
        val builder = okhttp3.MultipartBody.Builder()
        val build = builder.build()
        MultipartBody.Part.create(okhttp3.Headers.of(""), null)
    }

    @GET("sadfasdf")
    @Headers("asdf: aa")
    fun method2(@Query("name") name: String) {

    }

    @POST
    @FormUrlEncoded
    @Headers("aaa: fd")
    fun mthod6(@Body asdf: String, @Field("aa") eeee: String) {

    }

    fun a1() {
        val builder = Retrofit.Builder()
        val retrofit = builder.client(Http.okHttpClient).addCallAdapterFactory(object : CallAdapter.Factory() {
            override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
                val rawType = getRawType(returnType)
                return object : CallAdapter<String, String> {
                    override fun adapt(call: Call<String>): String {
                        val response = call.execute()
                        response.body()
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun responseType(): Type {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                }
            }

        }).addConverterFactory(object : Converter.Factory() {
            override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
                return Converter<ResponseBody, String> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }

            override fun requestBodyConverter(type: Type, parameterAnnotations: Array<Annotation>, methodAnnotations: Array<Annotation>, retrofit: Retrofit): Converter<*, RequestBody>? {
                return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
            }
        }).build()

        val runnable = retrofit.create(Runnable::class.java)
        runnable.run()
    }
}