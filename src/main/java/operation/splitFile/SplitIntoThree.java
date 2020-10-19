package operation.splitFile;

public class SplitIntoThree implements  FileSplit{
    public String[] getSplit(String data) {
        return data.split(" ", 3);
    }
}
