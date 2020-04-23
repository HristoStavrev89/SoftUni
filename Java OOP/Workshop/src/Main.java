import systemSplit.core.system.SystemSplit;
import systemSplit.engine.Engine;
import systemSplit.io.reader.ConsoleReader;
import systemSplit.io.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new SystemSplit();
        Engine engine = new Engine(systemSplit, reader);
        engine.run();






    }
}
