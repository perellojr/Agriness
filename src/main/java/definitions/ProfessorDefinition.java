package definitions;

import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import data.CadastroData;
import utils.FrameworkUtils;
import utils.RESTUtils;

public class ProfessorDefinition extends FrameworkUtils {
	RESTUtils restUtils = new RESTUtils();
	CadastroData cadastroData = new CadastroData();
	String url;

	public String ConsultaProfessores(String token) throws IOException, JSONException {
		url = "http://localhost:3000/professores";
		return restUtils.sendGet(url, token);
	}

	public boolean ValidaProfessorDisciplina(String prof, String professores, String mat, String disciplinas)
			throws JSONException {
		JSONObject dadosProf = new JSONObject("{\"professores\":" + professores + "}");
		JSONObject dadosMat = new JSONObject("{\"disciplinas\":" + disciplinas + "}");
		JSONArray arrayDadosProf = dadosProf.getJSONArray("professores");
		JSONArray arrayDadosMat = dadosMat.getJSONArray("disciplinas");
		for (int i = 0; i < arrayDadosMat.length(); i++) {
			JSONObject materiaJson = new JSONObject(arrayDadosMat.get(i).toString());
			if (materiaJson.get("nome").toString().compareTo(mat) == 0) {
				for (int j = 0; j < arrayDadosProf.length(); j++) {
					JSONObject profJson = new JSONObject(arrayDadosProf.get(j).toString());
					if (profJson.get("nome").toString().compareTo(prof) == 0 && materiaJson.get("id").toString()
							.compareTo(profJson.get("idDisciplina").toString()) == 0) {
						System.out.println("Professor(a) " + prof + " encontrado na disciplina " + mat);
						System.out.println("| " + profJson);
						System.out.println("| " + materiaJson);
						return true;
					}
				}
			}
		}
		return false;
	}
}
