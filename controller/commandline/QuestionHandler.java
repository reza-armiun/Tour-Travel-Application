package razarm.tosan.controller.commandline;

public abstract class QuestionHandler {
    public final static String ESC = "\u001B";
    public final static String GS = "\u001D";
    public final static String InitializePrinter = ESC + "@";
//    public final static String BoldOn = ESC + "E" + "\u0001";
    public final static String BoldOn = "\033[0;1m";
//    public final static String BoldOff = ESC + "E" + "\0";
    public final static String BoldOff ="\033[0;0m";
    public final static String DoubleOn = GS + "!" + "\u0011";  // 2x sized text (double-high + double-wide)
    public final static String DoubleOff = GS + "!" + "\0";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    protected QuestionHandler next;
    protected QuestionHandler prev;


    public QuestionHandler() {
    }


    public  void nextQuestion( Object  ...values){
        if(next != null)  next.run(values);
    }


    public abstract void run(Object ...values);

    public QuestionHandler getNext() {
        return next;
    }

    public QuestionHandler nextQuestionHandler(QuestionHandler next) {
        next.setPrev(this);
        this.next = next;
        return next;
    }

    public QuestionHandler getPrev() {
        return prev;
    }

    public void setPrev(QuestionHandler prev) {
        this.prev = prev;
    }
}
