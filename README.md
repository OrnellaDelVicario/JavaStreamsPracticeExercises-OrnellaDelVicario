# 💡Java Streams Practice Exercises: FlatMap, Collectors, Custom Collectors
## Welcome to Practice Day! These exercises are designed to reinforce your understanding of:

flatMap()
Built-in Collectors
Custom Collector
Each exercise is small and focused, perfect for coding in a REPL or as standalone Java classes. No external libraries needed.

## 🔄 Exercise 1: Flatten Sentences into Words
### Task:
Given a List<String> where each element is a sentence, use flatMap() to extract all words into a flat List<String>.

Input:
List<String> sentences = List.of("Java is fun", "Streams are powerful");
Output:
["Java", "is", "fun", "Streams", "are", "powerful"]
✅ Concepts:
flatMap
Stream.of().split(" ")
## 📦 Exercise 2: Group Products by Category
### Task:
Given a List<Product> with fields name, category, and price, group them by category.

✅ Concepts:
Collectors.groupingBy()
Collectors.mapping() (Optional Bonus)
## 📊 Exercise 3: Count Items by Status
### Task:
Given a List<Task> with fields title and status, return a map counting tasks per status.

✅ Concepts:
groupingBy + counting()
## 🧮 Exercise 4: Average Rating by Genre
### Task:
Given a List<Movie> with fields title, genre, rating, compute average rating per genre.

✅ Concepts:
groupingBy + averagingDouble()
## 🔀 Exercise 5: Custom Collector - Sentence Stats
### Task:
Create a custom collector to process a Stream<String> of sentences and return a custom object SentenceStats that stores:

total sentence count
total word count
average words per sentence
#### 💡 Hints:
Use a class SentenceStats with int sentenceCount, int wordCount.
accumulator() should split each sentence by space and update counters.
getAverage() = wordCount / sentenceCount.
✅ Concepts:
Custom Collector
accumulator(), combiner(), finisher()
## 🛠️ Exercise 6: Flatten Author → Books → Pages
Task:
You have a list of Author, each with List<Book>, each Book has List<String> pages. Use three levels of flatMap to get a List<String> of all pages from all books by all authors.

💡 Hints:
Start with authors.stream()
Use .flatMap(author -> author.getBooks().stream())
Then .flatMap(book -> book.getPages().stream())
✅ Concepts:
Nested flatMap()
## 📅 Exercise 7: Group Events by Day of Week
### Task:
Given a List<Event> with a LocalDate field, group all events by DayOfWeek.

#### 💡 Hints:
Use event.getDate().getDayOfWeek()
Requires importing java.time.DayOfWeek
✅ Concepts:
groupingBy(event -> event.getDate().getDayOfWeek())
## 🛒 Exercise 8: Build Shopping Summary Collector
### Task:
Write a custom collector that accepts Item objects and outputs a ShoppingSummary with:

total number of items
total price
average price
#### 💡 Hints:
Use a mutable object to accumulate totals.
supplier() returns a new ShoppingSummary.
Final result can be just ShoppingSummary (no map needed).
✅ Concepts:
Custom Collector
Real-world use of accumulation logic
📈 Bonus: Department Employee Project Stats
#### Task:
Given a List<Employee> with List<Project> each with status and budget, build:

#### Count of active projects per department
Average budget of completed projects per department
#### 💡 Hints:
Use .flatMap() to access all projects
Add .filter(p -> p.getStatus().equals("active"))
Combine groupingBy() with counting() or averagingDouble()
✅ Concepts:
Combining flatMap, filter, groupingBy, averagingDouble, counting
📚 References & Resources
Baeldung: Java Collectors Guide

Nick Samoylov’s Blog: Java Streams FlatMap and Collectors

Stack Overflow: flatMap with Collectors

Java Documentation:

Stream
Collector