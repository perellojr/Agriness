# language: pt
Funcionalidade: Listar os alunos matriculados nas turmas

  Esquema do Cenário: Contagem de alunos nas turmas
    Dado login realizado com usuario '<email>' e senha '<senha>'
    Quando consulto as informações das turmas
    Então tenho o número total de alunos por turmas

    Exemplos: 
      | email               | senha  |
      | usuario-1@gmail.com | 123456 |
