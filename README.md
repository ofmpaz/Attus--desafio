# Desafio Attus Defensoria

Este projeto é parte de um desafio proposto pela Attus Defensoria, com o objetivo de desenvolver um sistema para gerenciamento de pessoas e endereços utilizando tecnologias como Spring Boot, Java e Hibernate.

## Descrição

O sistema permite o cadastro, consulta e atualização de informações relacionadas a pessoas e seus endereços. Utiliza uma arquitetura MVC e uma abordagem de mapeamento objeto-relacional (ORM) com o Hibernate para persistência de dados.

## Funcionalidades

- **Cadastro de Pessoa**: Permite o cadastro de novas pessoas, incluindo nome, data de nascimento e endereços associados.

- **Consulta de Pessoas por Nome**: Permite buscar pessoas pelo nome.

- **Consultar todas as pessoas cadastradas**

- **Atualizar dados da pessoa:** Permite atualizar dados de uma pessoa cadastrada
  
- **Cadastro de Endereço**: Permite o cadastro de endereços associados a uma pessoa existente.

- **Consulta de Endereços por Logradouro**: Permite buscar endereços com base em um logradouro.

- **Atualização de Endereço**: Permite atualizar as informações de um endereço existente.

- **Cadastro de endereço associado a uma pessoa:** Permite associar o ID de uma pessoa a um endereço

- **Consultar todos os endereços:** - Permite consultar todos os endereços cadastrados

## Tecnologias Utilizadas

- Java
- Spring Boot
- RESTful APIs
- Lombok (para geração automática de getters/setters)
- Maven (para gerenciamento de dependências)
- Banco de Dados PostgreSQL

## Como passar as URLs no Postman para pessoa

| Método | URL                                      | Descrição                                      |
|--------|------------------------------------------|------------------------------------------------|
| POST   | `http://localhost:8080/pessoa`           | Cadastrar uma nova pessoa                      |
| GET    | `http://localhost:8080/pessoa/consultar/{nome}` | Consultar pessoas por nome                |
| PUT    | `http://localhost:8080/pessoa/atualizar?nome={nome}` | Atualizar dados de uma pessoa pelo nome |
| GET    | `http://localhost:8080/pessoa/todas`     | Buscar todas as pessoas cadastradas            |

## Exemplo de JSON para cadastrar uma nova pessoa (POST)
{
  "nome": "Maria Silva",
  "dataNascimento": "1990-05-15",
  "enderecos": [
    {
      "logradouro": "Rua das Flores",
      "cidade": "São Paulo",
      "estado": "SP",
      "cep": "01010-000",
      "numero": "123"
    }
  ]
}

## Exemplo de JSON para consultar pessoas por nome (GET)
{
  "nome": "Maria"
}

## Exemplo de JSON para atualizar dados de uma pessoa (PUT)
{
  "nome": "Maria Silva",
  "dataNascimento": "1990-05-15"
}

## Como passar as URLs no Postman para pessoa

| Método   | URL                            | Descrição                                        |
|----------|--------------------------------|--------------------------------------------------|
| `POST`   | `/endereco/cadastrar`           | Cadastrar um novo endereço                        |
| `POST`   | `/endereco/associar?pessoaId={pessoaId}` | Associar um endereço a uma pessoa existente    |
| `GET`    | `/endereco/buscarPorLogradouro?logradouro={logradouro}` | Buscar endereços por parte do logradouro |
| `GET`    | `/endereco/buscarTodos`         | Buscar todos os endereços cadastrados            |
| `PUT`    | `/endereco/atualizaEndereco?logradouro={logradouro}` | Atualizar dados de um endereço pelo logradouro |

## Exemplo de JSON para cadastrar um novo endereço (POST)
{
  "logradouro": "Av. Paulista, 123",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01310-200",
  "numero": "123"
}

## {
  "id": "78448878f8ef45d4f",
  "logradouro": "Rua das Flores, 456",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01020-300",
  "numero": "456"
}

## Como Executar

Para executar o projeto localmente, certifique-se de ter o Java e o Maven instalados em seu ambiente. Em seguida, siga estes passos:

1. Clone o repositório para o seu ambiente local:
2. Crie um banco de dados no Postgres
3. Start a aplicação
4. Teste no Postman
