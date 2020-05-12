package ru.zizitop.example.spring.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import ru.zizitop.example.spring.statemachine.event.MessageEvent;
import ru.zizitop.example.spring.statemachine.state.MessageState;
import ru.zizitop.example.spring.web.model.SimpleMessage;

public class SentMessage implements Action<MessageState, MessageEvent> {
    @Override
    public void execute(StateContext<MessageState, MessageEvent> stateContext) {

        SimpleMessage message = stateContext
                .getExtendedState()
                .get("MESSAGE", SimpleMessage.class);

        System.out.println("Sent message " + message.getPayload() + " with id " + message.getId());
    }
}
