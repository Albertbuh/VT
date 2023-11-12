package controllers.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commandsList = new HashMap<>();
    public static final Logger logger = LoggerFactory.getLogger("CommandProvider");

    public CommandProvider() {

        commandsList.put(CommandName.SIGN_IN, new SignInCommand());
        commandsList.put(CommandName.LOGIN, new LoginCommand());
        commandsList.put(CommandName.MAKE_REQUEST, new MakeRequestCommand());
        commandsList.put(CommandName.CHECK_REQUESTS, new CheckRequestsCommand());
    }

    public Command getCommand(String name) throws CommandException{
        try {
            CommandName commandName = CommandName.valueOf(name.toUpperCase());
            return commandsList.get(commandName);
        }
        catch (Exception e) {
            logger.error("getCommand: {}", e.getMessage());
            throw new CommandException("There are no such page in provider", e);
        }

    }
}
