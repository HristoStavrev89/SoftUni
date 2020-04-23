package solidExercise.appenders;

import solidExercise.appenders.interfaces.Appender;
import solidExercise.enumerations.ReportLevel;
import solidExercise.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;


    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    protected AppenderImpl (Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
    }

    protected String format(String data, ReportLevel reportLevel, String message) {
        return this.layout.format(data, reportLevel, message);
    }


    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
