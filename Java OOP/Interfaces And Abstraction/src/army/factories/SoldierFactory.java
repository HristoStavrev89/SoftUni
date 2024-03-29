package army.factories;

import army.*;
import army.enums.Corp;
import army.enums.State;
import army.helperCasses.MissionImpl;
import army.helperCasses.RepairImpl;
import army.helperCasses.interfaces.Mission;
import army.helperCasses.interfaces.Repair;
import army.interfaces.*;

import java.util.List;



public class SoldierFactory {

    public static Soldier producePrivate(List<String> args) {
        return new PrivateImpl(
                Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3))
        );
    }


    public static Soldier produceLieutenantGeneral(List<String> args, List<Soldier> soldiers) {
        LieutenantGeneral general = new LieutenantGeneralImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)));

        for (int i = 4; i < args.size(); i++) {
            int id = Integer.parseInt(args.get(i));

            for (int j = 0; j < soldiers.size(); j++) {

                if (soldiers.get(j).getId() == id) {
                    general.addPrivate((Private) soldiers.get(j));
                }
            }
        }
        return (Soldier) general;
    }


    public static Soldier produceEngineer(List<String> args) {
        Engineer engineer = new EngineerImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)),
                Corp.valueOf(args.get(4))
        );

        for (int i = 5; i < args.size(); i += 2) {
            Repair repair = new RepairImpl(args.get(i), Integer.parseInt(args.get(i + 1)));
            engineer.addRepair(repair);
        }

        return (Soldier) engineer;
    }


    public static Soldier produceCommando(List<String> args) {
        Commando commando = new CommandoImpl(Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
                Double.parseDouble(args.get(3)),
                Corp.valueOf(args.get(4))
        );

        for (int i = 5; i < args.size(); i += 2) {
            Mission mission = new MissionImpl(args.get(i), State.valueOf(args.get(i + 1).toUpperCase()));
            commando.addMission(mission);
        }

        return (Soldier) commando;
    }


    public static Soldier produceSpy(List<String> args) {
        return new SpyImpl(
                Integer.parseInt(args.get(0)),
                args.get(1),
                args.get(2),
              args.get(3)
        );
    }



}
