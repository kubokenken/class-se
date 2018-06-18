<!-- footer: ソフトウェア工学　2018年度版　第2週-->
<!-- page_number: true -->
<!-- $size: A4 -->

1. 構造化設計／言語とはどのような特徴があるかまとめよ

---

2. オブジェクト指向設計／言語とはどのような特徴があるかまとめよ

---

3. C言語，Java 以外の 4 つ以上のプログラミング言語を挙げて「オブジェクト指向」のスタイルでかけるかどうか調査せよ．

---

4. オブジェクト指向における以下の概念を簡潔に説明せよ．
- カプセル化
- 継承（インヘリタンス）
- 多態性（ポリモフィズム）

---

5. Java言語で以下の FizzBuzz 問題をプログラミングせよ．

- 1から100まで順番に数字または指定の文字列を出力する
- 3の倍数の時は `Fizz`, 5の倍数の時は `Buzz`, 3の倍数かつ5の倍数の時は`FizzBuzz` と出力する．
- 上記以外の場合は数字を出力する．

```
1
2
Fizz
4
Buzz
...中略...
98
Fizz
Buzz
```

プログラムソースを以下に記述
```java
```

---

6. `参照型変数` におけるプログラム例の出力を予想せよ．また，なぜそのような出力になるか記述せよ．

出力予測：

理由：

---

7. `継承とコンストラクタ` のプログラム例において，`PrintHelloWorld.java` の `printHelloWorld` メソッドを次のように書き換えた場合どのような出力になるか予想せよ．また，なぜそのような出力になるか記述せよ．

```java
  void printHelloWorld() {
    super.printHello(); // これを追加
    System.out.println("Hello World" + num);
  }
```

出力予測：

理由：


---

8. `抽象クラスとインタフェース` のプログラム例で，Print.java を interface を使って書き換えよ．そのときの，PrintHello.java, PrintHelloWorld.java, HasA.java, Test.java も記述せよ．

*ファイル名：Print.java*

```java
```

*ファイル名：PrintHello.java*

```java
```

*ファイル名：PrintHelloWorld.java*

```java
```

*ファイル名：HasA.java*

```java
```

*ファイル名：Test.java*

```java
```

---

9. FizzBuzz問題をオブジェクト指向でプログラミングせよ．

プログラムソースを以下に記述（複数ファイルになってよい）

```java
```
