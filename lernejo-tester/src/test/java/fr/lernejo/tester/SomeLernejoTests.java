package fr.lernejo.tester;

import fr.lernejo.tester.api.TestMethod;
import fr.lernejo.tester.internal.TestClassDescription;

import java.lang.reflect.Method;
import java.util.List;

public class SomeLernejoTests {

    @TestMethod
    public void ok(){

    }
    @TestMethod
    public void ko(){
        throw new IllegalStateException();
    }
    public void none(){

    }

    public static void main(String[] args) {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = testClassDescription.ListTestMethods();

        if(methods.size() != 2 ) {
            throw new IllegalStateException("Should discover only 2 methods but found: " + methods);
        }

    }
}
