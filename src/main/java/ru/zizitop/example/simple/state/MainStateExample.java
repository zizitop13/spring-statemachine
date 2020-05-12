package ru.zizitop.example.simple.state;

public class MainStateExample {


    public static void main(String[] args) {
        MessageState initialState = new NewMessage();
        MessageStateContext stateContext = new MessageStateContext(initialState);

        stateContext.sendMessage();
        System.out.println(stateContext.getState().getName());
        stateContext.receiveAnswer();
        System.out.println(stateContext.getState().getName());
        stateContext.error();
        System.out.println(stateContext.getState().getName());
        stateContext.sendMessage();
        System.out.println(stateContext.getState().getName());
        stateContext.receiveAnswer();
        System.out.println(stateContext.getState().getName());
    }
}
