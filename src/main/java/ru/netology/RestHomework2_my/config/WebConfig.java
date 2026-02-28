//Шаг 3: Регистрируем резолвер в конфигурации
package ru.netology.RestHomework2_my.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.RestHomework2_my.resolvers.MyArgumentResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // Добавляем наш резолвер в начало списка (чтобы он сработал первым)
        resolvers.add(0, new MyArgumentResolver());
    }
}
//Важно: Spring перебирает резолверы по порядку. Наш должен быть первым, чтобы перехватить @AuthQuery.