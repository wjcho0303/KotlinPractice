fun main(args: Array<String>) {
    val price1 : Int = 120
    val price2 : Int = 170

    val price3 = sumPrice1(price1, price2)
    println("sumPrice1 -> $price3")

    val price4 = sumPrice2(price1, price2)
    println("sumPrice2 -> $price4")

    val price5 = sumPrice3(price1, price2)
    println("sumPrice3 -> $price5")
}

// 함수 작성 정석 방법
fun sumPrice1(price1: Int, price2: Int): Int {
    val price = price1 + price2
    return price
}

// 한 줄일 때는 바로 등호로 구현부 작성
fun sumPrice2(price1: Int, price2: Int): Int = price1 + price2

// 리턴 타입 생략하고 등호 가능
fun sumPrice3(price1: Int, price2: Int) = price1 + price2