fun main() {
    val animal1: Cat = Cat()
    animal1.meow()

    val animal2: Dog = Dog()
    animal2.bark()

    val animal3: Animal = Cat()
//    animal3.meow()  // 타입이 Animal 이라 Cat 메서드 불가
    animal3.move()

    val animal4: Animal = Dog()
//    animal4.bark()  // 타입이 Animal 이라 Dog 메서드 불가
    animal4.move()
}