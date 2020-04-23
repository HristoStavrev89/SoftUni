package systemSplit.core.command.factory;

import systemSplit.core.command.BaseCommand;
import systemSplit.core.model.hardware.Hardware;
import systemSplit.core.system.SystemSplit;

public class ReleaseSoftwareComponentCommand extends BaseCommand {

    private SystemSplit systemSplit;
    private String hardwareName;
    private String softwareName;


    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareName = args[1].toString();
        this.softwareName = args[2].toString();
    }

    @Override
    public void execute() {

        this.systemSplit.releaseSoftware(hardwareName, softwareName);
    }
}
