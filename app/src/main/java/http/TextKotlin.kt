package http

interface JK {
    var agee: Int
    fun aaa() {

    }

    fun eee() {

    }

    fun a1()

    fun a2()
}

interface JK2 {
    fun aaa() {

    }

    fun eee() {

    }
}


sealed class TK1(override var agee: Int) : JK, JK2 {


    override fun eee() {
        super<JK2>.eee()
    }

    override fun aaa() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun a1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun a2() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class TK1_1 {
        fun a1() {
            agee
        }
    }
}

class TK2 : TK1(45){



}