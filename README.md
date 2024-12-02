# Tech_Attack
# Ferramenta de Análise de Eletrocardiogramas (ECG)

## Índice
1. [Descrição do Projeto](#descrição-do-projeto)
2. [Propósito da Aplicação](#propósito-da-aplicação)
3. [Status do Projeto](#status-do-projeto)
4. [Público-alvo](#público-alvo)
5. [Funcionalidades](#funcionalidades)
6. [Tecnologias Utilizadas](#tecnologias-utilizadas)
7. [Autores](#autores)

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

## 6. Tecnologias Utilizadas
  Frontend: HTML, CSS, JavaScript
  Backend: Java (utilizando GlassFish como servidor de aplicação)
  Integração com IA: API da OpenAI para análise do ECG
  Banco de Dados: SQLite para armazenar dados dos pacientes e laudos
  Hospedagem: GlassFish como servidor de aplicação

## 7. Autores
  - [Beatriz Silva Santos](https://github.com/BeatrizS97)
  - [Tatiana Nunes](https://github.com/tatcom23)
  - [Larissa Correia](https://github.com/AriRaine)
