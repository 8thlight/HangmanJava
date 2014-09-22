import java.util.ArrayList;
import java.util.List;

public class FakeWriter implements Writer {
    List<String> lines;

    public FakeWriter() {
        lines = new ArrayList<String>();
    }

    public void writeLine(String line) {
        lines.add(line);
    }

    public List<String> writtenLines() {
        return lines;
    }
}
