/*
ScannerAbstract :
Provide abstract base class to form the basis of the main Scanner class. here
a common initialiser and `advance` function are defined.
*/
public abstract class ScannerAbstract {

    public static final char EOF = (char)-1;
    public static final int EOF_TYPE    = 0;
    public static final int UNEXPECTED_TYPE = 1;

    String input;       // what we will be scanning.
    int    size;        // length of our input.
    int    pos;         // current scanning positon.
    int    linenum;     // current line number position.
    char   curr;        // current character for inpsection.

    public abstract Token nextToken();

    public ScannerAbstract(String input) {
        this.input = input;
        curr = input.charAt(pos);       // setup lookahead
        size = input.length();
    }

    public void advance() {
        pos++;
        if (pos >= size) {
            curr = EOF;
        } else {
            curr = input.charAt(pos);
        }
    }
}