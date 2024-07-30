import classes.Animal
import classes.Cat
import classes.Chicken
import classes.Dog

fun main() {
    val animal1: Cat = Cat()
    animal1.meow()

    val animal2: Dog = Dog()
    animal2.bark()

    val animal3: Animal = Cat()
//    animal3.meow()  // 타입이 classes.Animal 이라 classes.Cat 메서드 불가
    animal3.move()

    val animal4: Animal = Dog()
//    animal4.bark()  // 타입이 classes.Animal 이라 classes.Dog 메서드 불가
    animal4.move()

    val animal5: Chicken = Chicken()
    animal5.move()
    animal5.eat()
}