package com.sapient.pjp2.nlp;

import java.time.LocalDate;

public class NLPHandler implements NLPCommands {

    public static String parser(LocalDate date, String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Invalid expression.");
        }
        int increment = 0;
        String[] numbers =
                expression.replaceAll("[^0-9]", " ")
                        .replaceAll(" +", " ")
                        .strip()
                        .split(" ");
        if (numbers.length > 0 && !numbers[0].isBlank()) {
            increment = Integer.parseInt(numbers[0]);
        }
        String phrase =
                expression.replaceAll("[0-9]", " ")
                        .replaceAll(" +", " ")
                        .strip()
                        .toLowerCase();


        if (commands.containsKey(phrase)) {
            return commands.get(phrase).apply(date, increment);
        }

        return "Expression currently not understood: " + expression;
    }
}
