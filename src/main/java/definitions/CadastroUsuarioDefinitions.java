package definitions;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import data.CadastroData;
import utils.FrameworkUtils;
import utils.RESTUtils;

public class CadastroUsuarioDefinitions extends FrameworkUtils {
	RESTUtils restUtils = new RESTUtils();
	CadastroData cadastroData = new CadastroData();
	String url;

	public String RealizaCadastroUsuario(String email, String senha) throws IOException, JSONException {
		url = "http://localhost:3000/auth/registrar";
		String retorno = restUtils.sendPost(url, cadastroData.gerarJsonCadastro(email, senha));
		if (retorno.contains("Falha ao cadastrar o usuário")) {
			return "";
		} else {
			JSONObject json = new JSONObject(retorno);
			return json.get("token").toString();
		}
	}

	public String RealizaLoginUsuario(String email, String senha) throws IOException, JSONException {
		url = "http://localhost:3000/auth/login";
		String retorno = restUtils.sendPost(url, cadastroData.gerarJsonCadastro(email, senha));
		if (retorno.contains("Falha ao cadastrar o usuário")) {
			return "";
		} else {
			JSONObject json = new JSONObject(retorno);
			return json.get("token").toString();
		}
	}
}
