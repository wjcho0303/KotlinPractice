package classes

class Chicken : Animal(), Eatable {
    override fun move() {
        super.move()
    }
    override fun eat() {
        println("냠냠")
    }
}