package dev.snapgram.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	private int counter = 0;
	
	@Before("logJP()")
	public void logRequest() {
		this.logger.info("Total HTTP calls: " + ++counter);
		
	}
	
	@Pointcut("within(dev.snapgram.controllers..*)")
	private void logJP() {}
}
