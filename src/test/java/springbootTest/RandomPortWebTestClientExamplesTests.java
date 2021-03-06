package springbootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestConfiguration 
public class RandomPortWebTestClientExamplesTests {
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void testRoot(){
		this.webClient.get().uri("/").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Greetings from Spring Boot!");
		
	}

}
