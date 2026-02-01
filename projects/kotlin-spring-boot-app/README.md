# Kotlin Spring Boot App

## 概要
このプロジェクトは Kotlin + Spring Boot のサンプルアプリケーションです。

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
