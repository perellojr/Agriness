package data;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import utils.FrameworkUtils;

public class CadastroData extends FrameworkUtils{
	
	public String gerarJsonCadastro(String email, String senha) throws JSONException {
		JSONObject retorno = new JSONObject();
		retorno.put("email", email);
		retorno.put("password", senha);
		return retorno.toString();
	}
	
}