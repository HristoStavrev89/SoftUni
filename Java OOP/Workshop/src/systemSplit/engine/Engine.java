package systemSplit.engine;

import systemSplit.core.command.Command;
import systemSplit.core.command.factory.CommandFactory;
import systemSplit.core.system.SystemSplit;
import systemSplit.io.reader.Reader;

public class Engine {

    private static final String END_COMMAND = "System Split";

    private SystemSplit systemSplit;
    private Reader reader;


    public Engine(SystemSplit systemSplit, Reader reader) {
        this.systemSplit = systemSplit;
        this.reader = reader;
    }

    public void run() {

        String line = reader.readLine();

        while (!END_COMMAND.equalsIgnoreCase(line)) {

            String[] tokens = line.split("[\\(,\\s\\)]+");
            String commandName = tokens[0];
            Object[] params = new Object[tokens.length];
            params[0] = this.systemSplit;
            for (int i = 0; i < tokens.length; i++) {
                params[i] = tokens[i];
            }


            Command command = CommandFactory.buildCommand(commandName, params);
            command.execute();
            line = this.reader.readLine();
        }
        Command command = CommandFactory.buildCommand("System Split", this.systemSplit);
        command.execute();

    }
}
