package ru.zizitop.example.simple.state;

public class ResentMessage implements MessageState {
    public String getName() {
        return "re-sent";
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
