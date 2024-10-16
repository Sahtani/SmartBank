package com.youcode.test;
import com.youcode.smartbank.dao.interfaces.RequestDaoI;
import com.youcode.smartbank.service.implementations.RequestServiceImpl;
import com.youcode.smartbank.service.interfaces.RequestServiceI;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditServiceTest {

    @Mock
    private RequestDaoI requestDao;

    @Mock
    private Validator validator;

    @InjectMocks
    private RequestServiceImpl requestService;

    @BeforeEach
    public void setup() {
        requestService = new RequestServiceImpl();
    }

    @Test
    public void testCalculerMensualite() {
        BigDecimal capital = BigDecimal.valueOf(10000);
        int dureeEnMois = 12;
        double expectedMensualite = 888.49;
        double result =requestService.calculerMensualite(capital, dureeEnMois);
        assertEquals(expectedMensualite, result, 0.01);
    }

}
