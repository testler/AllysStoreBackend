package AllThingsByAV.backend;

import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
@RequestMapping("/")
public class BackendApplication {


	@PostMapping(path="/adminLogin")
	public String authenticate() {
		return "Success!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
