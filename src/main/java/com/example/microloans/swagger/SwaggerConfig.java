package com.example.microloans.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Эмулятор системы выдачи микрокредитов",
                description = "Эмулируется работа системы выдачи микрозаймов в целях обучения",
                contact = @Contact(
                        name = "Крмаров Даниил",
                        email = "kramarov.danya@yandex.ru"
)
)
)

public class SwaggerConfig {
}
