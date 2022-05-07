package razarm.tosan.controller.commandline;

import java.util.HashMap;
import java.util.Map;

public abstract class QuestionHandler {

    protected static Map<String, QuestionHandler> questionHandlers = new HashMap<>();

    protected QuestionHandler next;
    protected QuestionHandler prev;


    public QuestionHandler() {
    }


    public  void nextQuestion( Map<String, Object> values){
        if(next != null)  next.run(values);
    }


    public abstract void run(Map<String, Object> values);

    public QuestionHandler getNext() {
        return next;
    }

    public QuestionHandler nextQuestionHandler(String name, QuestionHandler next) {
        next.setPrev(this);
        this.questionHandlers.put(name, next);
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
