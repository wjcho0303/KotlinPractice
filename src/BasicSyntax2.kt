fun main(args: Array<String>) {
    println("Hello World!");

    val s = "ABC"
    val i = 1
    val l = 1L
    val d = 1.0
    val f = 1.0f

    println("s = ${s::class}")
    println("i = ${i::class}")
    println("l = ${l::class}")
    println("d = ${d::class}")
    println("f = ${f::class}")

    val priceA: Int = 100
    val priceB: Int = 200

    if (priceA >= priceB) {
        println("priceA = ${priceA}")
    } else {
        println("priceB = ${priceB}")
    }

    var price: Int?
    price = null
    price = 100
    if (price == null) {
        println("null check true")
    } else {
        println("price = ${price}")
    }

    price = 200
    when (price) {
        100 -> println("1. price = $price")
        200 -> println("2. price = $price")
        300 -> println("3. price = $price")
        else -> println("4. Not")
    }

    price = 57
    when (price) {
        57 -> println("0. price is 57")
        in 100..199 -> println("1. price is in 100~199")
        in 200..299 -> println("2. price is in 200~299")
        in 300..399 -> println("3. price is in 300~399")
        else -> println("4. Not")
    }

    price = 277
    when (price) {
        57 -> println("0. price is 57")
        in 100..199 -> println("1. price is in 100~199")
        in 200..299 -> println("2. price is in 200~299")
        in 300..399 -> println("3. price is in 300~399")
        else -> println("4. Not")
    }

    price = 250
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