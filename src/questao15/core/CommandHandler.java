package questao15.core;

import java.lang.reflect.Method;

public class CommandHandler<T, R> {

    private final T target;
    private final Method method;

    public CommandHandler(T target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public CommandResult<R> execute(Object... parameters) {

        try {

            Class<?>[] parameterTypes =
                    method.getParameterTypes();

            if (parameterTypes.length != parameters.length) {
                return CommandResult.error(
                        "Quantidade de parametros invalida."
                );
            }

            for (int i = 0; i < parameterTypes.length; i++) {

                if (!isCompatible(
                        parameterTypes[i],
                        parameters[i])) {

                    return CommandResult.error(
                            "Tipo do parametro " +
                                    (i + 1) +
                                    " invalido. Esperado: " +
                                    parameterTypes[i].getSimpleName()
                    );
                }
            }

            Object result =
                    method.invoke(target, parameters);

            return CommandResult.success(
                    (R) result
            );

        } catch (Exception e) {

            return CommandResult.error(
                    "Erro ao executar comando: " +
                            e.getMessage()
            );
        }
    }

    private boolean isCompatible(
            Class<?> expected,
            Object value) {

        if (value == null) {
            return !expected.isPrimitive();
        }

        if (expected.isPrimitive()) {

            if (expected == int.class) {
                return value instanceof Integer;
            }

            if (expected == double.class) {
                return value instanceof Double;
            }

            if (expected == float.class) {
                return value instanceof Float;
            }

            if (expected == long.class) {
                return value instanceof Long;
            }

            if (expected == boolean.class) {
                return value instanceof Boolean;
            }

            if (expected == char.class) {
                return value instanceof Character;
            }

            if (expected == byte.class) {
                return value instanceof Byte;
            }

            if (expected == short.class) {
                return value instanceof Short;
            }
        }

        return expected.isInstance(value);
    }
}