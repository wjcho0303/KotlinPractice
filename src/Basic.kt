fun main(args: Array<String>) {

    var priceA : Int = 100
    var priceB : Int = 200

//    if (priceA >= priceB) {
//        println("priceA = $priceA")
//    } else {
//        println("priceB = $priceB")
//    }

    println(priceA::class)
    println(priceB::class)

    val price : Int = 250

    if (price in 100..300) {
        println("in range")
    } else {
        println("not in range")
    }

    if (price in arrayOf(100, 200, 300)) {
        println("contained")
    } else {
        println("not contained")
    }
}