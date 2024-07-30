fun main(args: Array<String>) {
    val price1 : Int = 120
    val price2 : Int = 170

    val price3 = sumPrice1(price1, price2)
    println("price3 = $price3")

    val price4 = sumPrice2(price1, price2)
    println("price4 = $price4")
}

fun sumPrice1(price1: Int, price2: Int): Int {
    val price = price1 + price2
    return price
}

fun sumPrice2(price1: Int, price2: Int): Int = price1 + price2