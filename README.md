# Encurtador de URL / URL Shortener

> 🇧🇷 Português | [🇺🇸 English]

---

## 🇧🇷 Em português

### Tecnologias

- Java 21
- Spring Boot
- MongoDB
- Docker
- Spring Data MongoDB

---

### API

#### Encurtar uma URL

**POST** `/shorten-url`

##### 🔸 Requisição

```json
{
  "url": "https://www.exemplo.com"
}
```

##### 🔹 Resposta

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

#### Redirecionar pela URL curta

**GET** `/{id}`

Exemplo:

```http
GET http://localhost:8080/abc123
```

Resposta: redirecionamento (HTTP 302) para a URL original.

---

### ⚙️ Configuração

Arquivo: `src/main/resources/application.properties`

```properties
spring.application.name=reduzurl

spring.data.mongodb.authentication-database=admin
spring.data.mongodb.auto-index-creation=true
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=reduzurldb
spring.data.mongodb.username=admin
spring.data.mongodb.password=123
```

---

### ⏳ Observação

As URLs encurtadas expiram **1 minuto** após a criação (definido no controller).

---

Desenvolvido por [GabrielSiqueiraGama](https://github.com/GabrielSiqueiraGama) (zhant)

---
> 🇺🇸 English | [🇧🇷 Português]
## 🇺🇸 URL Shortener

### Technologies

- Java 21  
- Spring Boot  
- MongoDB  
- Docker  
- Spring Data MongoDB  

---

### API

#### Shorten a URL

**POST** `/shorten-url`

##### 🔸 Request

```json
{
  "url": "https://www.example.com"
}
```

##### 🔹 Response

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

#### Redirect via short URL

**GET** `/{id}`

Example:

```http
GET http://localhost:8080/abc123
```

Response: HTTP 302 redirect to the original URL.

---

### ⚙️ Configuration

File: `src/main/resources/application.properties`

```properties
spring.application.name=reduzurl

spring.data.mongodb.authentication-database=admin
spring.data.mongodb.auto-index-creation=true
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=reduzurldb
spring.data.mongodb.username=admin
spring.data.mongodb.password=123
```

---

### ⏳ Note

Shortened URLs expire **1 minute** after creation (as defined in the controller).

---

Developed by [GabrielSiqueiraGama](https://github.com/GabrielSiqueiraGama) (zhant)

