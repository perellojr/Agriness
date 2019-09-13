package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import definitions.CadastroUsuarioDefinitions;
import definitions.DisciplinaDefinitions;
import definitions.ProfessorDefinition;
import definitions.TurmaDefinitions;
import utils.FrameworkUtils;
import utils.RESTUtils;

public class CadastroUsuarioSteps {
	FrameworkUtils frameworkUtils = new FrameworkUtils();
	CadastroUsuarioDefinitions cadastro = new CadastroUsuarioDefinitions();
	TurmaDefinitions turma = new TurmaDefinitions();
	ProfessorDefinition professor = new ProfessorDefinition();
	DisciplinaDefinitions disciplina = new DisciplinaDefinitions();
	RESTUtils restUtils = new RESTUtils();
	String token;
	String turmas;
	String professores;
	String disciplinas;

	@Dado("^a necessidade de cadastrar um usuário novo$")
	public void a_necessidade_de_cadastrar_um_usuário_novo() throws Throwable {

	}

	@Quando("^solicito a criação de um usuário informando usuario '(.*)' e senha '(.*)'$")
	public void solicito_a_criação_de_um_usuário_informando_usuario_gmail_com_e(String email, String senha)
			throws Throwable {
		System.out.println("Realizando cadastro de usuário");
		token = cadastro.RealizaCadastroUsuario(email, senha);
	}

	@Então("^o usuário é cadastrado$")
	public void o_usuário_é_cadastrado() throws Throwable {
		assertFalse("Não foi gerado token para o cadastro do usuário.", token.isEmpty());
		System.out.println("Cadastro realizado");
	}

	@Dado("^um usuário cadastrado$")
	public void um_usuário_cadastrado() throws Throwable {

	}

	@Quando("^informo os dados de usuario '(.*)' e senha '(.*)' para login$")
	public void informo_os_dados_de_usuario_gmail_com_e_para_login(String email, String senha) throws Throwable {
		System.out.println("Realizando login");
		token = cadastro.RealizaLoginUsuario(email, senha);
	}

	@Então("^o login será realizado com sucesso$")
	public void o_login_será_realizado_com_sucesso() throws Throwable {
		assertFalse("Não foi possível realizar o login do usuário.", token.isEmpty());
		System.out.println("Login realizado");
	}

	@Quando("^login realizado com usuario '(.*)' e senha '(.*)'$")
	public void login_realizado_com_usuario_gmail_com_e_senha(String email, String senha) throws Throwable {
		System.out.println("Realizando login");
		token = cadastro.RealizaLoginUsuario(email, senha);
		assertFalse("Não foi possível realizar o login do usuário.", token.isEmpty());
		System.out.println("Login realizado");
	}

	@Quando("^consulto as informações das turmas$")
	public void consulto_as_informações_de_alunos() throws Throwable {
		System.out.println("Consultando as turmas disponíveis");
		turmas = turma.ConsultaTurmas(token);
	}

	@Então("^tenho o número total de alunos por turmas$")
	public void tenho_o_número_total_de_alunos_por_turmas() throws Throwable {
		System.out.println("Consultando o número de alunos por turma");
		turma.ContaAlunosPorTurma(turmas);
	}

	@Quando("^consulto as informações das disciplinas$")
	public void consulto_as_informações_das_disciplinas() throws Throwable {
		System.out.println("Consultando as disciplinas disponíveis");
		disciplinas = disciplina.ConsultaDisciplinas(token);
	}

	@Quando("^consulto as informações os professores$")
	public void consulto_as_informações_os_professores() throws Throwable {
		System.out.println("Consultando os professores disponíveis");
		professores = professor.ConsultaProfessores(token);
	}

	@Então("^valido que a professora '(.*)' dá aula de '(.*)'$")
	public void valido_que_a_professora_Débora_dá_aula_de_Matemática(String prof, String mat) throws Throwable {
		System.out.println("Validando se o(a) professor(a) " + prof + " dá a disciplina de " + mat);
		assertTrue("Professor(a) " + prof + " não dá a disciplina de " + mat, professor.ValidaProfessorDisciplina(prof,professores,mat,disciplinas));
	}

}
