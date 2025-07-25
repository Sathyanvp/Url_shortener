package Url_shortner.url_shortner.swaggerconfiguration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
    	return new OpenAPI()
    	        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
    	        .components(new Components()
    	            .addSecuritySchemes("bearerAuth", new SecurityScheme()
    	                .name("Authorization")
    	                .type(SecurityScheme.Type.HTTP)
    	                .scheme("bearer")
    	                .bearerFormat("JWT")))
    	        .info(new Info()
    	            .title("URL Shortener API")
    	            .version("1.0")
    	            .description("API documentation for the URL Shortener project"));
    }
}

