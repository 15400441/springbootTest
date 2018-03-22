package httpinternal;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

public class HttpManager {
	
	public static void get(String url){
		try {
			
			Content content=Request.Get(url)
			.execute().returnContent();
			
			//System.out.println(content.asString());
			
			
			
		} catch (Exception e) {
			
			get(url);
			e.printStackTrace();
		} 
	}
	

}
