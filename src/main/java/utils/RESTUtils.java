package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTUtils {

	public RESTUtils() {

	}

	public String sendPost(String requestUrl, String payload) throws IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonString = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();
			System.out.println("Enviando o comando POST");
			System.out.println("| URL: " + url);
			System.out.println("| Payload: " + payload);
			System.out.println("| Cod Retorno: " + connection.getResponseCode());
			System.out.println("| Retorno: " + jsonString.toString());
			if (connection.getResponseCode() == 200 || connection.getResponseCode() == 201 || connection.getResponseCode() == 204) {
				return jsonString.toString();
			} else {
				return "Falha ao cadastrar o usuário";
			}
		} catch (IOException e) {
			return "Falha ao cadastrar o usuário";
		}
	}

	public boolean sendPut(String requestUrl, String data) throws IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("PUT");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
			osw.write(data);
			osw.flush();
			osw.close();
			System.out.println("Enviando o comando PUT");
			System.out.println("| URL: " + url);
			System.out.println("| Cod Retorno: " + connection.getResponseCode());
			if (connection.getResponseCode() == 200 || connection.getResponseCode() == 204) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
	
	public String sendGet(String requestUrl, String token) throws IOException {
		HttpURLConnection connection = null;
		String output = "";
		String saida = "";
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", "Bearer " + token);
			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			while ((output = br.readLine()) != null) {
				saida += output;
			}
			connection.disconnect();
			System.out.println("Enviando o comando GET");
			System.out.println("| URL: " + url);
			System.out.println("| Cod Retorno: " + connection.getResponseCode());
			System.out.println("| Retorno: " + saida);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return saida;
	}
	
	public boolean sendDelete(String requestUrl) throws IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("DELETE");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
			osw.flush();
			osw.close();
			System.out.println("Enviando o comando POST");
			System.out.println("| URL: " + url);
			System.out.println("| Cod Retorno: " + connection.getResponseCode());
			if (connection.getResponseCode() == 200 || connection.getResponseCode() == 202 || connection.getResponseCode() == 204) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
	
}
