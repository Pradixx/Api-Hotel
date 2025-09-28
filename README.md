# Api-Hotel

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![JPA](https://img.shields.io/badge/JPA-000000?style=for-the-badge&logo=hibernate&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-000000?style=for-the-badge&logo=h2&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## Descrição do Projeto

A **Api-Hotel** é uma aplicação backend desenvolvida em Java com Spring Boot, projetada para gerenciar reservas de hotel. Este projeto foca na implementação prática de conceitos de persistência de dados utilizando JPA (Java Persistence API) e Hibernate, com um banco de dados H2 em memória para desenvolvimento e testes. A API permite o gerenciamento de hóspedes, quartos e suas respectivas reservas, demonstrando a modelagem de relacionamentos complexos entre entidades.

## Tecnologias Utilizadas

*   **Java 25**: Linguagem de programação principal.
*   **Spring Boot 3.5.6**: Framework para construção de aplicações Java robustas e escaláveis.
*   **Spring Data JPA**: Abstração para simplificar a implementação de repositórios baseados em JPA.
*   **Hibernate**: Implementação de JPA para mapeamento objeto-relacional (ORM).
*   **H2 Database**: Banco de dados em memória, ideal para desenvolvimento e testes.
*   **Lombok**: Biblioteca para reduzir código boilerplate.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.

## Funcionalidades Principais

*   **Gerenciamento de Hóspedes**: Cadastro, consulta, atualização e exclusão de informações de hóspedes.
*   **Gerenciamento de Quartos**: Cadastro, consulta, atualização e exclusão de informações de quartos, incluindo valor da diária, capacidade e disponibilidade.
*   **Gerenciamento de Reservas**: Criação, consulta, atualização e exclusão de reservas, associando hóspedes e quartos.
*   **Relacionamentos JPA**: Demonstração de relacionamentos `@ManyToOne` e `@OneToOne` entre as entidades `Reserva`, `Hospede` e `Quarto`.

## Estrutura do Projeto

O projeto segue uma estrutura de pacotes organizada, típica de aplicações Spring Boot:

```
Api-Hotel/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── deigo/
│   │   │           └── hotel/
│   │   │               ├── HotelApplication.java
│   │   │               ├── controller/
│   │   │               ├── infrastructure/
│   │   │               │   ├── entitys/
│   │   │               │   │   ├── Hospede.java
│   │   │               │   │   ├── Quarto.java
│   │   │               │   │   └── Reserva.java
│   │   │               │   └── repository/
│   │   │               └── service/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

*   `controller/`: Contém os endpoints REST da API.
*   `infrastructure/entitys/`: Define as entidades de domínio (`Hospede`, `Quarto`, `Reserva`) e seus relacionamentos JPA.
*   `infrastructure/repository/`: Interfaces de repositório para acesso a dados, utilizando Spring Data JPA.
*   `service/`: Camada de lógica de negócios.
*   `HotelApplication.java`: Classe principal da aplicação Spring Boot.

## Relacionamentos JPA em Destaque

O projeto exemplifica a modelagem de relacionamentos entre entidades, que são cruciais para a integridade e funcionalidade de um sistema de reservas. Abaixo, detalhamos os principais relacionamentos:

### `Reserva` com `Quarto` e `Hospede`

A entidade `Reserva` possui relacionamentos `@ManyToOne` com `Quarto` e `Hospede`. Isso significa que:

*   Um `Quarto` pode ter muitas `Reservas` (mas uma `Reserva` pertence a apenas um `Quarto`).
*   Um `Hospede` pode ter muitas `Reservas` (mas uma `Reserva` pertence a apenas um `Hospede`).

Exemplo de `Reserva.java`:

```java
@ManyToOne
@JoinColumn(name = "quarto_Id")
private Quarto quartoId;

@ManyToOne
@JoinColumn(name = "hospede_Id")
private Hospede hospedeId;
```

### `Hospede` com `Reserva` (Bidirecional)

A entidade `Hospede` possui um relacionamento `@OneToOne` com `Reserva` (embora no código `Hospede` tenha `mappedBy = 

"hospedeId"` que indica um relacionamento `OneToOne` com `Reserva`, a modelagem mais comum para este cenário seria `OneToMany` ou `ManyToMany` para um hóspede ter múltiplas reservas. Para este projeto, consideraremos a intenção de um hóspede ter uma reserva principal ou um relacionamento mais complexo que será aprimorado em futuras iterações. A anotação `mappedBy` indica que a entidade `Reserva` é a proprietária do relacionamento.

Exemplo de `Hospede.java`:

```java
@OneToOne(mappedBy = "hospedeId")
private Integer id_hospede;
```

### `Quarto` com `Reserva` (Bidirecional)

A entidade `Quarto` possui um relacionamento `@OneToMany` com `Reserva`. Isso significa que um `Quarto` pode ter muitas `Reservas`.

Exemplo de `Quarto.java`:

```java
@OneToMany(mappedBy = "quartoId")
private Integer id_Quarto;
```

## Como Executar o Projeto

Para executar a Api-Hotel localmente, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

*   Java Development Kit (JDK) 25 ou superior
*   Maven 3.6.x ou superior
*   Git

### Passos para Execução

1.  **Clone o Repositório:**

    ```bash
    git clone https://github.com/Pradixx/Api-Hotel.git
    cd Api-Hotel
    ```

2.  **Compile o Projeto:**

    ```bash
    mvn clean install
    ```

3.  **Execute a Aplicação:**

    ```bash
    mvn spring-boot:run
    ```

    A aplicação será iniciada e estará disponível em `http://localhost:8080`.

## Endpoints da API

A API expõe os seguintes endpoints para gerenciamento de hóspedes, quartos e reservas:

### Endpoints de Hóspedes (`/hospede`)

*   `POST /hospede`: Salva um novo hóspede.
*   `GET /hospede?id={id}`: Busca um hóspede pelo ID.
*   `DELETE /hospede?id={id}`: Deleta um hóspede pelo ID.
*   `PUT /hospede?id={id}`: Atualiza um hóspede pelo ID.

### Endpoints de Quartos (`/quarto`)

*   `POST /quarto`: Salva um novo quarto.
*   `GET /quarto?id={id}`: Busca um quarto pelo ID.
*   `DELETE /quarto?id={id}`: Deleta um quarto pelo ID.
*   `PUT /quarto?id={id}`: Atualiza um quarto pelo ID.

### Endpoints de Reservas (`/reserva`)

*   `POST /reserva`: Salva uma nova reserva.
*   `GET /reserva?id={id}`: Busca uma reserva pelo ID.
*   `DELETE /reserva?id={id}`: Deleta uma reserva pelo ID.
*   `PUT /reserva?id={id}`: Atualiza uma reserva pelo ID.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou sugerir melhorias.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## Próximos Passos

*   Implementação de testes unitários e de integração.
*   Refatoração para uma arquitetura limpa e modular.
*   Documentação da API com Swagger/OpenAPI.
*   Implementação de autenticação e autorização.

