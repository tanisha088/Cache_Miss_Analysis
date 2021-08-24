import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java Driver <test-file>\n\t\tProvide name of test file as argument.");
            return;
        }

        CharStream input = CharStreams.fromReader(new FileReader(args[0]));
        LoopNestLexer lexer = new LoopNestLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LoopNestParser parser = new LoopNestParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.tests();
        Analysis cacheMissAnalysis = new Analysis();
        ParseTreeWalker.DEFAULT.walk(cacheMissAnalysis, tree);
    }
}
