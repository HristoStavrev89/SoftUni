package army.commands;

import army.factories.SoldierFactory;
import army.interfaces.Soldier;

import java.util.List;

public class LieutenantGeneralCommand extends BaseCommand {


    public LieutenantGeneralCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceLieutenantGeneral(args, this.getSoldiers()));
    }
}
