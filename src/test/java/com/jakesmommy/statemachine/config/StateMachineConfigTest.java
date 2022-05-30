package com.jakesmommy.statemachine.config;

import com.jakesmommy.statemachine.domain.PaymentEvent;
import com.jakesmommy.statemachine.domain.PaymentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

@SpringBootTest
class StateMachineConfigTest {
    @Autowired
    StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory;

    @Test
    void testNewStateMachine() {
        StateMachine<PaymentState, PaymentEvent> sm = stateMachineFactory.getStateMachine(UUID.randomUUID());

        sm.start();

        System.out.println(sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE);

        System.out.println(sm.getState().toString());

        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED);

        System.out.println(sm.getState().toString());
    }



}