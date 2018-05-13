/*
TestScanner :
class for running some quick tests on the Scanner class.

running pre-defined tests:
    $ java -ea TestScanner

Inspecting output of custom teststrings
    $ java TestScanner "This is 1 / 100 of my(your) tests"

    Expected output:
        Token<NAME, "This">
        Token<NAME, "is">
        Token<NUMBER, "1">
        Token<DIV, "/">
        Token<NUMBER, "100">
        Token<NAME, "of">
        Token<NAME, "my">
        Token<LPAREN, "(">
        Token<NAME, "your">
        Token<RPAREN, ")">
        Token<NAME, "tests">
        Token<EOF, "EOF">
*/
public class TestScanner {

    static void testnextToken() {
        String testInput = "(123 + 89) * 57";
        Scanner scanner = new Scanner(testInput);
        Token[] tests = {
            new Token(scanner.LPAREN, "("),
            new Token(scanner.NUMBER, "123"),
            new Token(scanner.ADD, "+"),
            new Token(scanner.NUMBER, "89"),
            new Token(scanner.RPAREN, ")"),
            new Token(scanner.MUL, "*"),
            new Token(scanner.NUMBER, "57"),
            new Token(scanner.EOF_TYPE, "EOF")
        };
        Token t = scanner.nextToken();
        for (Token tt : tests) {
            assert tt.type == t.type :
                String.format("Type mis-match %s, %s", tt, t);
            assert tt.literal.equals(t.literal) :
                String.format("value mis-match %s, %s", tt, t);
            t = scanner.nextToken();
        }
        System.out.println("All nextToken tests passed.");
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            testnextToken();
        } else {
            Scanner scanner = new Scanner(args[0]);
            Token t = scanner.nextToken();
            while (t.type != scanner.EOF_TYPE) {
                System.out.println(t);
                t = scanner.nextToken();
            }
            System.out.println(t);
        }
    }
}