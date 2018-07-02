```uml
@startuml
skinparam shadowing false
scale 1
top to bottom direction
hide circle

class Foods {
  calorie: double
  name: String
  Foods(name: String, calorie: double)
  getName(): String
  getCalorie(): double
}

class Meals {
    count: int
    gram: double[]
    Meals(maxElement: int)
    add(food: Foods, gram: double): void
    calcTotal(): double
}

class FoodList {
    count: int
    FoodList(maxElement: int)
    add(food: Foods): void
    get(name: String): Foods
    getName(): String[]
}

class FoodListController {
    sc: Scanner
    FoodListController(foodList: FoodList)
    regist(): void
    displayList(): void
}

class MealController {
    sc: Scanner
    meal: Meals
    MealController(foodList: FoodList)
    create(): void
    total(): void
}

class MainController {
    sc: Scanner
    MainController()
    run(): void
    main(args: String[]): void
}

MainController o--> "1\n mealControl" MealController
MainController o--> "1\n foodListControl" FoodListController
MainController ....> FoodList
FoodListController ---> "1\n foodList" FoodList
MealController ---> "1\n meal" Meals
MealController ---> "1\n foodList" FoodList
FoodList o--> "0..* list" Foods
Meals "0..*" --> "0..* foods" Foods

@enduml
```
