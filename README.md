# Kotlin Spring Boot App

このプロジェクトは Kotlin と Spring Boot を使用したサンプルアプリケーションです。

## 起動方法

以下のコマンドを実行してアプリケーションを起動してください。

```bash
cd projects/kotlin-spring-boot-app
./gradlew bootRun
```

初回実行時は依存関係のダウンロードやビルドに時間がかかる場合があります。

## 動作確認

起動後、ブラウザで以下の URL にアクセスして動作を確認してください。

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
  - API の定義を閲覧し、リクエストを送信してテストできます。
- **OpenAPI 定義 (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## トラブルシューティング

### 起動に失敗する場合

1. **ポート 8080 が既に使用されている**
   - エラー: `Web server failed to start. Port 8080 was already in use.`
   - 対処: 既に起動しているプロセスを停止するか、別のポートを使用してください。
   - 確認コマンド: `lsof -i :8080`

2. **Java のバージョンについて**
   - このプロジェクトは Java 17 以降を推奨しています。
   - `./gradlew` コマンドを使用すれば、Gradle が適切な Java バージョンを自動的に解決しようと試みますが、環境によっては手動で Java 17 以上をインストールする必要があります。
