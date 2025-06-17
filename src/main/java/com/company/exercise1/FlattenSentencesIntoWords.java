package com.company.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* ✅ What does the code do?
      sentences.stream(): Converts the list of sentences into a stream.
      flatMap(...): Splits each sentence into words and flattens everything into a single stream of words.
      collect(Collectors.toList()): Converts the stream of words into a list.
 */

public class FlattenSentencesIntoWords {

    public static List<String> flattenSentences(List<String> sentences) {
        return sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<String> sentences = List.of("Java is fun", "Streams are powerful");
        List<String> words = flattenSentences(sentences);
        System.out.println(words); // Output: [Java, is, fun, Streams, are, powerful]
    }
}
