# Projeto de Academia - Sistema de Gestão

## Descrição
Este projeto é um sistema de gerenciamento de academia implementado em Java. Ele permite o gerenciamento de clientes, funcionários, aulas e agendamentos, além de incluir funcionalidades para venda de pacotes e controle de estoque. O projeto utiliza uma abordagem modular, incluindo diferentes camadas, como Modelos, DAOs, Serviços, Controladores e Views, para garantir um design limpo e de fácil manutenção. O objetivo é oferecer uma experiência de gerenciamento centralizada e eficaz para academias.

## Estrutura do Projeto
O projeto é composto pelos seguintes módulos principais:

- **Cliente**: Responsável pela gestão de clientes, incluindo CRUD (Create, Read, Update, Delete) de informações dos clientes.
- **Funcionário**: Permite o gerenciamento de funcionários da academia.
- **Aula**: Gestão de aulas, incluindo a capacidade de agendar, cancelar e alocar salas para diferentes tipos de aulas.
- **Sala**: Gestão de salas disponíveis para aulas, verificando capacidade e disponibilidade.
- **Estoque**: Controle de estoque de produtos utilizados na academia.
- **Venda**: Permite realizar e registrar vendas de pacotes de aulas ou produtos.

Cada módulo tem classes dedicadas para Model, DAO (Data Access Object), Controller, Service e View.

## Funcionalidades Implementadas

### Questão 15: Uso de Iterator e Foreach
Foi implementado um método que faz a iteração sobre uma lista de clientes usando um `Iterator` e, em seguida, utilizando um `foreach`. Isso permite observar as duas maneiras disponíveis em Java para percorrer coleções.

- **Iterator**: Usa os métodos `hasNext()` e `next()` para percorrer manualmente cada elemento da lista.
- **Foreach**: Simplifica o processo de iteração e é uma abstração do uso do `Iterator`.

### Questão 16: Teste de Comparator e Ordenação com Collections.sort()
Implementamos dois `Comparators` diferentes para ordenar uma lista de clientes: um por nome e outro por CPF. Utilizamos a classe `Collections` para ordenar a lista de clientes com base nesses comparadores. Esta abordagem é útil para facilitar a ordenação e classificação de listas conforme diferentes critérios.

### Questão 17: Busca com Comparator e BinarySearch
Foi criado um método `findCliente` que utiliza um `Iterator` e um `Comparator` para buscar um cliente em uma lista. Além disso, foi feita uma comparação entre esse método e o método `Collections.binarySearch()`, que é uma busca binária mais eficiente. Ambas as abordagens foram utilizadas para demonstrar diferentes estratégias de busca.

## Estrutura do Código Principal

### Main.java
O arquivo `Main.java` contém a função principal do projeto e demonstra a execução das questões 15, 16 e 17. Veja como as funcionalidades foram organizadas:

- **questao15(List<Cliente> clientes)**: Demonstra o uso do `Iterator` e do `foreach` para percorrer uma lista de clientes.
- **questao16(List<Cliente> clientes)**: Testa o uso do `Comparator` para ordenar a lista de clientes por diferentes atributos.
- **questao17(List<Cliente> clientes)**: Demonstra a implementação de uma busca com `Iterator` e `Comparator`, e compara o resultado com uma busca binária usando `Collections.binarySearch()`.

### Exemplos de Código na Main
- Iteração sobre a lista de clientes usando `Iterator` e `foreach`.
- Ordenação dos clientes usando `Comparator` com os métodos `Collections.sort()`.
- Implementação de um método `find` que usa `Iterator` e `Comparator`, comparando com `Collections.binarySearch()`.

## Pré-Requisitos
- **Java 11** ou superior.
- **Bibliotecas Externas**: O projeto utiliza a biblioteca Gson para serialização e desserialização de JSON. Certifique-se de que a biblioteca está configurada corretamente no ambiente.
- **Banco de Dados**: As funcionalidades do DAO possuem implementações para MySQL e armazenamento em JSON. Para utilizar o MySQL, é necessário ter o banco configurado e rodando.

## Como Executar o Projeto
1. **Clone o Repositório**: Clone o projeto para o seu ambiente de desenvolvimento local.
   ```sh
   git clone https://github.com/kaiquepy/academia.git
   ```

2. **Configurar Banco de Dados**: Se estiver usando o MySQL, configure o banco de dados com as tabelas necessárias. Exemplos de scripts SQL podem ser encontrados no diretório `sql` do projeto.

3. **Compilar e Executar**: Compile o projeto usando sua IDE favorita ou via terminal:
   ```sh
   javac -d bin src/**/*.java
   java -cp bin com.academia.Main
   ```

4. **Testar as Funcionalidades**: Execute as funções de CRUD, ordenação e busca diretamente na classe `Main` para observar as saídas de cada funcionalidade.

## Estrutura de Pastas
```
projeto-academia/
 ├── src/
 │   ├── com/academia/
 │   │    ├── cliente/
 │   │    ├── funcionario/
 │   │    ├── aula/
 │   │    ├── sala/
 │   │    ├── estoque/
 │   │    ├── venda/
 │   │    └── Main.java
 └── README.md
```

## Melhorias Futuras
- **Integração com Frontend**: Criar uma interface gráfica para melhorar a interação dos usuários com o sistema. Pode-se utilizar JavaFX para criar uma interface rica.
- **Relatórios**: Implementar funcionalidades para geração de relatórios das vendas e agendamentos, com opção de exportar para PDF.
- **Autenticação**: Adicionar uma camada de autenticação para garantir que apenas usuários autorizados possam acessar certos módulos do sistema.
- **Testes Unitários**: Implementar testes unitários para garantir a qualidade do código e evitar regressões.

## Licença
Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

