<!-- footer: ソフトウェア工学　2018年度版　第2週-->
<!-- page_number: true -->

- 講義は 13:20 から始めます．
- 先週作成した KPT を Bb9 から提出しておいてください<br>**（毎週の KPT を管理することにしました)**
- Bb9 資料の Cloud9 を見て環境を整えておいてください．
- note_week2.docx または note_week2.md をグループで提出してもらうのでグループで事前に打ち合わせをしておいてください．
- Markdown (md) のビューワーして Marp をカスタマイズしたものを Bb9 に置いたので必要であればダウンロードして活用してください（win32-x64: Windows 64bit, win32-ia32: Windows 32bit, darwin-x64: MacOSX）

---

# 第2週：オブジェクト指向プログラミング

## 構造化プログラミングとオブジェクト指向
## Java
## オブジェクト指向プログラミング（基礎）
## オブジェクト指向プログラミング（応用）

---

# 課題

### note_week2.docx または note_week2.md をグループで分担して作成して Bb9 を通じて提出せよ．

*今後の講義で図の作成なども行っていくので，いまのうちに md になれておくことを推奨します．*

---

# 第2週

## **構造化プログラミングとオブジェクト指向**
## Java
## オブジェクト指向プログラミング（基礎）
## オブジェクト指向プログラミング（応用）

---

# 構造化プログラミングとオブジェクト指向

## 構造化定理

- すべての処理は順序処理，分岐処理，反復処理の三つの組み合わせで作ることができる

```uml
@startuml
scale 1.5
title <size:18>順次処理</size>

start
:Statement 1;
:Statement 2;
:Statement 3;
end

@enduml
```

```uml
@startuml
scale 1.5
title <size:18>分岐処理</size>

start
if (Condition?) then (true)
  :Statement 1;
else (false)
  :Statement 2;
endif
end

@enduml
```

```uml
@startuml
scale 1.5
title <size:18>反復処理</size>

start
repeat
  :Statement 1;
repeat while (Condition?)
end

@enduml
```

---

- どのような処理でもGOTO文（任意の場所から任意の場所へジャンプする命令文）を使う必要がない
- 処理の最初（入り口）と処理の終わり（出口）が一つで十分
- プログラム全体を一つの入り口と出口をもつブロック単位で設計できる

<span style="font-size: 150%;">**構造化定理にもとづいた言語 :arrow_right: C言語**</span>

---

## 構造化設計／言語

- C言語による設計のポイント
	- 関数をどのように設計するか
	- 機能をどのように分解して関数化するか
- 構造化設計：どの機能によってデータがどのように変更されるか
- 欠点：設計上でデータと処理が分離しているため再利用性が低い

---

#### 再利用の例

- 以下のプログラムを線形リストをソートするプログラムに利用できるか？
- できる or できない：それはなぜか？

```c
/**
 * 長さ n の配列 x の要素を昇順にソートする
 * @param n 配列 x の要素数
 * @param x ソートする配列
 */
void sort(int n, int* x) {
  // ...
  // 何かしらの実装
  // ...
}
```

---

## オブジェクト指向設計／言語

- オブジェクト：処理とデータを一体化したもの
- 現実世界のモノ（オブジェクト）をモデル化
	- データ：情報
	- 処理：情報を変化させる操作
- オブジェクト同士の相互作用による処理
- ソフトウェア再利用性の向上

#### 例：テニスゲーム

- ボール：ボールが存在している位置情報と「動かす」という操作
- ラケットとボールの相互作用：打つ／打たれる，動く
- 再利用性：ボールオブジェクトを野球ゲームに流用

---

```java
class Container {
  int length; // 要素の長さ
  int getLength(); // 要素の長さを取得
  void swap(int i, int j); // i 番目と j 番目の要素を交換
  // ...
}
```

```java
/**
 * コンテナ型 x の要素を昇順にソートする
 * @param x ソートするコンテナ
 */
void sort(Container x) {
  // ...
  // 何かしらの実装
  // ...
}
```

---

## どちらを使えばいいの？

- 構造化言語
	- コンパイル・実行速度 :arrow_right: 速い
	- メンテナンス :arrow_right: あまり良くない
- オブジェクト指向言語
	- コンパイル・実行速度 :arrow_right: 遅い
	- メンテナンス :arrow_right: 良い

- 組込システム :arrow_right: 構造化言語 **最近は徐々にオブジェクト化**
- エンタープライズシステム :arrow_right: オブジェクト指向言語

### **オブジェクト指向は現在のプログラミングでは必須!!**

*Exercise: C言語, Java 以外で 4 つ以上のプログラミング言語を挙げて「オブジェクト指向」のスタイルでかけるかどうか調査せよ*

---

## オブジェクト指向言語の基本概念

### カプセル化

- オブジェクト内部のデータや振る舞いを外部から隠蔽
- 外部との相互作用（インタラクション）だけに注目させる

### 継承（インヘリタンス）

- あるオブジェクトが別のオブジェクトの特性を引き継ぐ
- オブジェクトを階層的に整理

### 多態性（ポリモフィズム）

- 同じ相互作用は同じでも振る舞いが違う
- インタフェースを共通化させる

---

### カプセル化

- 車の動作原理はしらないが運転はできる
- 内部の動作をユーザから隠蔽

### 継承（インヘリタンス）

- ハイブリッド車とガソリン車はともに「車」の特性を引き継ぐ
- 内部の動作原理は異なる

### 多態性（ポリモフィズム）

- ガソリン車でもハイブリッド車でも同じ操作で運転できる
- インタフェースを共通化されている

---

# 第2週

## 構造化プログラミングとオブジェクト指向
## **Java**
## オブジェクト指向プログラミング（基礎）
## オブジェクト指向プログラミング（応用）

---

# Java

## 概要

- Sun Microsystems 社（現在は Oracle に買収）が開発
- オブジェクト指向言語
- プラットフォーム非依存
	- 中間言語にコンパイルされ，仮想マシン上で動作
- 豊富なライブラリ
	- オブジェクト指向プログラミングによる部品化の恩恵

---

## コンパイルと実行

### Java ソースファイルの作成

- すべての手続き（メソッド）は何らかのクラスに属する
- main メソッドは外部から実行できる特殊なメソッド
	- `public static void main(String[] args)`

  *ファイル名： `Test.java`*
  ```java
  class Test {
      public static void main(String[] args) {
          System.out.println("Hello World");
      }
  }
  ```

---

### コンパイル

- javac コマンドによるコンパイルにより中間ファイルを生成する
- java ソースに記述してあるクラス名に対応した .class ファイルが生成される

  ```sh
  $ javac Test.java
  ```

- 上記のコマンドにより中間ファイル `Test.class` が生成される．

---

### 実行

- java コマンドによる実行
- `main` メソッドを含む**クラス名**を指定して実行（クラスファイル名ではないので .class はいらない）

  ```sh
  $ java Test
  Hello World
  ```

---

## C言語とJavaの相違点

### 型について

基本データ型（primitive）とよばれる以下の型は C 言語とほぼ同じ

| | C言語 | Java |
|:--| :-- | :-- |
|文字 | char | byte, char (unicode) |
|論理 | --- | boolean |
|整数 | int, short, long | int, short, long |
|浮動小数点| float, double | float, double |
|文字列| charの配列 | String クラス（primitiveではない） |

---

### 演算子について

C言語にあってJavaにないもの

- カンマ演算子
- sizeof 演算子
- アドレス演算子（&）
- ポインタ演算子（->）

Javaだけにあるもの

- new 演算子
- instanceof 演算子

---

### 文について

- 代入文, if文, for文, while文, do while 文, switch 文の書き方は同じ
- Java の新しいバージョンでは拡張 for 文などが使える

---

### 配列について

- new 演算子を使った配列の確保

  c 言語での
  ```c
  int a[3];
  ```
  を，Javaでは

  ```java
  int[] a = new int[3]; // int[] は型を表す
  ```
  とする．
- new は C 言語での malloc に相当するため，以下のようにしてプログラム途中で動的に配列を確保することができる

  ```java
  int[] a;
  ...
  a = new int[3];
  ```

---

### その他の相違点

- Java では**ポインタ**を明示しない．参照型変数を利用する．
- Java ではグローバル変数宣言ができない
- Java には構造体がない（クラスを利用する）

*Exercise: Java で FizzBuzz 問題をプログラミング*

---

# 第2週

## 構造化プログラミングとオブジェクト指向
## Java
## **オブジェクト指向プログラミング（基礎）**
## オブジェクト指向プログラミング（応用）

---

# オブジェクト指向プログラミング（基礎）

- クラス
- 属性（フィールド変数）
- 操作（メソッド）
- インスタンス化
- コンストラクタ
- 参照型変数
- this
- static 修飾子

---

## クラス

- オブジェクトの定義
- クラスとオブジェクトを区別する（クラスを**インスタンス化**したものがオブジェクト）

- Javaにおけるクラスの定義
	- クラス名は大文字で始める（推奨）
	- クラス内のデータ構造 :arrow_right: **フィールド変数**
	- クラスに対する操作（手続き）:arrow_right: **メソッド**

```java
[修飾子] class クラス名 {
    <<フィールド>>
    <<コンストラクタ>>
    <<メソッド>>
}
```

---

## フィールド変数の定義

- クラスの属性
- オブジェクト自身が知っていること

### 例

- 人間は自分の名前や年齢を知っている

  *ファイル名： `Person.java`* を作成

  ```java
  class Person {
      String name; // 名前
      int age; // 年齢
      ...
  }
  ```

---

## メソッドの定義

- そのクラスに対する「操作」（クラス属性を変化させる）
- 必ず何らかのクラス内で定義する
- C言語の関数のようなもの
- `main` メソッドはプログラム実行時に最初に実行される特殊なメソッド

---

### 例

- 「人間」クラスでは，「名前や年齢を聞く」と言う操作ができる

  *ファイル名： `Person.java`* にメソッドを追加

  ```java
  class Person {
      // ... フィールド変数の定義は省略 ...

      /* 名前を聞くという操作を表すメソッド */
      String getName() {
          return name;
      }

      /* 年齢を聞くという操作を表すメソッド */
      int getAge() {
          return age;
      }
  }
  ```

---

## インスタンス化

- インスタンス化：クラスからオブジェクトを生成する手続き
- オブジェクト：クラスから生成された実体
- Java におけるインスタンス化は new 演算子を使う

---

### 例

*ファイル名： `Test.java`* を変更
```java
class Test {
  public static void main(String[] args) {
    System.out.println("Hello World");
    // Person クラスのインスタンス化して
    // 山田さんの実体を作る
    Person yamada = new Person();

    System.out.println(
    	yamada.getName() // ドットによるメソッド呼び出し
        + "さんの年齢は" // + で文字連結
        + yamada.getAge()
        + "です");
  }
}
```

---

### 実行結果

```sh
$ javac Test.java Person.java
$ java Test
Hello World
nullさんの年齢は0です
```

---

## コンストラクタ

- 初期化のための特殊なメソッド
- インスタンス化の時に一度だけ呼ばれる
- フィールド変数の初期化などを行う
- Java の場合は**クラス名と同じ名前のメソッドとしてコンストラクタを定義**

---

### 例

*ファイル名： `Person.java`* にコンストラクタを追加

```java
class Person {
    // ... フィールド変数の定義は省略 ...

    /* コンストラクタでフィールド変数を初期化 */
    Person(String n, int a) {
      name = n;
      age = a;
    }

    // ... メソッドの定義は省略 ...
}
```

---

*ファイル名： `Test.java`* で new の部分に引数を与える
```java
class Test {
  public static void main(String[] args) {
    // ... 省略 ...

    Person yamada = new Person("山田", 25);

    // ... 省略 ...
  }
}
```

---

### 実行結果

```sh
$ javac Test.java Person.java
$ java Test
Hello World
山田さんの年齢は25です
```

---

## 参照型変数

- オブジェクトを参照するための変数
	- `Person a` は「Person 型のオブジェクトを参照のに a と言う変数を使う」という宣言
- C言語におけるポインタと似ている
- Java では基本データ型以外のクラスに対する変数はすべて参照型変数
- オブジェクトをコピーする場合はコピーするためのメソッド（例えば `clone`）が必要

---

*ファイル名： `Person.java`* にメソッドを追加
```java
class Person {
    // 省略

    /* 年齢を増やすメソッド */
    void incAge() {
        age++;
    }
}
```

---

*ファイル名： `Test.java`* を以下のように変更
```java
class Test {
  static void print(Person a) {
    a.incAge();
    System.out.println(a.getName() + "さんの年齢は"
      + a.getAge() + "です");
  }

  public static void main(String[] args) {
    Person a = new Person("山田", 25);
    Person b = new Person("鈴木", 44);
    Person c = a;
    print(a); print(b);
    print(a); print(b);
    a = b;
    print(a); print(b);
    b = c;
    print(a); print(b);
  }
}
```
*<small>Exercise: 出力を予想せよ．なぜそのような出力になるかグループで議論せよ</small>*

---

### 特殊な参照型変数

- this: 自分自身を参照する参照型変数（代入不可，原則参照のみ）

*ファイル名： `Person.java`* にコンストラクタで this を利用

```java
class Person {
    // ... フィールド変数の定義は省略 ...

    /**
      * コンストラクタ
      * @param name 名前
      * @param age 年齢
      */
    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    // ... メソッドの定義は省略 ...
}
```

---

## static 修飾子

- フィールドおよびメソッドに適用可能
- コンパイル時に実体を作成するため new しなくてもよい

---

```java
class StaticTest {
  int x = 2;

  public static int getOne() {
    // NG: static 関数で non-static 変数を参照してはいけない
    return x;
  }

  public int getTwo() {
    return x;
  }
}
```

```java
class Test {
  public static void main(String[] args) {
    StaticTest.getOne(); // OK
    // NG: non-static 変数は new してから呼び出す
    StaticTest.getTwo();
    StaticTest s = new StaticTest();
    s.getOne(); // OK
    s.getTwo(); // OK
  }
}
```

---

# 第2週

## 構造化プログラミングとオブジェクト指向
## Java
## オブジェクト指向プログラミング（基礎）
## **オブジェクト指向プログラミング（応用）**

---

# オブジェクト指向プログラミング（応用）

- オーバーロード
- 継承
- オーバーライド
- super
- キャスト（参照型変数）
- 抽象クラス
- インタフェース

---

# オブジェクト指向プログラミング（応用）

## オーバーロード

- 同じメソッド名でも引数の異なるものは別のメソッドとして実装する
- 多態性を実現するための方法
- コンストラクタのオーバーロードがよく使われる

---

*ファイル名： Print.java*

```java
class Print {
  void print(int x) {
    System.out.println("整数: " + x);
  }

  void print(int[] x) {
    System.out.print("整数の配列:");
    for (int i=0; i<x.length; i++) {
      System.out.print(" " + x[i]);
    }
    System.out.println();
  }

  void print(String x) {
    System.out.println("文字列: " + x);
  }
}
```

---

*ファイル名： Test.java*

```java
class Test {
  public static void main(String[] args) {
    Print p = new Print(); // Printクラスのインスタンスを生成

    String a = "abc";
    int b = 4;
    int[] c = {1, 2, 3, 4, 5};

    p.print(a);
    p.print(b);
    p.print(c);
  }
}
```

---

*実行結果*

```sh
javac Print.java Test.java
java Test
文字列: abc
整数: 4
整数の配列: 1 2 3 4
```

---

## 継承（インヘリタンス）

- あるクラスが別のクラスの属性や操作を引き継ぐ
- 継承のもととなったクラス
	- スーパークラス，親クラス，基底クラス，上位クラス
- 継承したクラス
	- サブクラス，子クラス，派生クラス，下位クラス
- Javaにおける継承は必ず親が1種類（多重継承を禁止）

```java
class B extends A {
	// フィールドを記述

	// コンストラクタを記述（特殊なメソッド）

	// メソッドを記述
}
```

---

### プログラミングの観点から

- いくつかのクラスで共通する属性や操作を一つのクラスにまとめる
- OAOO (Once and only once) 原則: 同じコードを何度も書かない
	- 同じコードがいくつもの場所にあるとプログラムの保守性が低下する

---

*ファイル名：PrintHello.java*

```java
class PrintHello {
  int num;

  PrintHello() {
    num = 10;
  }

  void printHello() {
    System.out.println("Hello" + num);
  }
}
```

---

*ファイル名：PrintHelloWorld.java*

```java
class PrintHelloWorld extends PrintHello {
  void printHelloWorld() {
    System.out.println("Hello World" + num);
  }
}
```

---

*ファイル名：Test.java*

```java
class Test {
  public static void main(String[] args) {
    PrintHello p1 = new PrintHello();
    PrintHelloWorld p2 = new PrintHelloWorld();

    p1.printHello();
    p2.printHello(); // 継承により親のメソッドが使える
    p2.printHelloWorld();
  }
}
```

---

*実行結果*

```sh
javac PrintHello.java PrintHelloWorld.java Test.java
java Test
Hello10
Hello10
Hello World10
```

---

## オーバーライド

- 子クラスが親クラスの操作を置き換える
- 多態性を実現するための方法

---

*ファイル名：PrintHelloWorld.java*

```java
class PrintHelloWorld extends PrintHello {
  /* 以下のメソッドで親クラスの printHello を置き換える */
  void printHello() {
    System.out.println("Helloを置き換え" + num);
  }

  void printHelloWorld() {
    System.out.println("Hello World" + num);
  }
}
```

---

*実行結果*

```sh
javac PrintHello.java PrintHelloWorld.java Test.java
java Test
Hello10
Helloを置き換え10
Hello World10
```

---

## 継承とコンストラクタ

- Java の場合はコンストラクタは引き継がれない
- super で親クラスのコンストラクタを利用できる

---

*ファイル名：PrintHello.java*

```java
class PrintHello {
  int num;

  PrintHello(int num) { // 引数を取るように変更
    this.num = num;
  }

  void printHello() {
    System.out.println("Hello" + num);
  }
}
```

---

*ファイル名：PrintHelloWorld.java*

```java
class PrintHelloWorld extends PrintHello {
  PrintHelloWorld() {
    super(1000); // 親クラスのコンストラクタを利用（呼び出し）
  }

  void printHello() {
    System.out.println("Helloを置き換え" + num);
  }

  void printHelloWorld() {
    System.out.println("Hello World" + num);
  }
}
```

---

*ファイル名：Test.java*

```java
class Test {
  public static void main(String[] args) {
    PrintHello p1 = new PrintHello(10); // 変更
    PrintHelloWorld p2 = new PrintHelloWorld();

    p1.printHello();
    p2.printHello(); // 継承により親のメソッドが使える
    p2.printHelloWorld();
  }
}
```

---

*実行結果*

```sh
javac PrintHello.java PrintHelloWorld.java Test.java
java Test
Hello10
Hello1000
Hello World1000
```
*Exercise: `PrintHelloWorld.java` の `printHelloWorld` メソッドを次のように書き換えた場合どのようになるか*

```java
  void printHelloWorld() {
    super.printHello(); // これを追加
    System.out.println("Hello World" + num);
  }
```

---

## 参照型変数のキャスト

- 基本データ型のキャスト :arrow_right: C言語と同じで実体が変更
- 例：int から double のキャストはビット列で見ると変化している
- 参照型変数のキャスト :arrow_right: 実体は変化せず．**変更したクラスと見なす**
- アップキャスト
	- 子クラスから親クラスへのキャスト．親クラスとみなす．子クラスは親クラスの属性・操作を引き継いでいるため安全
- ダウンキャスト
	- 親クラスから子クラスへのキャスト．子クラスとみなす．親クラスでは実装されていない操作などがあるため，instanceof 演算子などで明示的にチェックする必要があるときがある

---

*ファイル名：Animal.java*

```java
class Animal {
  String name;

  Animal(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  void print() {
    System.out.println("名前は" + name + "です");
  }
}
```

---

*ファイル名：Pet.java*

```java
class Pet extends Animal {
  Person myMaster;

  Pet(String name) {
    super(name);
  }

  void setMaster(Person master) {
    myMaster = master;
  }

  Person getMaster() {
    return myMaster;
  }

  @Override
  void print() {
    System.out.println(name + "の飼い主は"
      + myMaster.getName() + "です");
  }
}
```

---

*ファイル名：Person.java*

```java
class Person extends Animal {
  Pet myPet;

  Person(String name) {
    super(name);
  }

  void keepPet(Pet pet) {
    myPet = pet;
    pet.setMaster(this);
  }

  Pet getPet() {
    return myPet;
  }

  @Override
  void print() {
    System.out.println(name + "は"
      + myPet.getName() + "を飼っています");
  }
}
```

---

*ファイル名：Test.java*

```java
class Test {
  public static void main(String[] args) {
    Pet a = new Pet("ポチ");
    Person b = new Person("田中");
    Animal c = new Animal("菊池");
    b.keepPet(a);
    a.print();
    b.print();
    c.print();
  }
}
```

---

*実行結果*

```sh
javac Animal.java Pet.java Person.java Test.java
java Test
ポチの飼い主は田中です
田中はポチを飼っています
名前は菊池です
```

---

### 以下のように変更

*ファイル名：Test.java*

```java
class Test {
  public static void main(String[] args) {
    Animal a = new Pet("ポチ"); // アップキャスト
    Animal b = new Person("田中"); // アップキャスト
    Animal c = new Animal("菊池");

    ((Person) b).keepPet((Pet) a); // a, b をダウンキャスト

    a.print(); // これがAnimalのprintにならないことに注意
    b.print(); // これがAnimalのprintにならないことに注意
    c.print();
  }
}
```

---

## 抽象クラスとインタフェース

- 抽象メソッドをもつクラス．abstract のキーワードをつける．
- 抽象メソッド：インタフェースの定義（C言語で言うプロトタイプ宣言）だけして実装を子クラスに任せるメソッド．abstract のキーワードをつける．
- インタフェース：抽象メソッドだけで定義されるクラス．多重継承ができる．extends ではなく implements を使う

---

```java
abstract class クラス名 {
	// フィールドを記述

	// コンストラクタを記述（特殊なメソッド）

	abstract 戻り値の型 メソッド名1(引数); //
	abstract 戻り値の型 メソッド名2(引数); //

	// メソッドを記述
}
```

```java
interface インタフェース名 {
	データ型 変数名 = 値;
	データ型 変数名 = 値;

	戻り値の型 メソッド名1(引数);
	戻り値の型 メソッド名2(引数);
}
```

---

*ファイル名：Print.java*

```java
abstract class Print {
  abstract void print();
}
```

---

*ファイル名：PrintHello.java*

```java
class PrintHello extends Print {
  // 継承した上でメソッドをオーバーライド
  void print() {
    System.out.println("Hello");
  }
}
```

---

*ファイル名：PrintHelloWorld.java*

```java
class PrintHelloWorld extends Print {
  void print() {
    System.out.println("HelloWorld");
  }
}
```

---

*ファイル名：HasA.java*

```java
class HasA {
  Print p;

  HasA(Print p) {
    this.p = p;
  }

  void print() {
    p.print();
  }
}
```

---

*ファイル名：Test.java*

```java
class Test {
  public static void main(String[] args) {
    HasA classA = new HasA(new PrintHello());
    HasA classB = new HasA(new PrintHelloWorld());

    classA.print();
    classB.print();
  }
}
```

*<small>
Excercise: Print.java を interface を使って書き換え，PrintHello.java, PrintHelloWorld.java, HasA.java, Test.java も必要があれば修正せよ．
</small>*

---

# Excercise

## *FizzBuzz 問題をオブジェクト指向プログラミングで作成せよ*

- 数字，Fizz, Buzz, FizzBuzz をオブジェクト（クラス）とする

---

# 課題

### note_week2.docx または note_week2.md をグループで分担して作成して Bb9 を通じて提出せよ．

*今後の講義で図の作成なども行っていくので，いまのうちに md になれておくことを推奨します．*

---

# ふりかえり

- 今週のグループでの共同作業をふりかって，良かった点，悪かった点を議論する．
- 次回に向けて KPT を作っておく
	- K (Keep): 次回も続けること（良かったこと）
	- P (Problem): 今回問題となったこと（悪かったこと）
	- T (Try): 問題を解決するために次回自分たちがチャレンジすること
- Bb9 を通じて提出すること
