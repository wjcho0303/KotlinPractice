// 타입 캐스팅: 기존 타입 유지

fun main() {
    var i = 10
    var j = 20L
    var name = ""

    i = j.toInt()
    name = i.toString()
    j = i.toLong()

    println("i::class = " + i::class)
    println("i = $i")
    println("j::class = " + j::class)
    println("j = $j")
    println("name::class = " + name::class)
    println("name = $name")
}