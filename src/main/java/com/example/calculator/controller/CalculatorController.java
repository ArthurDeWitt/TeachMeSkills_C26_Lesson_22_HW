package com.example.calculator.controller;

import com.example.calculator.model.Calculation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @GetMapping
    public String calculator(Model model) {
        model.addAttribute("calculation", new Calculation());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculation calculation) {
        Double result = null;

        switch (calculation.getOperation()) {
            case "ADD":
                result = calculation.getFirstNumber() + calculation.getSecondNumber();
                break;
            case "SUBTRACT":
                result = calculation.getFirstNumber() - calculation.getSecondNumber();
                break;
            case "MULTIPLY":
                result = calculation.getFirstNumber() * calculation.getSecondNumber();
                break;
            case "DIVIDE":
                if (calculation.getSecondNumber() == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                result = calculation.getFirstNumber() / calculation.getSecondNumber();
                break;
            default:
                throw new IllegalStateException("Unexpected operation: " + calculation.getOperation());
        }

        calculation.setResult(result);
        return "result";
    }
}
