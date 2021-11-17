package week2.day1;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//import org.testng.annotations.ITestAnnotation;

public class Retry implements IRetryAnalyzer,IAnnotationTransformer{
	int maxRun=3;
	int Count=0;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && Count < maxRun) {
			Count++;
			return true;
		}
		return false;
	}
		
	
//public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
 //annotation.setRetryAnalyzer(Retry.class);
 // }

}
