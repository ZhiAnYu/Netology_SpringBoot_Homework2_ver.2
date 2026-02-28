//Шаг 2: Создаём резолвер AuthArgumentResolver

package ru.netology.RestHomework2_my.resolvers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.RestHomework2_my.annotations.MyAuthQuery;
import ru.netology.RestHomework2_my.model.User;

public class MyArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // Проверяем: параметр должен быть типа User и помечен @AuthQuery
        return parameter.hasParameterAnnotation(MyAuthQuery.class) &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        // Извлекаем параметры из query-строки
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // Валидация вручную (или можно делегировать Validator)
        if (user == null || user.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Параметр 'user' обязателен"
            );
        }
        if (password == null || password.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Параметр 'password' обязателен"
            );
        }
        if (password.length() < 3) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Длина пароля должна быть не менее 3 символов"
            );
        }

        // Создаём и возвращаем объект
        return new User(user, password);
    }
}
//Что делает:
//Проверяет, подходит ли параметр для обработки (supportsParameter)
//Извлекает user и password из запроса
//Валидирует их и выбрасывает ResponseStatusException при ошибке
//Возвращает готовый объект User в контроллер