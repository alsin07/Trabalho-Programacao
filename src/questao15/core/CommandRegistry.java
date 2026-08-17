package questao15.core;

import questao15.annotations.Command;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private final Map<String, CommandHandler<?, ?>> commands =
            new HashMap<>();

    public void register(Object object) {

        Class<?> clazz = object.getClass();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Command.class)) {

                Command annotation =
                        method.getAnnotation(Command.class);

                String name = annotation.name();

                if (commands.containsKey(name)) {
                    throw new IllegalArgumentException(
                            "Comando ja registrado: " + name
                    );
                }

                CommandHandler<Object, Object> handler =
                        new CommandHandler<>(object, method);

                commands.put(name, handler);
            }
        }
    }

    public CommandResult<?> execute(
            String commandName,
            Object... parameters) {

        CommandHandler<?, ?> handler =
                commands.get(commandName);

        if (handler == null) {

            return CommandResult.error(
                    "Comando nao encontrado: " +
                            commandName
            );
        }

        return executeHandler(
                handler,
                parameters
        );
    }

    private <T, R> CommandResult<R> executeHandler(
            CommandHandler<T, R> handler,
            Object... parameters) {

        return handler.execute(parameters);
    }

    public void listCommands() {

        System.out.println("Comandos registrados:");

        for (String command : commands.keySet()) {
            System.out.println("- " + command);
        }
    }
}