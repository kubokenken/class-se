/*
注意：簡単化のため1ファイル1クラスの原則を破っているのであまり
良いコーディングではありません．
*/

interface Answer {
  void print();
}

class NoFizzBuzz implements Answer {
  int number;

  public NoFizzBuzz(int number) {
    this.number = number;
  }

  @Override
  public void print() {
    System.out.println(number);
  }
}

class Fizz implements Answer {
  @Override
  public void print() {
    System.out.println("Fizz");
  }
}

class Buzz implements Answer {
  @Override
  public void print() {
    System.out.println("Buzz");
  }
}

class FizzBuzz implements Answer {
  @Override
  public void print() {
    System.out.println("FizzBuzz");
  }
}

class Number {
  int number;

  public Number(int number) {
    this.number = number;
  }

  public Answer createFizzBuzzAnswer() {
    if (number % 3 == 0 && number % 5 == 0) {
      return new FizzBuzz();
    } else if (number % 3 == 0) {
      return new Fizz();
    } else if (number % 5 == 0) {
      return new Buzz();
    } else {
      return new NoFizzBuzz(number);
    }
  }
}

class FizzBuzzMain {
  public static void main(String[] args) {
    for (int i=1; i<=100; i++) {
      Number num = new Number(i);
      num.createFizzBuzzAnswer().print();
    }
  }
}
