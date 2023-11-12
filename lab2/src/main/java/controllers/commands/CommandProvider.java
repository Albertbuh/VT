package controllers.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commandsList = new HashMap<>();

    public CommandProvider() {

        commandsList.put(CommandName.SIGN_IN, new SignInCommand());
        commandsList.put(CommandName.LOGIN, new LoginCommand());
        commandsList.put(CommandName.MAKE_REQUEST, new MakeRequestCommand());
        commandsList.put(CommandName.CHECK_REQUESTS, new CheckRequestsCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        Command command = commandsList.get(commandName);

        return command;
    }
}
