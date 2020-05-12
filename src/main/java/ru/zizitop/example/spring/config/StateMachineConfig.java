package ru.zizitop.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import ru.zizitop.example.spring.statemachine.action.SentMessage;
import ru.zizitop.example.spring.statemachine.event.MessageEvent;
import ru.zizitop.example.spring.statemachine.listener.MessageStateMachineApplicationListener;
import ru.zizitop.example.spring.statemachine.persist.MessageStateMachinePersister;
import ru.zizitop.example.spring.statemachine.state.MessageState;

import java.util.EnumSet;

import static ru.zizitop.example.spring.statemachine.event.MessageEvent.Send;
import static ru.zizitop.example.spring.statemachine.state.MessageState.Answered;
import static ru.zizitop.example.spring.statemachine.state.MessageState.Received;
import static ru.zizitop.example.spring.statemachine.state.MessageState.Sent;


@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<MessageState, MessageEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<MessageState, MessageEvent> states) throws Exception {
        states
                .withStates()
                .initial(Received)
                .end(Answered)
                .states(EnumSet.allOf(MessageState.class));
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<MessageState, MessageEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new MessageStateMachineApplicationListener());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MessageState, MessageEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(Received)
                .target(Sent)
                .event(Send)
                .action(sendMessage());
    }

    @Bean
    public StateMachinePersister<MessageState, MessageEvent, String> persister() {
        return new DefaultStateMachinePersister<>(new MessageStateMachinePersister());
    }

    @Bean
    public Action<MessageState, MessageEvent> sendMessage() {
        return new SentMessage();
    }



}
