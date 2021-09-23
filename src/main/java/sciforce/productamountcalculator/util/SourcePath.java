package sciforce.productamountcalculator.util;

public class SourcePath {

    public static Type getType(String source) {
        if (source.startsWith("https://") || source.startsWith("http://")) {
            return Type.URL;
        }
        return Type.PATH;
    }

    public enum Type {
        URL,
        PATH
    }
}
