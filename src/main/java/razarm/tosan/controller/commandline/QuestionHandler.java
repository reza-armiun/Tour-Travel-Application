package razarm.tosan.controller.commandline;

import java.util.Map;

public abstract class QuestionHandler {

    private final Map<String, QuestionHandler> questionHandlers;

    protected QuestionHandler next;
    protected QuestionHandler prev;


    public QuestionHandler(Map<String, QuestionHandler> questionHandlers) {
        this.questionHandlers = questionHandlers;
    }


    public  void nextQuestion( Map<String, Object> values){
        if(next != null)  next.run(values);
    }


    public abstract void run(Map<String, Object> values);
    public abstract String getName();

    public QuestionHandler getNext() {
        return next;
    }

    public QuestionHandler nextQuestionHandler( QuestionHandler next) {
        next.setPrev(this);
        this.questionHandlers.put(next.getName(), next);
        this.next = next;
        return next;
    }

    public QuestionHandler getPrev() {
        return prev;
    }

    public void setPrev(QuestionHandler prev) {
        this.prev = prev;
    }


    public Map<String, QuestionHandler> getQuestionHandlers() {
        return questionHandlers;
    }



    public void setNext(QuestionHandler next) {
        this.next = next;
    }
}
