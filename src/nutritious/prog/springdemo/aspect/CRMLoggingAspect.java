package nutritious.prog.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	 
    // setup pointcut declarations
    @Pointcut("execution(* nutritious.prog.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}
 
    @Pointcut("execution(* nutritious.prog.springdemo.service.*.*(..))")
    private void forServicePackage(){}
 
    @Pointcut("execution(* nutritious.prog.springdemo.dao.*.*(..))")
    private void forDAOPackage(){}
 
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}
 
    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
 
        // display the method
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>> in @Before: calling method: " + method);
 
        // display the arguments to the method
        // get the arguments
        Object[] args = joinPoint.getArgs();
 
        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }
    
    @AfterReturning(
    		pointcut = "forAppFlow()",
    		returning = "theResult"
    		)
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
    	String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>> in @AfterReturning: from method: " + method);
        
        myLogger.info("=====>> result: " + theResult);
    }
 
}











