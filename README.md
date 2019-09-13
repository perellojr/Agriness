# Desafio Agriness
Projeto de automação de testes para api para o desafio da Agriness.

##Instruções
Executar primeiro o cenário CadastroUsuarioTest, pois ele cria o login para os demais testes.

##Mapeamento dos Arquivos
- CadastroData:<p>
Classe responsável por gerar os jsons que serão enviados 
	
- CadastroUsuarioDefinitions:<p>
Classe responsável pelo métodos que realizam ações no contexto de cadastro e login de usuário
- DisciplinaDefinitions:<p>
Classe responsável pelo métodos que realizam ações no contexto de disciplinas
- ProfessorDefinition:<p>
Classe responsável pelo métodos que realizam ações no contexto de professores 
- TurmaDefinitions:<p>
Classe responsável pelo métodos que realizam ações no contexto de turmas

- TestRule:<p>
 Classe responsável pelo início e fim da execução dos testes

- CadastroUsuarioSteps:<p>
- Classe responsável por realizar a tradução das frases do BDD em código Java
 
- FrameworkUtils:<p>
Classe responsável pelos métodos de apoio do "Framework" de testes
- RESTUtils:<p>
Classe responsável pelos métodos REST utilizados

- CadastroUsuarioTest:<p>
Classe responsável por executar os testes do contexto de cadastro e login de usuário
- ValidaProfessorTest:<p>
Classe responsável por executar os testes do contexto de professores
- ValidaTurmaTest:<p>
Classe responsável por executar os testes do contexto de turmas 

- CadastroUsuario.feature:<p>
Arquivo que armazena o BDD do contexto de cadastro e login de usuário
- ValidaProfessor.feature:<p>
Arquivo que armazena o BDD do contexto de professores
- ValidaTurma.feature:<p>
Arquivo que armazena o BDD do contexto de turmas
