package ru.zizitop.example.spring.service;


import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import ru.zizitop.example.spring.statemachine.event.MessageEvent;
import ru.zizitop.example.spring.statemachine.state.MessageState;
import ru.zizitop.example.spring.web.model.SimpleMessage;

import static ru.zizitop.example.spring.statemachine.event.MessageEvent.Receive;
import static ru.zizitop.example.spring.statemachine.event.MessageEvent.Send;

@Service
@SuppressWarnings("all")
public class SimpleMessageService implements MessageService{



    private final StateMachineFactory<MessageState, MessageEvent> stateMachineFactory;
    private final StateMachinePersister persister;


    public SimpleMessageService(StateMachineFactory<MessageState, MessageEvent> stateMachineFactory, StateMachinePersister persister){
        this.stateMachineFactory = stateMachineFactory;
        this.persister = persister;
    }


    public boolean request(String id, String payload) {
        final StateMachine<MessageState, MessageEvent> stateMachine = stateMachineFactory.getStateMachine();

        SimpleMessage simpleMessage = new SimpleMessage(id, payload);

        stateMachine
                .getExtendedState()
                .getVariables()
                .put("MESSAGE", simpleMessage);

        stateMachine
                .sendEvent(Send);

        try {
            persister.persist(stateMachine, id);
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean isAnswered(String id) {
        final StateMachine<MessageState, MessageEvent> stateMachine = stateMachineFactory.getStateMachine();
        boolean complete = false;
        try {
            persister.restore(stateMachine, id);
            complete = stateMachine.isComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complete;
    }

    public boolean response(String requestId, String payload) {
        final StateMachine<MessageState, MessageEvent> stateMachine = stateMachineFactory.getStateMachine();
        try {
            persister.restore(stateMachine, requestId);
            stateMachine.sendEvent(Receive);
            persister.persist(stateMachine, requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




}
