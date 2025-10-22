# Desafio Java - API REST - Gerenciador de Pedidos E-Commerce

Este projeto consiste em uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciar um fluxo básico de e-commerce, permitindo o cadastro de produtos, clientes e pedidos, além de gerar relatórios de vendas.

---

## Sumário

1. [Objetivo](#objetivo)
2. [Funcionalidades](#funcionalidades)
  - [Gestão de Produtos](#gestão-de-produtos-entity-produto)
  - [Gestão de Clientes](#gestão-de-clientes-entity-cliente)
  - [Gestão de Pedidos](#gestão-de-pedidos-entity-pedido)
  - [Relatórios](#relatórios)
3. [Estrutura de Pastas](#estrutura-de-pastas)
4. [Tecnologias Utilizadas](#tecnologias-utilizadas)
5. [Como Executar o Projeto](#como-executar-o-projeto)
6. [Endpoints Principais](#endpoints-principais)
7. [Testes](#testes)
8. [Melhorias Futuras](#melhorias-futuras)
9. [Autor](#autor)
10. [Licença](#licença)

---
## Objetivo

Criar uma aplicação backend organizada, modular e escalável, seguindo princípios de arquitetura em camadas e boas práticas de desenvolvimento Java, com foco em domínio, regras de negócio e persistência de dados.

---

## Funcionalidades

### Gestão de Produtos (`Entity Produto`)
- Criar, listar, atualizar e deletar produtos
- Cada produto contém:
    - `id`
    - `nome`
    - `descricao`
    - `preco`
    - `quantidadeEmEstoque`
- Regra de negócio:
    - Validar se há estoque disponível antes de processar pedidos

---

### Gestão de Clientes (`Entity Cliente`)
- Criar e listar clientes
- Cada cliente contém:
    - `id`
    - `nome`
    - `email`
    - `cpf`
    - `endereco`
- Observação:
    - Nenhuma regra de negócio específica definida para exclusão ou atualização.

---

### Gestão de Pedidos (`Entity Pedido`)
- Criar pedidos associando cliente e produtos
- Filtrar pedidos por:
    - Cliente
    - ID do pedido
    - Status (`PENDENTE`, `PROCESSANDO`, `CONCLUIDO`, `CANCELADO`)
- Atualizar status do pedido
- Regras de negócio:
    - Calcular valor total automaticamente ao criar pedido
    - Reduzir estoque de produtos ao confirmar pedido

---

### Relatórios
- Listar produtos mais vendidos
- Listar valor total de vendas por período

---


---

## Tecnologias Utilizadas

| Tecnologia | Descrição |
|-------------|------------|
| Java 17+ | Linguagem principal |
| Spring Boot | Framework para criação de APIs REST |
| Spring Data JPA | Persistência e abstração de banco de dados |
| H2 / MySQL | Banco de dados (configurável) |
| Lombok | Redução de código repetitivo (getters, setters, etc.) |
| JUnit 5 / Mockito | Testes unitários e de integração |

---


## Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven 3.8+
- IDE (IntelliJ, Eclipse ou VS Code)
- Banco de dados configurado (H2 padrão ou MySQL)

### Passos

#### 1. Clone o repositório:
```bash
git clone https://github.com/andersonsoethe/desafioEcommerceJava.git
```
2. Acesse a pasta do projeto:
```bash
cd desafioEcommerceJava
```
3. Execute a aplicação:
```bash
mvn spring-boot:run
```
4. Acesse a API:
```arduino
http://localhost:8080
```

---

## Autor

### Anderson Augusto Soethe
E-mail [gutosoethe@gmail.com]

GitHub https://github.com/andersonsoethe

---

## Licença

Este projeto é distribuído sob a licença MIT — sinta-se livre para usar e modificar.

