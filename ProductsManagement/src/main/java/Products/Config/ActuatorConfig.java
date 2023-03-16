package Products.Config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

	@Bean
	HttpTraceRepository httpTraceRepository(){
		return new InMemoryHttpTraceRepository();
	}
}
