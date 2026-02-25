
 ## Bora Bordar — Sistema de Gestão de Pedidos

#  backend desenvolvido em Java para gerenciamento de clientes e pedidos de uma empresa de bordados.

O projeto foi construído com foco em:

Programação Orientada a Objetos

Separação de responsabilidades

Regras de negócio

Arquitetura em camadas

Evolução futura para Spring Boot e banco de dados

# Objetivo do Projeto

Simular um sistema real de gestão de pedidos contendo:

Cadastro de clientes

Criação de pedidos

Controle de status

Cancelamento com regras

Relatórios consolidados por cliente

O foco principal foi aplicar boas práticas de backend.

# Arquitetura do Projeto

O sistema foi organizado em camadas:

model
repository
services
dto
# Model

Contém as entidades do domínio:

Cliente

Pedido

StatusPedido (enum)

Responsável por representar o negócio.

# Service

Camada responsável por:

Validação de regras

Controle de fluxo

Aplicação de regras de negócio

Comunicação com Repository

Exemplo de regras implementadas:

CPF não pode ser duplicado

CPF deve conter 11 dígitos numéricos

Nome não pode ser vazio

Valor do pedido deve ser maior que zero

Pedido só pode ser cancelado se estiver PENDENTE

# Repository

Responsável pelo armazenamento dos dados.

Atualmente utiliza armazenamento em memória (ArrayList), mas foi estruturado para futura substituição por banco de dados sem alterar a camada de Service.

# DTO

Criado RelatorioCliente para transportar dados de relatório sem acoplar lógica ao menu.

# Funcionalidades Implementadas
# Cliente

Cadastro

Listagem

Busca por CPF

Validação de CPF duplicado

Validação estrutural de CPF

Validação de nome vazio

# Pedido

Criação

Listagem

Atualização de status

Cancelamento com regra de negócio

Listagem por cliente

Relatório consolidado por cliente

# Exemplo de Relatório
===== RELATÓRIO DO CLIENTE =====
Total de pedidos: 4
Pedidos pendentes: 1
Pedidos finalizados: 2
Pedidos cancelados: 1
Valor total gasto: R$ 850.00
🛠 Tecnologias Utilizadas

Java 21

Programação Orientada a Objetos

Collections (List, ArrayList)

Stream API

Enum

Separação em camadas

# Próximas Evoluções (Roadmap)

Integração com banco de dados (JPA / Hibernate)

Transformação em API REST com Spring Boot

Implementação de Injeção de Dependência

Testes unitários com JUnit

Tratamento de exceções personalizadas

# Conceitos Aplicados

Encapsulamento

Separação de responsabilidades

Baixo acoplamento

Regras de negócio centralizadas

DTO (Data Transfer Object)

Controle de estados com Enum

# Autor

Desenvolvido por Luciano Arruda
Projeto criado como parte da transição de carreira para desenvolvimento backend Java.
