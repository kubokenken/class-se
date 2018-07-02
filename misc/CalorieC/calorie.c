#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXELEM 100

int count;
char *foods[MAXELEM];
double calorie[MAXELEM];

void print_foodlist() {
  printf("--食品名一覧--\n");
  for (int i=0; i<count; i++) {
    printf("%s", foods[i]);
    printf("\t");
  }
  printf("\n------------\n");
}

void add_food(char *str, double cal) {
  size_t len = strlen(str) + 1;
  foods[count] = malloc(len);
  strcpy(foods[count], str);
  calorie[count] = cal;
  count++;
}

int search_index(char *str) {
  int index = 0;
  while (index < count) {
    if (strcmp(str, foods[index]) == 0) {
      return index;
    }
    index++;
  }
  return index;
}

void regist_food() {
  char buf[255];
  double cal;
  printf("食品名を入力してください: ");
  scanf("%s", buf);
  printf("その食品のカロリーを入力してください [kcal/100g]: ");
  scanf("%lf", &cal);
  add_food(buf, cal);
  printf("登録しました．\n\n");
}

void calculate_calorie() {
  char buf[255];
  double gram;
  double total = 0.0;
  print_foodlist();
  while (1) {
    printf("食品名（endで計算）: ");
    scanf("%s", buf);
    if (strcmp(buf, "end") == 0) {
      break;
    }
    printf("グラム数: ");
    scanf("%lf", &gram);
    int index = search_index(buf);
    if (index < count) {
      total += calorie[index] * (gram / 100);
    }
  }
  printf("総カロリーは %6.2f kcalです．\n\n", total);
}

void initialize() {
  count = 0;
  add_food("米飯", 150.0);
  add_food("中華麺", 57.1);
  add_food("そば", 133.3);
  add_food("うどん", 100.0);
  add_food("素麺", 133.3);
  add_food("食パン", 250.0);
}

void main_menu() {
  int menu;
  printf("カロリー計算ツール\n");
  while (1) {
    printf("登録は1を，計算は2を，終了は0を入力してください: ");
    scanf("%d", &menu);
    switch (menu) {
    case 1:
      regist_food();
      break;
    case 2:
      calculate_calorie();
      break;
    case 0:
      return;
    default:
      break;
    }
  }
}

void main() {
  initialize();
  main_menu();
}
