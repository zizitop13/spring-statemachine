package ru.zizitop.example.simple.state;



public class ErrorState implements MessageState {


    public String getName() {
        return "error";
    }

    public void sendMessage(MessageStateContext stateContext) {
        stateContext.setState(new ResentMessage());
    }

    public void receiveAnswer(MessageStateContext stateContext) {
        stateContext.setState(new ReceivedAnswer());
    }

    public void error(MessageStateContext stateContext) {
        stateContext.setState(new ErrorState());
    }
}
