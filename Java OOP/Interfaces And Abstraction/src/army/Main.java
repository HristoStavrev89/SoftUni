package army;

import army.commands.*;
import army.commands.interfaces.Command;
import army.interfaces.Soldier;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";

        Map<String, Command> commands = new HashMap<>();

        List<Soldier> soldiers = new ArrayList<>();

        commands.put("Private", new PrivateCommand(soldiers));
        commands.put("LieutenantGeneral", new LieutenantGeneralCommand(soldiers));
        commands.put("Engineer", new EngineerCommand(soldiers));
        commands.put("Commando", new CommandoCommand(soldiers));
        commands.put("Spy", new SpyCommand(soldiers));

        while (!"End".equals(input = scanner.nextLine())) {


            String command = input.substring(0, input.indexOf(" "));

            try {
                commands.get(command).execute(
                        Arrays.stream(input.split("\\s+"))
                                .skip(1)
                                .collect(Collectors.toList())
                );
            }catch (Exception ex) {

            }
        }


        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }



    }
}
