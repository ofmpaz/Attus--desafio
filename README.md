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


# Utilizando Endpoints no Postman

## Para utilizar os endpoints definidos na coleção EnderecoController no Postman

| Endpoint                           | Método | URL                                                   | Descrição                                                                                          |
|------------------------------------|--------|-------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| Buscar Todos os Endereços          | GET    | `http://localhost:8080/endereco/buscaTodosEnderecos` | Retorna todos os endereços cadastrados no sistema.                                                  |
| Buscar Endereço por ID              | GET    | `http://localhost:8080/endereco/buscaEnderecoPorId/{id}` | Retorna um endereço específico com base no ID fornecido. Substitua `{id}` pelo ID desejado.     |
| Adicionar Novo Endereço             | POST   | `http://localhost:8080/endereco/addEndereco`          | Cria um novo registro de endereço.                                                                |
| Atualizar Endereço Existente        | PUT    | `http://localhost:8080/endereco/atualizaEndereco/{id}` | Atualiza os detalhes de um endereço existente com base no ID fornecido. Substitua `{id}` pelo ID desejado. |

## Para utilizar os endpoints definidos em PessoaController no Postman

| Endpoint                           | Método | URL                                          | Descrição                                                                                   |
|------------------------------------|--------|----------------------------------------------|---------------------------------------------------------------------------------------------|
| Buscar Todas as Pessoas             | GET    | `http://localhost:8080/pessoa/buscaTodasPessoas` | Retorna todas as pessoas cadastradas no sistema.                                            |
| Buscar Pessoa por ID                | GET    | `http://localhost:8080/pessoa/buscaPessoaPorId/{id}` | Retorna uma pessoa específica com base no ID fornecido. Substitua `{id}` pelo ID desejado. |
| Adicionar Nova Pessoa               | POST   | `http://localhost:8080/pessoa/addPessoa`     | Adiciona uma nova pessoa ao sistema.                                                        |
| Atualizar Pessoa Existente          | PUT    | `http://localhost:8080/pessoa/atualizarPessoa/{id}` | Atualiza os dados de uma pessoa existente com base no ID fornecido. Substitua `{id}` pelo ID desejado. |

## Para utilizar os endpoints definidos em AssocicaoController no Postman

| Método | Endpoint                                              | Descrição                                                    |
|--------|-------------------------------------------------------|--------------------------------------------------------------|
| POST   | `/associar/{pessoaId}/associarEndereco`              | Associa um novo endereço a uma pessoa existente.             |
| PUT    | `/associar/{pessoaId}/marcarEnderecoPrincipal/{enderecoId}` | Define o endereço especificado como principal para a pessoa. |


## Como Executar

Para executar o projeto localmente, certifique-se de ter o Java e o Maven instalados em seu ambiente. Em seguida, siga estes passos:

1. Clone o repositório para o seu ambiente local:
2. Crie um banco de dados no Postgres
3. Start a aplicação
4. Teste no Postman
