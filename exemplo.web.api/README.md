# Web API de Produtos Eletrodomésticos

## Descrição

Esta é uma API Web simples desenvolvida em Java utilizando Spring Boot. A API permite a consulta de produtos eletrodomésticos, cadastro de usuários e consulta de filiais de lojas.

## Endpoints

### Produtos

- **GET /api/produtos**
  - Retorna a lista de produtos eletrodomésticos.

### Usuários

- **GET /api/usuarios**
  - Retorna a lista de usuários cadastrados.

- **POST /api/usuarios**
  - Adiciona um novo usuário.
  - Corpo da requisição (JSON):
    ```json
    {
        "id": 1,
        "nome": "João Silva",
        "email": "joao.silva@example.com",
        "senha": "senha123"
    }
    ```

### Filiais

- **GET /api/filiais**
  - Retorna a lista de filiais de lojas.

## Executando a Aplicação

1. Navegue até o diretório do projeto pelo terminal.
2. Execute o comando:
   ```bash
   mvn spring-boot:run
