package dev.lydtech.dispatch.handler;

import dev.lydtech.dispatch.message.OrderCreated;
import dev.lydtech.dispatch.service.DispatchService;
import dev.lydtech.dispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class OrderCreatedHandlerTest {


    private OrderCreatedHandler handler;
    private DispatchService dispatchService;


    @BeforeEach
    void setUp() {
        dispatchService = mock(DispatchService.class);
        handler = new OrderCreatedHandler(dispatchService);
    }

    @Test
    void listen() {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(), randomUUID().toString());
        handler.listen(testEvent);
        verify(dispatchService, times(1)).process(testEvent);
    }
}
