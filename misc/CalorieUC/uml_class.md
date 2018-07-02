```uml
@startuml
skinparam shadowing false
scale 1.5
left to right direction

actor :ユーザ: as u
usecase uc1 as "食品を登録する"
usecase uc2 as "カロリーを計算する"

u -- uc1
u -- uc2
@enduml
```
