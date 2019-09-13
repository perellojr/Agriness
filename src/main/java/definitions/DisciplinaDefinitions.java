package definitions;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;

import data.CadastroData;
import utils.FrameworkUtils;
import utils.RESTUtils;

public class DisciplinaDefinitions extends FrameworkUtils {
	RESTUtils restUtils = new RESTUtils();
	CadastroData cadastroData = new CadastroData();
	String url;

	public String ConsultaDisciplinas(String token) throws IOException, JSONException {
		url = "http://localhost:3000/disciplinas";
		return restUtils.sendGet(url, token);
	}

}
