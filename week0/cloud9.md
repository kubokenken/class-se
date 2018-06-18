<!-- footer: ソフトウェア工学　2018年度版-->
<!-- page_number: true -->

# Cloud9

---

## Cloud9 とは

クラウド IDE (統合開発環境)で有料サービスとしては Amazon が提供している．Cloud9 のコアはオープンソースであり，ローカル環境でコンパイルすることで利用できる．

---

## 利用方法（学内のクライアントを利用）

- 情報工学専攻の端末（地下にある端末）を利用する．
- SSH クライアントで自分の PC から，地下の端末へ自分のアカウントでログインする．
	- アカウント（b1234567）は情報工学実験（地下室）で使うもの
	- 端末（huixpcXX）は次の表を参考

```
ssh b1234567@huispcXX.huis.hiroshima-u.ac.jp
```

---

| グループ | 端末 |
| :-- | :-- |
| Group 1 | huispc03 |
| Group 2 | huispc04 |
| Group 3 | huispc05 |
| Group 4 | huispc06 |
| Group 5 | huispc07 |
| Group 6 | huispc08 |
| Group 7 | huispc09 |
| Group 8 | huispc10 |
| Group 9 | huispc11 |
| Group 10 | huispc12 |
| Group 11 | huispc13 |
| Group 12 | huispc14 |
| Group 13 | huispc15 |
| Group 14 | huispc16 |
| Group 15 | huispc17 |
| Group 16 | huispc18 |
| Group 17 | huispc19 |

---

### インストール（初期設定）

- SSHログイン後に以下のコマンドを実行し Cloud9 を自分のユーザ環境にインストールする．

  ```sh
  c9-install
  ```

### 起動

- インストールが終了したら（インストールは５分くらいかかるかもしれません）以下のコマンドで Cloud9 サーバを起動する．パスワードは適当なものを自分で設定してください．cloud9 くらいの簡単な文字列で良いと思います．決して**本当のパスワードは設定しないで**ください

  ```sh
  c9-start password
  ```

---

- サーバスタートした時の http://133.....:.... というアドレスとポート番号はメモしておいてください．そのメモに従って以下のアドレスへアクセスします．

  ```
  http://huispcXX.huis.hiroshima-u.ac.jp:XXXXXX
  ```
  上記の `huispcXX` は適宜変更してください．またコロン以降の `XXXXXX` は先にメモしたポート番号です．
- ユーザとパスワードを聞かれるので自分の地下で実験するときのユーザ名と `c9-start` の時に自分で設定したパスワードを入れてください．

---

### 終了

- Cloud9 から huispcXX のコンソールが使えるのでそこから，
  ```
  c9-stop
  ```
  と実行してください．

---

## Cloud9 の使い方

- Web ブラウザから使い，ファイルの作成，保存については直感的にできると思います．
  - 左にファイルのツリーが表示されています．
  - タブのところにある「プラス丸」をクリックするとメニューがでるので [New File] とすると新規ファイルが作れます．
  - file メニューから save を選ぶ，またはキーボードショートカットで Ctrl+s （Mac は Cmd+s）すると保存します．初回は保存するディレクトリを選ぶ画面が出ます．
- タブのところの「プラス丸」から [New Terminal] とすると，Cloud9 が起動しているサーバの端末が使えます．SSHなどでログインしているのと同じ状態なので，cd, ls などのコマンドがすべて使えます．

---

## 利用方法（Dockerを利用してローカルPCで使う）

- Docker.md ファイルを参照

---

## 利用方法（Vagrant + VirtualBox を利用してローカルPCで使う）

※ Docker より少しわかりやすいかもしれません．

- Vagrant と VirtualBox をインストールします．
- https://github.com/okamumu/vagrant-c9 から `clone or download` で ZIP としてダウンロード＆展開します．

---

- 展開したディレクトリで以下のコマンドを使います（PowerShell? or Terminal）．
  <small>
  ```
  vagrant up # ubuntu をダウンロードするので初回は時間がかかると思います
  vagrant ssh -c c9-install # Cloud9 の環境をインストールします（上記参照）
  vagrant ssh -c c9-start # Cloud9 サーバを起動します（上記参照）
  vagrant ssh -c c9-stop # Cloud9 サーバを停止します（上記参照）
  vagrant halt # ubuntu を停止します
  ```
  </small>
- Cloud9 サーバが起動している状態で以下にブラウザからアクセスします．ユーザ名は vagrant, パスワードは cloud9 です．
  ```
  http://192.168.33.10:8080
  ```
