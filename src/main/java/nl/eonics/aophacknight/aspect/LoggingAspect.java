package nl.eonics.aophacknight.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 1. @Before Advice - Add a logging statement before the execution of getProductById().

    // 2. @AfterReturning Advice - Log the returned value from getProductById().

    // 3. @AfterThrowing Advice - Add an advice that catches any exceptions and logs them.
    
    // 4. @Around Advice -  Add an advice to time the execution of createProduct().
    
}