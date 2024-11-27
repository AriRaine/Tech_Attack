<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ferramenta de Análise de ECG</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %> <!-- Inclusão de bibliotecas de cabeçalho -->
        <%@include file="WEB-INF/jspf/_navbar.jspf" %> <!-- Inclusão da barra de navegação -->
        <style>
            body {
                font-family: 'Open Sans', Arial, sans-serif !important;
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
                    transform: scale(1);
                }
                50% {
                    transform: scale(1.2);
                }
                100% {
                    transform: scale(1);
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
            <h1 style="color:white">Ferramenta de Análise de ECG</h1>
            <p>Agilidade e precisão na análise de eletrocardiogramas</p>
        </header>
        <main>
            <section>
                <h2>Bem-vindo(a) à nossa Ferramenta</h2>
                <p>
                    Nossa plataforma foi projetada para automatizar o processamento e a análise de eletrocardiogramas (ECG), facilitando a geração de laudos preliminares com alta precisão.
                    Com o objetivo de aprimorar a eficiência dos profissionais de saúde, oferecemos funcionalidades como:
                </p>
                <ul>
                    <li>Upload de imagens de ECG nos formatos JPG, PNG e PDF</li>
                    <li>Análise automática com identificação de ritmos cardíacos e anomalias</li>
                    <li>Geração de laudos preliminares completos</li>
                    <li>Perfis específicos para pacientes, médicos e gestores de saúde</li>
                    <li>Integração com sistemas de prontuário eletrônico</li>
                </ul>
            </section>
            <section>
                <h2>Objetivo do Projeto</h2>
                <p>
                    Nosso objetivo principal é otimizar o processo de análise de ECGs, reduzindo o tempo de resposta e aumentando a precisão dos laudos médicos. 
                    Além disso, promovemos a interoperabilidade no setor de saúde ao integrar nossa ferramenta com outros sistemas.
                </p>
            </section>
            <section>
                <h2>Destaques</h2>
                <p>
                    A aplicação é acessível via navegador, sem necessidade de instalação, e foi desenvolvida com as melhores práticas de acessibilidade para atender a todos os usuários, incluindo aqueles com deficiências.
                </p>
            </section>
            <a href="upload.jsp" class="cta-button">Experimente Agora</a>
        </main>
        <%@include file="WEB-INF/jspf/footer.jspf" %> <!-- Inclusão do rodapé -->
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %> <!-- Inclusão de scripts de finalização -->
    </body>
</html>