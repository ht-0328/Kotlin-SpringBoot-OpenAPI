# Kotlin Spring Boot App

## 概要
このプロジェクトは Kotlin + Spring Boot のサンプルアプリケーションです。

## 開発環境とトラブルシューティング

### 開発環境
- エディタ: VS Code
- Kotlin 言語サーバ: [Kotlin LSP](https://github.com/Kotlin/kotlin-lsp)

### OpenAPI Generator と IDE の連携
このプロジェクトでは OpenAPI Generator を使用して Kotlin コードを自動生成しています。

`./gradlew :app:generateOpenApiServer` 実行後、Gradle のビルドやテストが成功する場合でも、VS Code + Kotlin LSP 環境下では生成されたコードが即座に認識されず、エディタ上で `Unresolved reference` エラーが表示されることがあります。

これは IDE / Kotlin LSP 側の挙動であり、ビルドや実行結果には影響ありません。この現象が発生した場合は、VS Code の **Reload Window** を実行して言語サーバを再起動してください。

## エンドポイント

### Hello
Spring Boot 起動確認用のエンドポイントです。

### OpenAPI Ping (/api/ping)
OpenAPI Generator の自動生成が動くか確認用のエンドポイントです。
- 仕様ファイル: `app/src/main/resources/openapi/ping.yaml`

## 確認コマンド

### OpenAPI コード生成
```bash
./gradlew :app:generateOpenApiServer
```

### アプリケーション起動
```bash
./gradlew :app:bootRun
```
