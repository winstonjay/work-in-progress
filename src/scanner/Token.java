/*
Token :

*/
import java.lang.String;

public class Token {
    public int    type;
    public String literal;

    public Token(int type, String literal) {
        this.type    = type;
        this.literal = literal;
    }

    public String toString() {
        String name = Scanner.tokenNames[type];
        return String.format("Token<%s, \"%s\">", name, literal);
    }
}