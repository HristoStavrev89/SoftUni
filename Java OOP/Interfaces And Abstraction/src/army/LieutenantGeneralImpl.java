package army;

import army.interfaces.LieutenantGeneral;
import army.interfaces.Private;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((f, s) -> s.getId() - f.getId());
    }



    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        for (Private soldier : this.privates) {
            sb
                    .append("  ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
