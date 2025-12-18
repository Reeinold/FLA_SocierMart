package facade;

public class OperationResult {
    private final boolean success;
    private final String message;

    private OperationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static OperationResult success(String msg) { return new OperationResult(true, msg); }
    public static OperationResult failure(String msg) { return new OperationResult(false, msg); }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
