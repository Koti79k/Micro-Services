package Products.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Products.Filters.RequestResponseLoggers;

@Configuration
public class FiltersConfig {

	@Bean
	FilterRegistrationBean<RequestResponseLoggers> createLoggers(RequestResponseLoggers requestResponseLoggers){
		FilterRegistrationBean<RequestResponseLoggers> registrationBean=new FilterRegistrationBean<>();
		
		registrationBean.setFilter(requestResponseLoggers); 
		registrationBean.addUrlPatterns("/v1/addProduct","/v1/product/*"); //get data of this URLs in console
		
		return registrationBean;
	}
}
