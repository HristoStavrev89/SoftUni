package army;

import army.enums.Corp;
import army.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    @Override
    public Corp getCorp() {
        return this.corp;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCorps: " + this.getCorp().toString();
    }
}
