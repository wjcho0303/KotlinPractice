import classes.Color.*
import classes.TradableItem

fun main() {
    val tradableItem1 = TradableItem("Book", 10000, BLUE)
    val tradableItem2 = TradableItem("Audio")
    val tradableItem3 = TradableItem(15000)
    val tradableItem4 = TradableItem()

    tradableItem1.buy()
    tradableItem1.sell()
    tradableItem2.buy()
    tradableItem2.sell()
    tradableItem3.buy()
    tradableItem3.sell()
    tradableItem4.buy()
    tradableItem4.sell()

}