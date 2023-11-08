package com.tax.calculator.controller;

import com.tax.calculator.service.GothenburgTollFeeService;
import com.tax.calculator.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/toll")
public class TollFeeController {
    private final GothenburgTollFeeService tollFeeService;

    @Autowired
    public TollFeeController(GothenburgTollFeeService tollFeeService) {
        this.tollFeeService = tollFeeService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Object> calculateTollFee(@RequestBody Vehicle vehicle, @RequestBody List<LocalDateTime> times) {

        Map<String, Object> resp = new HashMap<>();
        resp.put("Total Amount", tollFeeService.calculateTollFee(vehicle, times));

        return ResponseEntity.status(HttpStatus.OK).body(resp);

        /* This is now narrowed down only to calculate Gothenburg total, for larger project we need to have more checks on
            - access token,
            - vehicle type is valid
            - catch the exceptions according to it
            - etc
         */
    }
}