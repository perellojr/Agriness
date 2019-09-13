package definitions;

import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import data.CadastroData;
import utils.FrameworkUtils;
import utils.RESTUtils;

public class TurmaDefinitions extends FrameworkUtils {
	RESTUtils restUtils = new RESTUtils();
	CadastroData cadastroData = new CadastroData();
	String url;

	public String ConsultaTurmas(String token) throws IOException, JSONException {
		url = "http://localhost:3000/turmas";
		return restUtils.sendGet(url, token);
	}

	public void ContaAlunosPorTurma(String turmas) throws JSONException {
		JSONObject dados = new JSONObject("{\"turmas\":" + turmas + "}");
		JSONArray arrayDados = dados.getJSONArray("turmas");
		for (int i = 0; i < arrayDados.length(); i++) {
			JSONObject turma = new JSONObject(arrayDados.get(i).toString());
			JSONArray alunos = turma.getJSONArray("alunos");
			System.out.println("A turma " + turma.get("id") + "("+ turma.get("descricao") + ") tem " + alunos.length() + " alunos");
		}
	}
}
