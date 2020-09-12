package ErrorsCheckRepository;

import java.io.IOException;

public interface StringRepository {
    String FileRead(String path) throws IOException;
}
