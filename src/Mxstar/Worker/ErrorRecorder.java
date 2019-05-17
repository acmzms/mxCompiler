package Mxstar.Worker;
public class ErrorRecorder {
    boolean isEmpty = true;
    public void addRecord() {
        isEmpty = false;
    }
    public boolean errorOccured() {
        return !isEmpty;
    }
}
