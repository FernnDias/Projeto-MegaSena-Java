# 🎰 Gerenciador Estatístico Mega-Sena (Projeto Simples)

Este é um **projeto simples** desenvolvido em **Java Desktop (Swing)** com o objetivo de praticar os conceitos fundamentais de programação e integração com banco de dados. O sistema permite realizar o gerenciamento básico de sorteios da Mega-Sena e visualizar estatísticas simples de frequência.

## 🚀 Funcionalidades

### **Gerenciamento Completo (CRUD)**
* **Cadastrar:** Inserção de novos concursos com as 6 dezenas sorteadas.
* **Listar:** Visualização de todo o histórico de sorteios em uma tabela organizada.
* **Atualizar:** Permite a edição e correção de dados de concursos já existentes.
* **Excluir:** Remoção de registros do banco de dados através do número do concurso.

### **Análise Básica**
* **Ranking de Dezenas:** Um algoritmo simples que calcula e exibe quais números foram mais sorteados na base de dados.
* **Feedback Visual:** Uso de labels para informar o status das operações ao usuário.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java.
* **Banco de Dados:** MySQL  (via XAMPP).
* **Conectividade:** JDBC (Java Database Connectivity).

---

## 📋 Instalação e Configuração

### 1. Preparação do Banco de Dados
O projeto utiliza o banco de dados `bancoprojetomegasena`.
1. Abra o seu **phpMyAdmin**.
2. Crie um novo banco de dados chamado `bancoprojetomegasena`.
3. Vá na aba **Importar** e selecione o arquivo `bancoprojetomegasena.sql` disponível na raiz deste repositório.

### 2. Conexão com o Java
A conexão no código (`Sorteio.java`) está configurada para o padrão do XAMPP:
* **URL:** `jdbc:mysql://localhost:3306/bancoprojetomegasena`
* **Usuário:** `root`
* **Senha:** (vazio)

---

## 📂 Estrutura de Arquivos

* `src/`: Contém o código-fonte Java.
* `bancoprojetomegasena.sql`: Script para restaurar as tabelas e dados de exemplo.
