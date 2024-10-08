package nl.eonics.aophacknight.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    // 1. @Before Advice - Add a logging statement before the execution of getProductById().

    // 2. @AfterReturning Advice - Log the returned value from getProductById().

    // 3. @AfterThrowing Advice - Add an advice that catches any exceptions and logs them.
    
    // 4. @Around Advice -  Add an advice to time the execution of createProduct().


     // 1. @Before Advice - Executed before the method `getProductById` is called
    @Before("execution(* nl.eonics.aophacknight.service.ProductService.getProductById(..))")
    public void logBeforeGetProduct(JoinPoint point) {
        System.out.println("Executing @Before advice: Fetching product details... Function called - " + point.getSignature().getName()
        + " with argument: " + point.getArgs()[0]);
    }














    

    // 2. @AfterReturning Advice - Executed after the method `getProductById` returns
    @AfterReturning(pointcut = "execution(* nl.eonics.aophacknight.service.ProductService.getProductById(..))", returning = "result")
    public void logAfterReturningGetProduct(Object result) {
        System.out.println("Executing @AfterReturning advice: Product fetched successfully. Result: " + result);
    }

    // 3. @AfterThrowing Advice - Executed if the method `deleteProduct` throws an exception
    @AfterThrowing(pointcut = "execution(* nl.eonics.aophacknight.service.ProductService.deleteProduct(..))", throwing = "exception")
    public void logAfterThrowingDeleteProduct(Exception exception) {
        System.out.println("Executing @AfterThrowing advice: Exception occurred while deleting product. Message: " + exception.getMessage());
    }

    // 4. @Around Advice - Surrounds the execution of `createProduct`
    @Around("execution(* nl.eonics.aophacknight.service.ProductService.createProduct(..))")
    public Object logAroundCreateProduct(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Executing @Around advice: Before creating product...");
        
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Proceed with method execution
        long timeTaken = System.currentTimeMillis() - startTime;
        
        System.out.println("Executing @Around advice: After creating product. Time taken: " + timeTaken + "ms");
        
        return result;
    }
    
}