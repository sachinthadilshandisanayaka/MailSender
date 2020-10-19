package operation.splitFile;

public class SplitSpace implements FileSplit{
    public String[] getSplit(String data) {
        return data.split(" ");
    }
}
