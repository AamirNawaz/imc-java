package com.imcjava.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Integrated Medical Care- Java",
                version = "v1",
                contact = @Contact(
                        name = "Aamir nawaz",
                        email = "aamirnawaz.dev@gmail.com"
                ),
                license = @License(
                        name = "MIT"
                ),
                termsOfService = "imc terms and conditions"
        ),
//        Dev enviroments
        servers = {@Server(
                description = "Dev",
                url = "http://localhost:9000/api"
        ),
                @Server(
                        description = "Test",
                        url = "http://localhost:9000/api"
                ),
                @Server(
                        description = "Prod",
                        url = "http://localhost:9000/api"
                )
        },


        //if we apply @SecurityRequirement on controller it will only apply to that controller only.
        //For global to apply on every controller
        security = @SecurityRequirement(
                name = "Auth"
        )

)
@SecurityScheme(
        name = "Auth",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Authentication description"

)

public class OpenApiSwaggerConfig {
}
