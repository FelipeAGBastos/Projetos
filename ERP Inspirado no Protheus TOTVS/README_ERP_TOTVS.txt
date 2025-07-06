
🧠 Mini ERP Modular com Java, MySQL e Power BI — Inspirado no TOTVS Protheus

📌 Desenvolvido por: Felipe Alves Gomes Bastos

🔍 Descrição

Este projeto é um sistema ERP modular completo, inspirado na arquitetura do TOTVS Protheus, composto por três módulos principais:

- Cadastro de Usuários (SIGACFG)
- Gestão de Produtos e Estoque (SIGAEST)
- Gestão de Pedidos de Venda (SIGAFAT)

Todos os dados são armazenados em um banco de dados relacional MySQL, com integração ao Power BI para geração de dashboards empresariais.

🚀 Funcionalidades

🧩 Módulo Usuários (SIGACFG)
- Cadastro de clientes com nome, CPF e telefone
- Remoção de clientes por ID

📦 Módulo Produtos / Estoque (SIGAEST)
- Cadastro de produtos (tipo, unidade, preço, data)
- Remoção de produtos por ID

🧾 Módulo Pedidos de Venda (SIGAFAT)
- Cadastro de pedidos vinculando clientes e valores
- Status dos pedidos (aberto, fechado, cancelado)
- Remoção de pedidos por ID

📊 Integração Power BI
- Dashboard interativo com:
  - Total de pedidos por cliente
  - Volume de vendas
  - Estoque atual
  - Ticket médio por pedido
  - Indicadores visuais com filtros dinâmicos

🛠️ Tecnologias Utilizadas

Tecnologia | Função
-----------|--------
Java       | Lógica da aplicação e estrutura modular
JDBC       | Conector entre Java e banco de dados
MySQL      | Armazenamento dos dados e relações
SQL        | Modelagem e manipulação das tabelas
Power BI   | Visualização e análise de dados empresariais
Scanner    | Interface por terminal (menu interativo)

🧱 Estrutura do Projeto

📁 src/
 ┣ 📁 DAO/
 ┃ ┣ UsuarioDAO.java
 ┃ ┣ ProdutoDAO.java
 ┃ ┗ PedidoDAO.java
 ┣ 📁 entity/
 ┃ ┣ Usuario.java
 ┃ ┣ Produto.java
 ┃ ┗ Pedido.java
 ┣ 📁 conexao/
 ┃ ┗ Conexao.java
 ┣ App.java

🔗 Banco de Dados

- Banco unificado (ex: sistema_erp)
- Tabelas relacionadas por chaves estrangeiras (FK)
- Scripts de criação inclusos:
  - USUARIO_CAD
  - ESTOQUEL
  - PEDIDOS

🧠 Aprendizados

- Arquitetura modular inspirada em sistemas reais (Protheus TOTVS)
- Programação orientada a objetos com DAO e Entidades
- Conexão Java ↔ MySQL via JDBC
- Modelagem de banco de dados com relacionamentos
- Visualização e análise de dados com Power BI
- Estrutura de menus e lógica interativa via terminal

🎯 Objetivo

Este projeto foi desenvolvido com o intuito de consolidar conhecimentos em programação Java, bancos de dados relacionais e ferramentas de BI, além de simular um sistema ERP real, como os utilizados por empresas de grande porte — especialmente alinhado à TOTVS, referência nacional em sistemas de gestão empresarial.

📌 Autor

Felipe Alves Gomes Bastos
Estudante de Sistemas de Informação na FIAP
Apaixonado por dados, software e soluções inteligentes

🗂️ Status do Projeto

✅ Finalizado – versão funcional com 3 módulos
📈 Pronto para demonstrar em entrevistas
🔜 Pode evoluir com autenticação, front-end ou relatórios em PDF
