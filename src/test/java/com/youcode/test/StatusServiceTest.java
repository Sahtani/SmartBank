package com.youcode.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.implementations.StatusServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatusServiceTest {

    @Mock
    private StatusDaoI statusDaoI;
@InjectMocks
    private StatusServiceImpl statusService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        Status status = new Status();
        status.setStatus("pending");

        when(statusDaoI.save(status)).thenReturn(status);

        Status savedStatus = statusService.save(status);

        assertEquals("pending", savedStatus.getStatus());
        verify(statusDaoI, times(1)).save(status);
    }
}