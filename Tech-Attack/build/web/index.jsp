<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ferramenta de An�lise de ECG</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
        <%@include file="WEB-INF/jspf/_navbar.jspf" %>
        <style>
            body {
                font-family: serif;
                margin: 0;
                padding: 0;
                background: #f4f4f9;
            }

            header {
                background: linear-gradient(135deg, #000080, #004a99);
                color: white;
                padding: 30px 15%;
                text-align: center;
                border-bottom: 5px solid #333;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                border-radius: 0 0 20px 20px;
                animation: moveBackground 5s infinite linear;
            }

            @keyframes moveBackground {
                0% {
                    background-position: 0% 50%;
                }
                100% {
                    background-position: 100% 50%;
                }
            }

            header h1 {
                font-size: 36px;
                margin: 0;
                letter-spacing: 2px;
                text-transform: uppercase;
                font-weight: bold;
                text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
                color: #ffffff;
                animation: growShrink 5s infinite ease-out; 
            }

            @keyframes growShrink {
                0% {
                    transform: scale(1); /* Tamanho original */
                }
                50% {
                    transform: scale(1.2); /* Aumenta o tamanho */
                }
                100% {
                    transform: scale(1); /* Retorna ao tamanho original */
                }
            }

            header p {
                font-size: 22px;
                margin-top: 10px;
                font-weight: 400;
                text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);
                text-align: center;
            }

            main {
                padding: 25px 15%;
                line-height: 1.8;
                color: #333;
            }

            h2 {
                color: #004a99;
                margin-bottom: 20px;
                font-size: 28px;
            }

            p {
                font-size: 18px;
                text-align: justify;
            }

            ul {
                list-style-type: none;
                padding: 0;
            }

            ul li {
                background: #004a99;
                color: white;
                margin: 10px 0;
                padding: 10px;
                border-radius: 5px;
                font-size: 16px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease;
            }

            ul li:hover {
                transform: scale(1.05);
                background-color: #0066cc;
            }

            footer {
                background-color: #004a99;
                color: white;
                padding: 10px 0;
                text-align: center;
                position: relative;
                bottom: 0;
                width: 100%;
                border-top: 3px solid #333;
            }

            .cta-button {
                display: inline-block;
                background-color: #004a99;
                color: white;
                padding: 12px 20px;
                text-decoration: none;
                font-size: 18px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                margin-top: 30px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            }

            .cta-button:hover {
                background-color: #0066cc;
            }

            @media (max-width: 768px) {
                main {
                    padding: 20px;
                }

                header h1 {
                    font-size: 28px;
                }

                h2 {
                    font-size: 24px;
                }

                p, ul li {
                    font-size: 16px;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Ferramenta de An�lise de ECG</h1>
            <p>Agilidade e precis�o na an�lise de eletrocardiogramas</p>
        </header>
        <main>
            <section>
                <h2>Bem-vindo(a) � nossa Ferramenta</h2>
                <p>
                    Nossa plataforma foi projetada para automatizar o processamento e a an�lise de eletrocardiogramas (ECG), facilitando a gera��o de laudos preliminares com alta precis�o.
                    Com o objetivo de aprimorar a efici�ncia dos profissionais de sa�de, oferecemos funcionalidades como:
                </p>
                <ul>
                    <li>Upload de imagens de ECG nos formatos JPG, PNG e PDF</li>
                    <li>An�lise autom�tica com identifica��o de ritmos card�acos e anomalias</li>
                    <li>Gera��o de laudos preliminares completos</li>
                    <li>Perfis espec�ficos para pacientes, m�dicos e gestores de sa�de</li>
                    <li>Integra��o com sistemas de prontu�rio eletr�nico</li>
                </ul>
            </section>
            <section>
                <h2>Objetivo do Projeto</h2>
                <p>
                    Nosso objetivo principal � otimizar o processo de an�lise de ECGs, reduzindo o tempo de resposta e aumentando a precis�o dos laudos m�dicos. 
                    Al�m disso, promovemos a interoperabilidade no setor de sa�de ao integrar nossa ferramenta com outros sistemas.
                </p>
            </section>
            <section>
                <h2>Destaques</h2>
                <p>
                    A aplica��o � acess�vel via navegador, sem necessidade de instala��o, e foi desenvolvida com as melhores pr�ticas de acessibilidade para atender a todos os usu�rios, incluindo aqueles com defici�ncias.
                </p>
            </section>
            <a href="upload.jsp" class="cta-button">Experimente Agora</a>
        </main>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>
