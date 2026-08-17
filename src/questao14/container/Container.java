package questao14.container;

import questao14.annotations.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) {

        try {

            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            T instance = createInstance(clazz);

            injectDependencies(instance);

            instances.put(clazz, instance);

            return instance;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao criar dependência: " + clazz.getName(),
                    e
            );
        }
    }

    private <T> T createInstance(Class<T> clazz)
            throws Exception {

        Constructor<?>[] constructors =
                clazz.getDeclaredConstructors();

        if (constructors.length == 0) {
            throw new RuntimeException(
                    "Nenhum construtor encontrado para: "
                            + clazz.getName()
            );
        }

        Constructor<?> constructor =
                constructors[0];

        constructor.setAccessible(true);

        Class<?>[] parameterTypes =
                constructor.getParameterTypes();

        if (parameterTypes.length == 0) {
            return clazz.getDeclaredConstructor().newInstance();
        }

        Object[] dependencies =
                new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            dependencies[i] =
                    getInstance(parameterTypes[i]);
        }

        return clazz.cast(
                constructor.newInstance(dependencies)
        );
    }

    private void injectDependencies(Object instance)
            throws Exception {

        Class<?> clazz = instance.getClass();

        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(Inject.class)) {

                field.setAccessible(true);

                Object dependency =
                        getInstance(field.getType());

                field.set(instance, dependency);
            }
        }
    }
}