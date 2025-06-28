package com.example.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Use in service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert
        assertEquals("Mock Data", result);
    }
}
