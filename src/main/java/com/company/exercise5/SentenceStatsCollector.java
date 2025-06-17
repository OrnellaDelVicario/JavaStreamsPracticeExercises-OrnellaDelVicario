package com.company.exercise5;

import java.util.stream.Collector;

public class SentenceStatsCollector {

    public static Collector<String, SentenceStats, SentenceStats> toSentenceStats() {
        return Collector.of(
                    SentenceStats::new,                         // supplier
                    SentenceStats::addSentence,                 // accumulator
                    (s1, s2) -> { s1.combine(s2); return s1; }, // combiner
                    s -> s                                      // finisher
            );
        }
    }
