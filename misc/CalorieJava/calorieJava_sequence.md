```uml
@startuml
skinparam shadowing false
scale 2
hide footbox
title 初期化

participant ":MainController" as MainController
participant "foodList:FoodList" as foodList
participant ":FoodListController" as FoodListController
participant ":MealController" as MealController
participant "a:Foods" as food
participant "b:Foods" as food2

create MainController
[-> MainController: <<create>>
activate MainController
create foodList
MainController -> foodList
create FoodListController
MainController -> FoodListController: <<create>> FoodListController(foodList)
create MealController
MainController -> MealController: <<create>> MealController(foodList)
create food
MainController -> food: <<create>> Foods("米飯", 150.0)
MainController -> foodList: add(a:Foods): void
activate foodList
deactivate foodList
create food2
MainController -> food2: <<create>> Foods("中華麺", 57.1)
MainController -> foodList: add(b:Foods): void
activate foodList
deactivate foodList
@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 1
hide footbox
title 全体

actor "User" as user
participant ":MainController" as MainController
participant ":FoodListController" as FoodListController
participant ":MealController" as MealController

activate user
activate MainController
loop menu != 0
MainController -> user: メニューを入力
activate user
user --> MainController: menu
deactivate user
alt menu == 1
MainController -> FoodListController: regist(): void
activate FoodListController
ref over FoodListController: regist
MainController <-- FoodListController
deactivate FoodListController
else menu == 2
MainController -> FoodListController: displayList(): void
activate FoodListController
ref over FoodListController: displayList
MainController <-- FoodListController
deactivate FoodListController
MainController -> MealController: create():void
activate MealController
ref over MealController: create
MainController <-- MealController
deactivate MealController
MainController -> MealController: total():void
activate MealController
ref over MealController: total
MainController <-- MealController
deactivate MealController
end
end
user <-- MainController
@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 2
hide footbox

actor "User" as user
participant ":FoodListController" as FoodListController
participant "foodList:FoodList" as foodList
participant "food:Foods" as food

activate user
activate FoodListController
FoodListController -> user: 食品名の入力
activate user
user --> FoodListController: name
deactivate user
FoodListController -> user: カロリーの入力
activate user
user --> FoodListController: calorie
deactivate user
create food
FoodListController -> food: <<create>> Foods(name, calorie)
FoodListController -> foodList: add(food):void
activate foodList
deactivate foodList

@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 2
hide footbox

actor "User" as user
participant ":FoodListController" as FoodListController
participant "foodList:FoodList" as foodList

activate user
activate FoodListController
FoodListController -> foodList: list = getName():String[]
activate foodList
FoodListController <-- foodList
deactivate foodList
FoodListController ->> user: 食品一覧の表示
note right
list から食品一覧の文字列を作成する
endnote
deactivate FoodListController

@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 2
hide footbox

actor "User" as user
participant ":MealController" as MealController
participant "meal:Meals" as meal
participant "foodList:FoodList" as foodList

activate user
activate MealController
create meal
MealController -> meal: <<create>>
loop
  user <- MealController: 食品名，グラム数の入力
  activate user
  user --> MealController: name, gram
  deactivate user
  note right
    name が 'end' であればグラム数を入力せずに loop を終了
  endnote
  MealController -> foodList: food = get(name):Foods
  activate foodList
  MealController <-- foodList
  deactivate foodList
  MealController -> meal: add(food, gram):void
  activate meal
  deactivate meal
end

@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 2
hide footbox

actor "User" as user
participant ":MealController" as MealController
participant "meal:Meals" as meal

activate user
activate MealController
MealController -> meal: calcTotal():double
activate meal
MealController <-- meal
deactivate meal
user <<- MealController: 総カロリーの表示

@enduml
```

---

```uml
@startuml
skinparam shadowing false
scale 2
hide footbox

participant ":Meals" as meal
participant "list[i]:Foods" as food

[->meal: calcTotal():double
activate meal
meal -> meal: total = 0
loop for i=0; i<count; i++
  note right
    count: これまでに登録された食品数
    list[i]: i番目の食品（Foodsオブジェクト）
    gram[i]: i番目のグラム数
  endnote
  meal -> food: cal = getCalorie():double
  activate food
  meal <-- food
  deactivate food
  meal -> meal: total += cal * (gram[i] / 100)
end
[<--meal: total

@enduml
```

