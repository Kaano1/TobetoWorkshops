    package com.tobeto.spring.b.core.exceptions;

    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.MethodArgumentNotValidException;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.ResponseStatus;
    import org.springframework.web.bind.annotation.RestControllerAdvice;


    @RestControllerAdvice
    public class GlobalExceptionHandler
    {
        @ExceptionHandler({MethodArgumentNotValidException.class})
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public String handleValidException(MethodArgumentNotValidException methodArgumentNotValidException)
        {
                return methodArgumentNotValidException.getMessage();
        }

        @ExceptionHandler({RuntimeException.class})
        @ResponseStatus(HttpStatus.FORBIDDEN)
        public String handleRuntimeException(RuntimeException runtimeException)
        {
            return (runtimeException.getMessage());
        }

        @ExceptionHandler({ Exception.class })
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public String handleUnKnownErrors(){
            return "Exception_";
        }

    }
