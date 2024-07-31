import classes.*

// 타입 캐스팅

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

    // 타입 체크 연산자 is
    if (animal1 is Cat) {
        println("animal1은 Cat이다.")
    }

    if (animal1 is Animal) {
        println("animal1은 Animal이다.")
    }

    if (animal5 is Eatable) {
        println("animal5는 Eatable이다.")
    }

    // 조상 자손 간 타입 캐스팅 as
    // Animal 에서 Dog 로 다운캐스팅
    animal4 as Dog
    animal4.bark()
    (animal3 as Cat).meow()     // 괄호 내부에서 즉석으로 다운캐스팅 가능
    // (animal3 as Dog).bark() // 조상 자손 관계가 아니기 때문에 Cat 을 Dog 로 타입 캐스팅은 불가능

    // Dog 에서 Animal 로 업캐스팅 (새로운 변수로 정의해야 함)
    val animal6: Animal = animal4 as Animal
    animal6.move()
    // animal4.bark()
    println(animal4)    // classes.Dog@28d93b30
    println(animal6)    // classes.Dog@28d93b30
}