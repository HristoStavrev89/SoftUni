package army.interfaces;

import army.helperCasses.interfaces.Repair;

import java.util.Collection;

public interface Engineer {

     void addRepair(Repair repair);
     Collection<Repair> getRepairs();


}
