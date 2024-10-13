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
        // Manually create the instance and inject any necessary dependencies
        requestService = new RequestServiceImpl(/* inject dependencies here if needed */);
    }

    @Test
    public void testCalculerMensualite() {
        Long capital = 100000L;
        Long dureeEnMois = 24L;
        double expectedMensualite = 4707.94;

        double result = requestService.calculerMensualite(capital, dureeEnMois);

        assertEquals(expectedMensualite, result, 0.01, "Le montant mensuel calculé est incorrect");
    }
}
