package com.example.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Use in service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify interaction
        verify(mockApi).getData();
    }
}
