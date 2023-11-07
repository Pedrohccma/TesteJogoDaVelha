# TesteJogoDaVelha
O sistema foi desenvolvido para o desafio técnico realizado pela Letras.com. Na aplicação em questão é permitido ao usuário iniciar um jogo da velha para duas pessoas 

## Funcionalidades:
- Iniciar um jogo da velha para 2 usuários
- Reiniciar os campos para um novo jogo

## Stack Utilizada:
- Kotlin

## Resoluções do Projeto
- Optou-se por construir um aplicativo utilizando Kotlin, permitindo uma maior facilidade na criação e  armazenamento dos lembretes como variáveis locais, assim como o acesso para uma listagem mais simples.
- Por uma questão de estética e maior conforto/acessibilidade do usuãrio, foi criada uma activityCover para que fosse possivel entrar no aplicativo
- Foi feito o uso de uma variável Id que permitiu um controle mais fácil do processo de criação das ImageViews (representam os campos para jogo) e a geração da matriz através destes campos.
- Utilização do JUnit para realização de testes unitários (A função escolhida foi a de criação de ImageViews(Box) dos campos(Não foi possível completar!))

  ## Pontos de melhoria
- Elaborar testes
- Clean code
- Acessibilidade

## Instruções para executar o Sistema:
1 - Deve-se clonar o projeto através do link: https://github.com/Pedrohccma/Teste-DTI---Lembretes.git , ou inicializar o código utilizando o AndroidStudio
2 - Executar a solução, sendo direcionado para a página inicial, onde poderá clicar em jogar e assim os 2 usuários poderão jogar o jogo da velha
3 - Após a vitória de um dos usuários basta clicar no botão de "Novo Jogo" para reinicar os campos e jogar novamente
