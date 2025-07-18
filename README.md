# 📚 LiterAlura

Projeto desenvolvido como parte do **Desafio Java com Spring Boot** da Alura, com o objetivo de consumir a API do Projeto Gutenberg e persistir dados de livros e autores em um banco de dados PostgreSQL.

---

## 🚀 Funcionalidades Implementadas

- ✅ Buscar e registrar livros por título, consumindo a [API Gutendex](https://gutendex.com/)
- ✅ Persistir informações dos livros e autores no banco de dados PostgreSQL
- ✅ Exibir menu interativo no console com as opções:
  - 🔍 Buscar livro por título
  - 📖 Listar livros registrados
  - 🧑‍💼 Listar autores registrados
  - ❌ Encerrar o programa
- ✅ Relacionamento entre `Livro` e `Autor` (muitos para muitos simplificado)
- ✅ API REST externa tratada com Jackson para conversão de JSON

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.x
- Spring Data JPA
- PostgreSQL
- Hibernate
- Jackson (para desserialização de JSON)
- Maven (gerenciador de dependências)
- IntelliJ IDEA

---

## 🧩 Estrutura do Projeto

```bash
src/main/java/com/alura/literalura/
│
├── controller/           # Classe com o menu principal exibido no console
├── model/                # Entidades JPA: Livro e Autor
├── repository/           # Interfaces que estendem JpaRepository
├── service/              # Lógica de negócio: consumo da API e persistência
└── LiteraluraApplication.java # Classe principal do Spring Boot
````

---

## 🧪 Como Executar o Projeto

1. Certifique-se de ter o PostgreSQL rodando com um banco de dados chamado `db_literalura`.
2. Configure as credenciais no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/db_literalura
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Compile e execute o projeto via terminal ou IntelliJ.

---

## 💡 Possíveis Melhorias

* [ ] Criar uma interface web com Spring MVC ou Thymeleaf
* [ ] Adicionar paginação e filtros na listagem de livros/autores
* [ ] Implementar testes unitários com JUnit e Mockito
* [ ] Cachear resultados da API externa
* [ ] Tratar múltiplos autores e traduções dos livros
* [ ] Suporte a internacionalização (i18n)

---

## 👨‍🎓 Projeto educacional

Este projeto foi desenvolvido com fins de aprendizado, integrando conhecimentos de API REST, JPA, Spring Boot e persistência de dados com PostgreSQL.

```
