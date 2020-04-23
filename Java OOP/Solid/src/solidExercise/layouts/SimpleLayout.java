package solidExercise.layouts;

import solidExercise.enumerations.ReportLevel;
import solidExercise.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String data, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", data, reportLevel.toString(), message);
    }



}
