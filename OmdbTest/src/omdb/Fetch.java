package omdb;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
 

 
public class Fetch {
 
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.omdbapi.com/?t=tank&y=&plot=short&r=json");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				System.out.println(strTemp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
