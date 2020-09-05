package com.sapient.pjp2.dtcrestapi.controller;

import com.sapient.pjp2.dtcrestapi.model.OperationInputs;
import com.sapient.pjp2.dtcrestapi.service.CalculatorService;
import com.sapient.pjp2.session.DateTimeOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class OperationsController {

    @Autowired
    private CalculatorService calculatorService;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/operate/{option}")
    public DateTimeOperation executeOperation(@PathVariable Integer option,
                                              @RequestBody OperationInputs inputs) {
        String result = this.calculatorService.execute(option, inputs.getInputs());
        System.out.println("Result: " + result);
        return this.calculatorService.getCalculator().getSession().lastOperation();
    }
}
