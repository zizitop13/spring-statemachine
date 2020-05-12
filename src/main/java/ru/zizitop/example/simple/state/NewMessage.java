package ru.zizitop.example.simple.state;

public class NewMessage implements MessageState {


    public String getName() {
        return "new";
    }

    public void sendMessage(MessageStateContext stateContext) {
        stateContext.setState(new SentMessage());
    }

    public void receiveAnswer(MessageStateContext stateContext) {
        stateContext.setState(new ReceivedAnswer());
    }

    public void error(MessageStateContext stateContext) {
        stateContext.setState(new ErrorState());
    }
}
