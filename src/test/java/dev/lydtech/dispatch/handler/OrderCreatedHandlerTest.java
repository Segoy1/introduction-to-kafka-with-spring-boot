package dev.lydtech.dispatch.handler;

import dev.lydtech.dispatch.service.DispatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        handler.listen("payload");
        verify(dispatchService, times(1)).process("payload");
    }
}
