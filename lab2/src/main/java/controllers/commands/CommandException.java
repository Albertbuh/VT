package controllers.commands;

public class CommandException extends Exception {
    CommandException() {}

    CommandException(String message) {
        super(message);
    }
    CommandException(Exception e) {
        super(e);
    }

    CommandException(String message, Exception e) {
        super(message, e);
    }
}
