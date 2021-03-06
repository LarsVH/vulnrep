package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NW {
	public static String getHTML(String urlToRead) throws Exception  {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd;
		String line;

		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (FileNotFoundException e) {
			return null;
		}

	}
}
