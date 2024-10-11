package com.youcode.smartbank;

import com.youcode.smartbank.dao.implementations.StatusDaoImpl;
import com.youcode.smartbank.dao.interfaces.StatusDaoI;
import com.youcode.smartbank.entities.Status;
import com.youcode.smartbank.service.implementations.StatusServiceImpl;
import com.youcode.smartbank.service.interfaces.StatusServiceI;

public class MainTest {
    public static void main(String[] args) {
        StatusDaoI statusDao = new StatusDaoImpl();
        StatusServiceI statusService = new StatusServiceImpl(statusDao);

        Status newStatus = new Status();
        newStatus.setId(1L);
        newStatus.setStatus("pending ");

        Status savedStatus = statusService.save(newStatus);
        System.out.println("Saved Status: " + savedStatus);
    }
}
