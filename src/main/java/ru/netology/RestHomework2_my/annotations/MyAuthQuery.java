//шаг 1. Создаём свою аннотацию @AuthQuery
//Эта аннотация «маркирует» параметр контроллера, который должен быть обработан нашим резолвером.

package ru.netology.RestHomework2_my.annotations;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAuthQuery {
    // Можно добавить параметры, например:
    // boolean required() default true;
}

