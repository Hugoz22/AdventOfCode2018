import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Puzzle {

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private List<String> lines;

    protected Puzzle(String fileLocation) {
        try {
            lines = readFileToList(fileLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<String> readFileToList(String fileLocation) throws IOException {
        return Files.readAllLines(Paths.get(fileLocation));
    }

    public Solution getResult() {
        String solutionOfA = String.valueOf(getResultOfPartOne());
        String solutionOfB = String.valueOf(getResultOfPartTwo());
        return new Solution(solutionOfA, solutionOfB);
    }

    protected abstract int getResultOfPartOne();

    protected abstract int getResultOfPartTwo();

}
