package army.interfaces;

import army.helperCasses.interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();

}
