package http

import com.example.administrator.mykotlin.KKK
import okhttp3.OkHttpClient
import java.io.InputStream
import java.net.InetAddress
import java.net.InetSocketAddress
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.SocketFactory
import javax.net.ssl.*

object Http {



    var okHttpClient: OkHttpClient


    init {
        okHttpClient = OkHttpClient.Builder().addNetworkInterceptor {
            it.proceed(it.request())
        }.hostnameVerifier { hostname: String, session: SSLSession ->
            session.peerHost == hostname
        }.build()
    }


    fun a1() {

        //校验证书就是通过这个对象
        val trustManager = object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        val trustManagers = arrayOf(trustManager)
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagers, null)
        val socketFactory = sslContext.socketFactory
        var sslSocket: SSLSocket? = null
        if (sslSocket != null) {
            //设置sslSocket可用的TLS版本
            sslSocket.enabledProtocols = sslSocket.supportedProtocols
            //设置sslSocket可用的加密算法
            sslSocket.enabledCipherSuites = sslSocket.supportedCipherSuites

            sslSocket.startHandshake()

        }
    }

    fun getTrustManager(input: InputStream): X509TrustManager? {
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificate = certificateFactory.generateCertificate(input) as? X509Certificate
        val password = "password".toCharArray()
        var keyManagerFactory: KeyManagerFactory
        var keyStore: KeyStore? = null
        if (certificate != null) {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
            keyStore.load(null, password)
            keyStore.setCertificateEntry("0", certificate)
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
            keyManagerFactory.init(keyStore, password)
        }

        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)
        val trustManagers = trustManagerFactory.trustManagers
        return trustManagers[0] as? X509TrustManager
    }

    fun a2() {

        val esd: KKK.() -> Unit = {
            this.age
        }
    }

    fun a3(){
        val allByName = InetAddress.getAllByName("host")
        val inetSocketAddress = InetSocketAddress(allByName[0], 443)
    }
}