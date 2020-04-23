package army.commands;

import army.factories.SoldierFactory;
import army.interfaces.Soldier;

import java.util.List;

public class EngineerCommand extends BaseCommand {


    public EngineerCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceEngineer(args));
    }
}
