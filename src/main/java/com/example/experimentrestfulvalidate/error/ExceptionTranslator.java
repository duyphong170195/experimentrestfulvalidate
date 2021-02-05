package com.example.experimentrestfulvalidate.error;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * exception translator for all throwable classes.
 *
 */
@AllArgsConstructor
//@Component
//@NoArgsConstructor
//@RequiredArgsConstructor
public class ExceptionTranslator {

    private final MessageSource messageSource;

    private final String defaultMessage;

    private final Locale locale;


    /**
     * translate exception with cause.
     * <h3>usage:</h3>
     * <pre>
     * ExceptionTranslator exp;
     * Throwable cause;
     * throw exp.translate(NotExistsException::new, cause,"not.exists", id);
     * </pre>
     *
     * @param <T> translated exception type
     * @param <C> cause exception type
     * @param throwable {@code (message, cause) => Throwable } function (for example... RuntimeException::new ).
     * @param cause cause of exception
     * @param code message code
     * @param args message arguments
     * @return translated exception
     */
    public <T extends Throwable, C extends Throwable> T translate(BiFunction<String, C, T> throwable, C cause,
                                                                  String code, Object... args) {
        String message =
                messageSource.getMessage(code, args, String.format(locale, defaultMessage, code, Arrays.toString(args)), locale);
        return throwable.apply(message, cause);
    }

    /**
     * translate exception without cause.
     * <h3>usage:</h3>
     * <pre>
     * ExceptionTranslator exp;
     * throw exp.translate(NotExistsException::new, "not.exists", id);
     * </pre>
     * @param <T> translated exception type
     * @param throwable {@code message => Throwable } function (for example... RuntimeException::new )
     * @param code message code
     * @param args message arguments
     * @return translated exception
     */
    public <T extends Throwable> T translate(Function<String, T> throwable, String code, Object... args) {
        return translate((m, c) -> throwable.apply(m), null, code, args);
    }

}