環境構築手順
--------------------------
1、 VSCodeに「Extension Pack for Java」と「Spring Boot Extension Pack」をインストール
--------------------------

 １、VSCodeを開く

 ２、サイドバーの拡張機能アイコンをクリック

 ３、下記の２つを検索してインストール


・Extension Pack for Java

・Spring Boot Extension Pack

2、GitHubリポジトリからソースをクローンする
--------------------------
１、ソースコードを保存したいディレクトリをvscodeで開きます。

２、下記コマンドをvscodeのターミナルで実行し、自身のPCにインストールします。
```
git clone https://github.com/prum-jp/academy-springboot-base.git
```

３、コンテナ上でビルドを実行
--------------------------

１、クローンしたフォルダをvscodeで開き、ターミナルで以下のコマンドを叩き、Javaコンテナを起動します。
```
docker-compose up -d
```

２、コンテナを作成・起動したら、javaコンテナ内に入ります。
```
docker compose exec app bash
```
※ターミナルに以下のような文字列が表示されれば成功です。

`root@569495f96ff8:/app#`

３、ビルドを実行する
```
./gradlew build --continuous
```

4、別のターミナルから再度コンテナ内に入りSpringを起動
--------------------------
1、コンテナ内に入る
```
docker compose exec app bash
```

２、Springを起動
```
./gradlew bootRun
```

５、VSCodeのデバッグモードで起動
--------------------------
最後にVSCodeのデバッグモードで起動します。

VSCodeのデバッグビューを開いて、サイドバーの［実行とデバッグ］アイコンをクリックすると、「java（Attach）」と表示されているプルダウンがあります。

![スクリーンショット 2024-04-22 23.17.43.png](https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/3744277/7b7d9cc9-9cf6-294f-d87f-2768b143b445.png)


この状態で▶️（開始ボタン）を押すことで、デバッグモードが起動されます。

うまく起動したら、下記のURLにアクセスしてください。

http://localhost:8080/


下記画像のように「Whitelabel Error Page」が表示されていれば、環境構築完了です。
![スクリーンショット 2024-04-22 23.13.29.png](https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/3744277/29986c70-eaf3-31b1-6b4d-6ae98390f38f.png)
