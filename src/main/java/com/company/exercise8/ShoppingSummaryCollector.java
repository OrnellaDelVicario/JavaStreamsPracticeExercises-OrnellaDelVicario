package com.company.exercise8;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

public class ShoppingSummaryCollector {

    public static Collector<Item, ShoppingSummary, ShoppingSummary> toShoppingSummary() {
        return Collector.of(
                ShoppingSummary::new,              // supplier
                ShoppingSummary::addItem,          // accumulator
                (s1, s2) -> {                      // combiner
                    s1.combine(s2);
                    return s1;
                },
                Characteristics.UNORDERED          // no depende del orden
        );
    }
}
