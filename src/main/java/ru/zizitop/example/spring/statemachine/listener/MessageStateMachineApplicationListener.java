package ru.zizitop.example.spring.statemachine.listener;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import ru.zizitop.example.spring.statemachine.event.MessageEvent;
import ru.zizitop.example.spring.statemachine.state.MessageState;

public class MessageStateMachineApplicationListener implements org.springframework.statemachine.listener.StateMachineListener<ru.zizitop.example.spring.statemachine.state.MessageState, ru.zizitop.example.spring.statemachine.event.MessageEvent> {
    @Override
    public void stateChanged(State<MessageState, MessageEvent> state, State<MessageState, MessageEvent> state1) {

    }

    @Override
    public void stateEntered(State<MessageState, MessageEvent> state) {

    }

    @Override
    public void stateExited(State<MessageState, MessageEvent> state) {

    }

    @Override
    public void eventNotAccepted(Message<MessageEvent> message) {

    }

    @Override
    public void transition(Transition<MessageState, MessageEvent> transition) {

    }

    @Override
    public void transitionStarted(Transition<MessageState, MessageEvent> transition) {

    }

    @Override
    public void transitionEnded(Transition<MessageState, MessageEvent> transition) {

    }

    @Override
    public void stateMachineStarted(StateMachine<MessageState, MessageEvent> stateMachine) {

    }

    @Override
    public void stateMachineStopped(StateMachine<MessageState, MessageEvent> stateMachine) {

    }

    @Override
    public void stateMachineError(StateMachine<MessageState, MessageEvent> stateMachine, Exception e) {

    }

    @Override
    public void extendedStateChanged(Object o, Object o1) {

    }

    @Override
    public void stateContext(StateContext<MessageState, MessageEvent> stateContext) {

    }
}
