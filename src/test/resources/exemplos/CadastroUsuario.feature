# language: pt
Funcionalidade: Cadastrar um usuário no sistema e realizar login

  Esquema do Cenário: Cadastrar um usuário
    Dado a necessidade de cadastrar um usuário novo
    Quando solicito a criação de um usuário informando usuario '<email>' e senha '<senha>'
    Então o usuário é cadastrado

    Exemplos: 
      | email                | senha  |
      | usuario-18@gmail.com | 123456 |

  Esquema do Cenário: Logar com o usuário
    Dado um usuário cadastrado
    Quando informo os dados de usuario '<email>' e senha '<senha>' para login
    Então o login será realizado com sucesso

    Exemplos: 
      | email                | senha  |
      | usuario-18@gmail.com | 123456 |
