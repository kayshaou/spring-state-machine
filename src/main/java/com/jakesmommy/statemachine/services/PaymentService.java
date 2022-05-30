package com.jakesmommy.statemachine.services;

import com.jakesmommy.statemachine.domain.Payment;
import com.jakesmommy.statemachine.domain.PaymentEvent;
import com.jakesmommy.statemachine.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);
    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);

}
