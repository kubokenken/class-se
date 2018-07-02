PlantUML は Graphviz の dot 言語をそのまま使えるので
dot 言語で DFD を作成します．

```uml
@startuml
digraph G {
  graph [layout=dot, rankdir="LR"];

  User [shape=square, label="User"]
  regist_food [shape=oval, label="regist_food"]
  calculate_calorie [shape=oval, label="calculate_calorie"]
  add_food [shape=oval, label="add_food"]
  print_foodlist [shape=oval, label="print_foodlist"]
  search_index [shape=oval, label="search_index"]
  food [shape=plaintext, label=<<table border="0"><tr><td border="1" sides="TB">food</td></tr></table>>];
  calorie [shape=plaintext, label=<<table border="0"><tr><td border="1" sides="TB">calorie</td></tr></table>>];

  {rank = same; regist_food; calculate_calorie; print_foodlist}
  {rank = same; add_food; search_index}
  {rank = same; food; calorie}

  User -> regist_food [label = "food_name, calorie"];
  regist_food -> add_food [label = "food_name, calorie"];
  add_food -> food [label = "food_name"];
  add_food -> calorie [label = "calorie"];

  User -> calculate_calorie [label = "food_name, gram"];
  calculate_calorie -> User [label = "total calorie"];
  print_foodlist -> User [label = "food_names"];
  calculate_calorie -> search_index [label = "food_name"];
  calorie -> calculate_calorie [label = "calorie"];
  search_index -> calculate_calorie [label = "index of food_name"];
  food -> search_index [label = "food_name"];
  food -> print_foodlist [label = "food_name"];
}
@enduml
```
