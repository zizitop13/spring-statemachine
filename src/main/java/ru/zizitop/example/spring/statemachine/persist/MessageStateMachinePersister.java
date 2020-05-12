package ru.zizitop.example.spring.statemachine.persist;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import ru.zizitop.example.spring.statemachine.event.MessageEvent;
import ru.zizitop.example.spring.statemachine.state.MessageState;

import java.util.HashMap;

public class MessageStateMachinePersister implements StateMachinePersist<MessageState, MessageEvent, String> {

    private final HashMap<String, StateMachineContext<MessageState, MessageEvent>> contexts = new HashMap<>();


    @Override
    public void write(StateMachineContext<MessageState, MessageEvent> stateMachineContext, String s) throws Exception {
        contexts.put(s, stateMachineContext);
    }

    @Override
    public StateMachineContext<MessageState, MessageEvent> read(String s) throws Exception {
        return contexts.get(s);
    }
}
