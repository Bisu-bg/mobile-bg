package bg.mobile.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi apiGroup() {
    return GroupedOpenApi
            .builder()
            .group("API")
            .pathsToMatch("/**")
            .build();
  }

  @Bean
  public OpenAPI apiInfo() {
    final String securitySchemeName = "bearerAuth";
    return new OpenAPI()
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
            .components(new Components().addSecuritySchemes(
                    securitySchemeName,
                    new SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")))
            .info(new Info()
                    .title("Mobile API")
                    .description("Rest API for Mobile")
                    .version("1.0"));
  }
}