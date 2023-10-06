# BCB – Big Chat Brasil

Este projeto representa um desafio de emprego para o Grupo Irrah e concentra-se em desenvolver um serviço backend especializado no envio de mensagens SMS, proporcionando uma solução eficaz e escalável para atender às necessidades de comunicação da empresa BCB - Big Chat Brasil (Ficticia). A API será o principal ponto de acesso, permitindo que os clientes integrem facilmente o serviço em suas aplicações e sistemas existentes.

## Desafio

Precisamos que seja possível via web ou mobile que os clientes enviem mensagens para seus usuários finais. Nesse sistema cada cliente precisa ser previamente cadastrado. Ao receber a solicitação de envio de mensagem deve ser verificado o tipo de plano de pagamento desse cliente. Caso for pre-pago, esse cliente deve possuir creditos para envio de SMS que custam R$0,25 cada. Caso o cliente seja pós pago, deve registrar o consumo na conta até o limite máximo autorizado.

## Backoffice

 * Incluir creditos para um cliente
 * Consultar saldo de um cliente
 * Alterar limite de um cliente
 * Alterar plano de um cliente
 * Ver dados de um cliente

## Requisitos
   - Java >= 17
   - PostgreSQL(opcional se não usar Docker)
   - Docker(opcional)
   

# Instalação e Execução

Clone o projeto e acesse o diretorio
   
   ```
   git clone https://github.com/lst15/spring-bcb-irrah.git
   cd spring-bcb-irrah
   ```

## Instruções para Instalação e Execução local (testado em windows)

1. Atualize as informações de acesso do POSTGRES local no diretorio *src/main/resources/application.properties*
   
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/<DATABASE>?schema=public
  spring.datasource.username=postgres
  spring.datasource.password=251410
  ```

2. Abra o terminal na pasta raiz do projeto e execute as migrations com o comando:
   
   ```
   gradlew flywayMigrate
   ```

3. Ainda na pasta raiz, inicialize a aplicação:
   
   ```
   gradlew runBcb
   ```


## Instruções para Instalação e Execução com Docker

1. Na pasta raiz do projeto, use:

   ```
   docker-compose up -d
   ```
