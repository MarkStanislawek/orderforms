package mannafundraising.orderforms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import freemarker.template.TemplateExceptionHandler;

@Configuration
@PropertySource("classpath:application-${target_env}.properties")
@ComponentScan("mannafundraising.orderforms")
public class OrderFormsApplicationConfig {

	@Bean
	public freemarker.template.Configuration freemarkerConfig() {
		freemarker.template.Configuration config = new freemarker.template.Configuration(
				freemarker.template.Configuration.VERSION_2_3_23);
		config.setClassForTemplateLoading(getClass(), "/templates/");
		config.setDefaultEncoding("UTF-8");
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		config.setLogTemplateExceptions(false);
		return config;
	}
	
	public static final String PROFILE_DEV = "dev";
	public static final String PROFILE_STAGING = "staging";
	public static final String PROFILE_PRODUCTION = "production";
}