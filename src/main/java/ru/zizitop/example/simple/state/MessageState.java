package ru.zizitop.example.simple.state;

public interface MessageState {

     String getName();
     void sendMessage(MessageStateContext stateContext);
     void receiveAnswer(MessageStateContext stateContext);
     void error(MessageStateContext stateContext);


}
