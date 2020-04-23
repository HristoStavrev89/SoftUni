package army.helperCasses.interfaces;

import army.enums.State;

public interface Mission {

    void completeMission();
    String getCodeName();
    State getState();

}
