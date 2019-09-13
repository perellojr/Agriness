package setup;

import java.net.MalformedURLException;
import java.sql.SQLException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {
	
	public String nomeCenario;

	@Before
	public void beforeCenario(Scenario cenario) throws SQLException, MalformedURLException {
		nomeCenario = cenario.getName();
		System.out.println("=================================================");
		System.out.println("Executando o cenário: " + nomeCenario);
	}

	@After
	public void afterCenario(Scenario cenario) {
		System.out.println("Execução finalizada");
		System.out.println("=================================================\n");
	}
}
