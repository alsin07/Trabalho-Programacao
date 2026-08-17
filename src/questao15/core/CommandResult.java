package questao15.core;

public class CommandResult<T> {

    private final boolean success;
    private final T value;
    private final String message;

    public CommandResult(boolean success, T value, String message) {
        this.success = success;
        this.value = value;
        this.message = message;
    }

    public static <T> CommandResult<T> success(T value) {
        return new CommandResult<>(
                true,
                value,
                "Comando executado com sucesso."
        );
    }

    public static <T> CommandResult<T> error(String message) {
        return new CommandResult<>(
                false,
                null,
                message
        );
    }

    public boolean isSuccess() {
        return success;
    }

    public T getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "success=" + success +
                ", value=" + value +
                ", message='" + message + '\'' +
                '}';
    }
}