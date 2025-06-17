package com.company.exercise5;

import java.util.List;
import java.util.stream.Collector;

public class SentenceStats {
    private int sentenceCount;
    private int wordCount;

    public void addSentence(String sentence) {
        sentenceCount++;
        wordCount += sentence.split("\\s+").length;
    }

    public void combine(SentenceStats other) {
        this.sentenceCount += other.sentenceCount;
        this.wordCount += other.wordCount;
    }

    public double getAverageWordsPerSentence() {
        return sentenceCount == 0 ? 0 : (double) wordCount / sentenceCount;
    }

    @Override
    public String toString() {
        return "\nSentences: " + sentenceCount +
                "\nWords: " + wordCount +
                "\nAvg Words/Sentence: " + String.format("%.2f", getAverageWordsPerSentence());
    }

        public static void main(String[] args) {
            List<String> sentences = List.of(
                    "Java is powerful",
                    "Collectors are useful",
                    "Streams rock");

            SentenceStats stats = sentences.stream()
                    .collect(SentenceStatsCollector.toSentenceStats());

            System.out.println(sentences);
            System.out.println(stats);
        }
    }

