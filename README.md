# DeliveryTech

Projeto Spring Boot para calcular o valor de pedidos. Requer Java 17 ou superior e Maven instalado.

## Executar

Na pasta do projeto, rode:

```bash
mvn spring-boot:run
```

Depois, abra [http://localhost:8080](http://localhost:8080). A interface está em `src/main/resources/static/index.html`.

Para gerar um JAR executável:

```bash
mvn clean package
java -jar target/deliverytech-0.0.1-SNAPSHOT.jar
```

## API

- `GET /api/pedidos/health` — verifica se a API está ativa.
- `POST /api/pedidos/calcular` — recebe `{"quantidade": 2}` e calcula o pedido. A quantidade aceita vai de 1 a 20.

O preço unitário é R$ 25,00.
