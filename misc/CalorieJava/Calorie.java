/* 注意：1 ファイル 1 クラスの原則をやぶっているので
 その点については良いコーディングではありません．
*/

import java.util.Scanner;

class Foods {
  double calorie;
  String name;

  public Foods(String name, double calorie) {
      this.name = name;
      this.calorie = calorie;
  }

  public String getName() {
    return name;
  }

  public double getCalorie() {
    return calorie;
  }
}

class Meals {
    int count;
    Foods[] foods;
    double[] gram;

    public Meals(int maxElement) {
        count = 0;
        foods = new Foods [maxElement];
        gram = new double [maxElement];
    }

    public void add(Foods food, double gram) {
        this.foods[count] = food;
        this.gram[count] = gram;
        count++;
    }

    public double calcTotal() {
        double total = 0.0;
        for (int i=0; i<count; i++) {
            total += foods[i].getCalorie() * (gram[i] / 100);
        }
        return total;
    }
}

class FoodList {
    int count;
    Foods[] list;

    public FoodList(int maxElement) {
        count = 0;
        list = new Foods [maxElement];
    }

    public void add(Foods food) {
        list[count] = food;
        count++;
    }

    public Foods get(String name) {
        for (int i=0; i<count; i++) {
            if (list[i].getName().equals(name)) {
                return list[i];
            }
        }
        return null;
    }

    public String[] getName() {
        String[] s = new String [count];
        for (int i=0; i<count; i++) {
            s[i] = list[i].getName();
        }
        return s;
    }
}

class FoodListController {
    Scanner sc;
    FoodList foodList;

    FoodListController(FoodList foodList) {
        this.foodList = foodList;
        this.sc = new Scanner(System.in);
    }

    public void regist() {
        System.out.print("食品名を入力してください: ");
        String name = sc.next();
        System.out.print("その食品のカロリーを入力してください [kcal/100g]: ");
        double calorie = sc.nextDouble();
        foodList.add(new Foods(name, calorie));
        System.out.println("登録しました．");
        System.out.println();
    }

    public void displayList() {
        System.out.println("--食品名一覧--");
        for (String str: foodList.getName()) {
            System.out.print(str + "\t");
        }
        System.out.println();
        System.out.println("------------");
    }
}

class MealController {
    Scanner sc;
    FoodList foodList;
    Meals meal;

    MealController(FoodList foodList) {
        this.foodList = foodList;
        this.sc = new Scanner(System.in);
    }

    public void create() {
        meal = new Meals(100);
        while (true) {
            System.out.print("食品名（endで計算）: ");
            String name = sc.next();
            if (name.equals("end")) {
                return;
            }
            Foods food = foodList.get(name);

            System.out.print("グラム数: ");
            double gram = sc.nextDouble();

            meal.add(food, gram);
        }
    }

    public void total() {
        System.out.println("総カロリーは " + meal.calcTotal() + " kcalです．");
        System.out.println();
    }
}

class MainController {
    Scanner sc;
    FoodListController foodListControl;
    MealController mealControl;

    public MainController() {
        this.sc = new Scanner(System.in);
        FoodList foodList = new FoodList(100);
        foodListControl = new FoodListController(foodList);
        mealControl = new MealController(foodList);

        foodList.add(new Foods("米飯", 150.0));
        foodList.add(new Foods("中華麺", 57.1));
        foodList.add(new Foods("そば", 133.3));
        foodList.add(new Foods("うどん", 100.0));
        foodList.add(new Foods("素麺", 133.3));
        foodList.add(new Foods("食パン", 250.0));
    }

    void run() {
        System.out.println("カロリー計算ツール");
        while (true) {
            System.out.print("登録は1を，計算は2を，終了は0を入力してください: ");
            switch (sc.nextInt()) {
            case 0:
                return;
            case 1:
                foodListControl.regist();
                break;
            case 2:
                foodListControl.displayList();
                mealControl.create();
                mealControl.total();
                break;
            default:
                break;
            }
        }
    }

    public static void main(String[] args) {
        MainController top = new MainController();
        top.run();
   }
}
