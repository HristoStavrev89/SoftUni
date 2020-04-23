package army.commands;

import army.factories.SoldierFactory;
import army.interfaces.Soldier;

import java.util.List;

public class CommandoCommand extends BaseCommand {
    public CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
    super.add(SoldierFactory.produceCommando(args));
    }
}
