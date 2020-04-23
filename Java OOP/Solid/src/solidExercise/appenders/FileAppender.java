package solidExercise.appenders;

import solidExercise.appenders.interfaces.Appender;
import solidExercise.customFiles.interfaces.File;
import solidExercise.enumerations.ReportLevel;
import solidExercise.layouts.interfaces.Layout;

public class FileAppender extends AppenderImpl {
private File file;

    public FileAppender(Layout layout) {
        super(layout);

    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String data, ReportLevel reportLevel, String message) {

        if (this.file == null) {
            throw new NullPointerException("File reference is not set to an instance of an object");
        }
        this.file.appendBuffer(this.format(data, reportLevel, message));
        this.file.write();



    }


}
