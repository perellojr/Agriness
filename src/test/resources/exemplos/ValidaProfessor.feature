# language: pt
Funcionalidade: Validar o vinculo de professores com as matérias

  Esquema do Cenário: Validar que a professora Débora dá aula de Matemática
    Dado login realizado com usuario '<email>' e senha '<senha>'
    Quando consulto as informações das disciplinas
    E consulto as informações os professores
    Então valido que a professora '<professora>' dá aula de '<disciplina>'

    Exemplos: 
      | email               | senha  | professora | disciplina |
      | usuario-1@gmail.com | 123456 | Débora     | Matemática |
