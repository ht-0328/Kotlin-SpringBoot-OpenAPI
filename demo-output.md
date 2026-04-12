### 1. search-openapi.yml

```yaml
openapi: 3.0.0
info:
  title: Search API Demo
  version: 1.0.0
  description: OpenAPIでは検索条件を個別のクエリパラメータとして定義し、Spring Boot側ではそれを1つのオブジェクトで受け取るデモ
paths:
  /users:
    get:
      summary: ユーザー検索
      description: 検索条件を指定してユーザー一覧を取得します
      operationId: searchUsers
      parameters:
        - name: keyword
          in: query
          description: 検索キーワード
          required: false
          schema:
            type: string
        - name: statuses
          in: query
          description: ステータスの配列
          required: false
          style: form
          explode: true
          schema:
            type: array
            items:
              type: string
        - name: page
          in: query
          description: ページ番号
          required: false
          schema:
            type: integer
        - name: size
          in: query
          description: 1ページあたりの件数
          required: false
          schema:
            type: integer
      responses:
        '200':
          description: 成功時のレスポンス（デモ用のため任意のJSON）
          content:
            application/json:
              schema:
                type: object
                additionalProperties: true
```

### 2. SearchUserCondition.kt

```kotlin
package com.demo

data class SearchUserCondition(
    val keyword: String? = null,
    val statuses: List<String>? = null,
    val page: Int? = null,
    val size: Int? = null
)
```

### 3. UserController.kt

```kotlin
package com.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/users")
    fun searchUsers(condition: SearchUserCondition): Map<String, Any?> {
        // デモ用: 受け取った SearchUserCondition の内容をそのまま JSON として返す
        return mapOf(
            "receivedCondition" to condition,
            "message" to "This is a demo response to show how query parameters are mapped to a single object."
        )
    }
}
```

### 4. このデモで説明していること

- **OpenAPIではクエリパラメータを個別に定義する**: OpenAPI上で1つのオブジェクトとして定義するのではなく、`keyword` や `statuses` などをそれぞれ個別のクエリパラメータとして定義します。これにより、クライアントからは標準的で直感的なURL（`?keyword=...&page=...`）として見えます。
- **配列パラメータの表現**: `statuses` のように複数値を受け取るものは `style: form` と `explode: true` を使うことで、`?statuses=ACTIVE&statuses=LOCKED` という標準的な配列のクエリ形式で表現できることを示しています。
- **Spring Boot側ではオブジェクトに束ねて受け取れる**: Spring Bootの強力なデータバインディング機能により、個別のクエリパラメータであってもコントローラーの引数に `SearchUserCondition` のようなデータクラスを指定するだけで、自動的に1つのオブジェクトにマッピングされます。
- **なぜOpenAPIでクエリオブジェクトにしないのか？**: OpenAPIでクエリパラメータをオブジェクトとして定義（`deepObject` など）してしまうと、URLのクエリ文字列が特殊な形式（例: `?condition[keyword]=tanaka` または JSONエンコードされた文字列）になることが多く、シンプルなGETリクエストとして扱いにくくなります。個別に定義することで、シンプルで分かりやすいAPI仕様を保ちつつ、サーバー側の実装ではオブジェクトに束ねるという「いいとこ取り」が可能です。
