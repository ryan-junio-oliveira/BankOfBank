# Sistema Bancário Java

Este projeto Java implementa um sistema bancário simples com funcionalidades básicas de gerenciamento de contas e operações bancárias.

## Funcionalidades

- Criar contas bancárias com número da conta e saldo inicial
- Realizar depósitos e saques em contas existentes
- Deletar contas bancárias
- Listar todas as contas cadastradas no banco

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

BankOfBank/
├── src/
│   └── com/
│       └── bankofbank/
│           ├── Account.java
│           ├── Bank.java
│           └── Main.java
└── README.md

- `Account.java`: Contém a classe `Account` que representa uma conta bancária.
- `Bank.java`: Contém a classe `Bank` que representa um banco e gerencia as contas.
- `Main.java`: Contém a classe `Main` que é a classe principal do projeto e implementa a interface gráfica.

## Pré-requisitos

- Java Development Kit (JDK) instalado
- IDE Java (como IntelliJ IDEA, Eclipse ou NetBeans) ou editor de texto

## Como Executar

1. Clone o repositório:

   git clone https://github.com/ryan-junio-oliveira/BankOfBank.git

2. Abra o projeto em sua IDE Java ou editor de texto.

4. Compile os arquivos Java:

   javac -d . src/com/bankofbank/*.java

4. Execute a classe `Main`:

   java -cp . com.bankofbank.Main

Isso iniciará a interface gráfica do sistema bancário.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

1. Faça um fork do projeto
2. Crie uma nova branch (`git checkout -b feature/sua-feature`)
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/sua-feature`)
5. Abra um pull request

## Autor

Este projeto foi desenvolvido por [Ryan Oliveira] e está em estágio de desenvolvimento.
