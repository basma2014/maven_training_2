package fr.lernejo.tester.internal;

import com.sun.source.tree.ModifiersTree;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassDescription {

    private final Class<?> clazz;

    public TestClassDescription(Class<?> clazz){
        this.clazz = clazz;
    }
    public List<Method> ListTestMethods() {
        Method[] methods = clazz.getDeclaredMethods();

        return Arrays.stream(methods)
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> m.getReturnType().equals(void.class))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .collect(Collectors.toList());
    }
}
