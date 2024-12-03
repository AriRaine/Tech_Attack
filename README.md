# Tech_Attack
# Ferramenta de Análise de Eletrocardiogramas (ECG)

## Índice
1. [Descrição do Projeto](#descrição-do-projeto)
2. [Propósito da Aplicação](#propósito-da-aplicação)
3. [Status do Projeto](#status-do-projeto)
4. [Público-alvo](#público-alvo)
5. [Funcionalidades](#funcionalidades)
6. [Como Acessar o Projeto](#como-acessar-o-projeto)
7. [Como Executar o Projeto](#como-executar-o-projeto)
8. [Tecnologias Utilizadas](#tecnologias-utilizadas)
9. [Autores](#autores)

## 1. Descrição do Projeto
O projeto propõe uma ferramenta web projetada para automatizar o processamento e análise de imagens de eletrocardiogramas (ECG). O objetivo é facilitar a criação de laudos preliminares de exames cardiológicos, com a análise automática de ritmos cardíacos, intervalos PR e QT, além de anomalias como arritmias. A aplicação gera laudos preliminares, incluindo gráficos, medições e observações, que podem ser revisados, ajustados e assinados digitalmente pelos médicos. Além disso, a aplicação oferece diferentes perfis para pacientes, médicos e gestores, com funcionalidades específicas para cada um, e é integrada com sistemas de prontuário eletrônico (EMR).

## 2. Propósito da Aplicação
O principal propósito da aplicação é agilizar e otimizar a análise de ECGs, proporcionando rapidez e precisão na geração de laudos preliminares. A ferramenta automatiza a análise, permitindo que médicos se concentrem na revisão final e ajustes dos laudos, promovendo um atendimento mais eficiente e preciso. Ela também promove a interoperabilidade entre diferentes sistemas de saúde e facilita a integração com prontuários eletrônicos.

## 3. Status do Projeto
![Status](https://img.shields.io/badge/STATUS-em_desenvolvimento-blue)

## 4. Público-alvo
  *Funcionários*: Usuários que farão o upload das imagens de ECG para análise.
  *Médicos*: Profissionais de saúde que visualizarão os laudos e poderão validá-los.

## 5. Funcionalidades
  *Upload de Imagens de ECG*: Interface para upload de imagens em JPG, PNG e PDF.
  *Análise Automática de ECG*: Utilização de IA para identificar alterações no ECG e gerar um laudo preliminar.
  *Geração de Laudo Preliminar*: Laudo automaticamente gerado com base na análise do ECG.
  *Integração com EMR*: Integração com prontuários eletrônicos para o registro dos laudos.

## 6. Como Acessar o Projeto
  Você pode baixar o projeto em sua máquina em *<>Code* e depois em *Download ZIP*.

## 7. Como Executar o Projeto
  1º *Descompactação do Projeto:* Feito o download do projeto, descompacte o arquivo que está em formato ZIP.
  2º *Abrir o Projeto no NetBeans:* Utilize a IDE *NetBeans* para abrir e executar o projeto.
  3º *Configuração do Banco de Dados:* Inicie o SQLite e crie um *novo database*. 
                                       Copie o caminho do *seu* banco e cole por cima do caminho que está no *private static final* na classe *ConexaoSQLite.java*.
                                       Realize o run na classe *ConexaoSQLite.java* e *InicializarBanco.java*
                                       Depois, realize o run nas outras classes em sequência para criar as tabelas no banco.
  4º *Deploy no GlassFish:* Certifique-se de que o *GlassFish 7.0.0* está instalado e em execução.
  5º *Acesso*: Realize o run no projeto e acesse a aplicação em http://localhost:8080/Tech-Attack.

## 8. Tecnologias Utilizadas
  Frontend: HTML, CSS, JavaScript
  Backend: Java (utilizando GlassFish como servidor de aplicação)
  Integração com IA: API da OpenAI para análise do ECG
  Banco de Dados: SQLite para armazenar dados dos pacientes e laudos
  Hospedagem: GlassFish como servidor de aplicação

## 9. Autores
  - [Beatriz Silva Santos](https://github.com/BeatrizS97)
  - [Tatiana Nunes](https://github.com/tatcom23)
  - [Larissa Correia](https://github.com/AriRaine)
