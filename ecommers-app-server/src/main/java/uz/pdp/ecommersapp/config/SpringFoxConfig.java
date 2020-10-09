package uz.pdp.ecommersapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@PropertySource("classpath:swagger.properties")
public class SpringFoxConfig {


    @Bean
    public Docket api() {
//        final String swaggerToken =
      Docket docket= new Docket(DocumentationType.SWAGGER_2);
//                .globalOperationParameters(Collections.singletonList(
//                        new ParameterBuilder()
//                                .name("Authorization")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(true)
//                                .hidden(true)
//                                .defaultValue("Bearer " + swaggerToken)
//                                .build()
//                        )
//                );
    docket .select()
                .apis(RequestHandlerSelectors.basePackage("uz.mycompany"))
                .paths(PathSelectors.ant("/v2/**"))
                .build()

                .enable(true);
//			.apiInfo(getApiInfo())
//			.securityContexts(Lists.newArrayList(securityContext()))
//			.securitySchemes(Lists.newArrayList(apiKey()));

    return docket;

    }
    private ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXBlckFkbWluMSIsImlhdCI6MTU1OTAyODU0OSwiZXhwIjoxNTU5NjMzMzQ5fQ.Z10PU71CW9kycsUfbTo4Pjh_FK8rodWAtR5-vauL6wX33sICIT7m-04oyKTCvNDCiZeGdZe5gBlU49xz-sT7eA", "header");
    }

//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null,
//                null,
//                null, // realm Needed for authenticate button to work
//                null, // appName Needed for authenticate button to work
//                "BEARER ",// apiKeyValue
//                ApiKeyVehicle.HEADER,
//                "AUTHORIZATION", //apiKeyName
//                null);
//    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("/anyPath.*"))
//                .build();
//    }

//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Lists.newArrayList(
//                new SecurityReference("AUTHORIZATION", authorizationScopes));
//    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Losgos of Uzbekistan",
                "This application can run after sign in.You can take a token,use postman to check",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Azizjon", "http://www.mycompany.uz", "azizjon990415@gmail.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}
