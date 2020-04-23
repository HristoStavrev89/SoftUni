package army.commands;
import army.factories.SoldierFactory;
import army.interfaces.Soldier;

import java.util.Collection;
import java.util.List;

public class PrivateCommand extends BaseCommand {


    public PrivateCommand(List<Soldier> soldiers) {
        super(soldiers);
    }



    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}
