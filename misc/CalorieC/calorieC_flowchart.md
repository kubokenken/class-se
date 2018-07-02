```uml
@startuml
skinparam shadowing false

start
:printf("--食品名一覧--\\n");
:i=0;
while (i < count)
  :printf("%s", foods[i]);
  :printf("\\t");
  :i++;
endwhile
:printf("\\n------------\\n");
stop
@enduml
```

---

```uml
@startuml
skinparam shadowing false

start
:len = strlen(str) + 1;
:foods[count] = malloc(len);
:strcpy(foods[count], str);
:calorie[count] = cal;
:count++;
stop
@enduml
```
---

```uml
@startuml
skinparam shadowing false

start
:index = 0;
while (index < count)
    if (strcmp(str, foods[index]) == 0) then (true)
      :return index;
      stop
    endif
:index++;
endwhile
:return index;
stop
@enduml
```

---

```uml
@startuml
skinparam shadowing false

start
:printf("食品名を入力してください: ");
:scanf("%s", buf);
:printf("その食品のカロリーを入力してください [kcal/100g]: ");
:scanf("%lf", &cal);
:add_food(buf, cal);
:printf("登録しました．\\n\\n");
stop
@enduml
```

---

```uml
@startuml
skinparam shadowing false

start
:total = 0.0;
:print_foodlist();
repeat
:printf("食品名（endで計算）: ");\nscanf("%s", buf);
if (strcmp(buf, "end") == 0) then (true)
break
endif
:printf("グラム数: ");\nscanf("%lf", &gram);
:index = search_index(buf);
if (index < count) then (true)
:total += calorie[index] * (gram / 100);
endif
repeatwhile
:printf("総カロリーは %6.2f kcalです．\\n\\n", total);
stop
@enduml
```

---

```uml
@startuml
skinparam shadowing false

start
:printf("カロリー計算ツール\\n");
repeat
:printf("登録は1を，計算は2を，終了は0を入力してください: ");\n scanf("%d", &menu);
if (menu == 0) then (true)
stop
elseif (menu == 1) then (true)
:regist_food();
elseif (menu == 2) then (true)
:calculate_calorie();
else (false)
endif
@enduml
```
