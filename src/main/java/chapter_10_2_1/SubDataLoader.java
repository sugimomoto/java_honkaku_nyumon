package chapter_10_2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SubDataLoader extends SuperDataLoader {

    public SubDataLoader(String fileName) {
        super(fileName);
    }

    @Override
    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(this.fileName));
        return lines.subList(0, 1);
    }
}
