package com.sapient.pjp2.dtcspringmvc.controller;

import com.sapient.pjp2.dtcspringmvc.service.CalculatorService;
import com.sapient.pjp2.session.DateTimeOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String result(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public String result(@RequestParam(value = "option", defaultValue = "0") Integer option,
                         @RequestParam(value = "expression", required = false) String expression,
                         @RequestParam(value = "date", required = false) String date,
                         @RequestParam(value = "date1", required = false) String date1,
                         @RequestParam(value = "date2", required = false) String date2,
                         @RequestParam(value = "increment", required = false) String increment,
                         ModelMap model) {
        try {
            List<String> inputList = List.of(expression, date, date1, date2, increment)
                    .stream()
                    .filter(x -> x != null && !x.isBlank())
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.println(inputList);
            String[] inputs = new String[inputList.size()];
            inputList.toArray(inputs);
            String result = this.calculatorService.execute(option, inputs);
            if (result == null) throw new Exception();
            DateTimeOperation dateTimeOperation =
                    this.calculatorService
                            .getCalculator()
                            .getSession()
                            .lastOperation();
            model.put("result", dateTimeOperation);
        } catch (Exception e) {
            model.put("errorMessage", "Invalid operation.");
            return "index";
        }
        return "result";
    }

}
