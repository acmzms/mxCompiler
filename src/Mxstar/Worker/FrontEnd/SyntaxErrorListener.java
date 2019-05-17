package Mxstar.Worker.FrontEnd;
import Mxstar.Worker.ErrorRecorder;
import org.antlr.v4.runtime.*;
public class SyntaxErrorListener extends BaseErrorListener {
    private ErrorRecorder errorRecorder;
    public SyntaxErrorListener(ErrorRecorder errorRecorder) {
        this.errorRecorder = errorRecorder;
    }
    @Override public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorRecorder.addRecord();
    }
    public boolean isError() {
        return errorRecorder.errorOccured();
    }
}
