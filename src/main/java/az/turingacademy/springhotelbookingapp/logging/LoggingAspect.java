package az.turingacademy.springhotelbookingapp.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* az.turingacademy.springhotelbookingapp.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Started: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* az.turingacademy.springhotelbookingapp.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Completed: {} with result = {}", joinPoint.getSignature(), result);
    }
}
