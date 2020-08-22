package com.sapient.pjp2.nlp;

import com.sapient.pjp2.utils.DateUtil;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.BiFunction;

public interface NLPCommands {
    Map<String, BiFunction<LocalDate, Integer, String>> commands = Map.ofEntries(
            Map.entry("today", (LocalDate date, Integer n) -> DateUtil.parseDate(date)),
            Map.entry("tomorrow", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusDays(1))),
            Map.entry("yesterday", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusDays(1))),
            Map.entry("day after tomorrow", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusDays(2))),
            Map.entry("day before yesterday", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusDays(2))),
            Map.entry("last week", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusWeeks(1))),
            Map.entry("previous week", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusWeeks(1))),
            Map.entry("last month", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusMonths(1))),
            Map.entry("last year", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusYears(1))),
            Map.entry("month after", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusMonths(1))),
            Map.entry("next month", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusMonths(1))),
            Map.entry("next week", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusWeeks(1))),
            Map.entry("next year", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusYears(1))),
            Map.entry("month before", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusMonths(1))),
            Map.entry("weeks from now", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusWeeks(n))),
            Map.entry("days from now", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusDays(n))),
            Map.entry("months from now", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusMonths(n))),
            Map.entry("years from now", (LocalDate date, Integer n) -> DateUtil.parseDate(date.plusYears(n))),
            Map.entry("weeks earlier", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusWeeks(n))),
            Map.entry("days earlier", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusDays(n))),
            Map.entry("months earlier", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusMonths(n))),
            Map.entry("years earlier", (LocalDate date, Integer n) -> DateUtil.parseDate(date.minusYears(n)))
    );
}
