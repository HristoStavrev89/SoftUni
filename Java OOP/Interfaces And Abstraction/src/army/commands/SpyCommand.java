package army.commands;

import army.factories.SoldierFactory;
import army.interfaces.Soldier;

import java.util.List;

public class SpyCommand extends BaseCommand {
    public SpyCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
    super.add(SoldierFactory.produceSpy(args));
    }
}
