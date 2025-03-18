# MovieTree - A Binary Search Tree for Managing Movies

## Introduction

**MovieTree** is a Java-based implementation of a **Movie Catalog** using a **Binary Search Tree (BST)**. This project allows efficient storage, retrieval, and manipulation of movie records based on their **year**, **rating**, and **name**. The system provides functionalities for adding movies, searching for specific movies, retrieving the best-rated movie, and more.

## Working Principle

The `MovieTree` class implements a **BST** where each node stores a `Movie` object. The BST ensures that:
- Movies are ordered by **year** first.
- If the year is the same, movies are ordered by **rating**.
- If both year and rating are the same, movies are ordered **lexicographically** by name.

### Key Design Considerations:

1. **Data Storage:**
   - Uses a **binary search tree (BST)** structure, where each node (`BSTNode<Movie>`) contains a `Movie` object.
   - The root node starts as `null` when the tree is empty.
   - Movies are inserted following the BST rules.

2. **Movie Comparison:**
   - Defined in `Movie` class using `Comparable<Movie>`.
   - **Priority order:** Year → Rating → Name.

3. **Key Operations:**
   - **Insertion (`addMovie`)**: Adds movies while maintaining BST properties.
   - **Search (`contains`)**: Finds a movie by its attributes.
   - **Best Movie (`getBestMovie`)**: Retrieves the highest-rated movie.
   - **Tree Height (`height`)**: Determines the depth of the BST.
   - **Lookup (`lookup`)**: Finds all movies from a given year with at least a given rating.
   - **String Representation (`toString`)**: Prints all movies in sorted order.

---

## Private Parameters

- **BSTNode<Movie> root**: Root node of the binary search tree.
- **int size**: The number of movies in the BST.

---

## Constructors

### `MovieTree()`: Default Constructor
Creates an empty `MovieTree`.

```java
MovieTree movieCatalog = new MovieTree();
System.out.println(movieCatalog.size());  // Output: 0
```

---

## Core Methods

### `boolean addMovie(Movie newMovie)`
Adds a new movie to the BST.

- Returns **true** if successfully added.
- Returns **false** if the movie already exists.

```java
MovieTree tree = new MovieTree();
Movie movie1 = new Movie(2010, 8.5, "Inception");
tree.addMovie(movie1);  // Returns: true
tree.addMovie(movie1);  // Returns: false (duplicate)
```

### `boolean contains(int year, double rating, String name)`
Checks if the BST contains a movie with the given attributes.

```java
System.out.println(tree.contains(2010, 8.5, "Inception"));  // Output: true
System.out.println(tree.contains(2022, 9.0, "Unknown"));    // Output: false
```

### `Movie getBestMovie()`
Retrieves the **highest-rated** movie in the BST.

```java
Movie bestMovie = tree.getBestMovie();
System.out.println(bestMovie);  // Output: [(Year: 2010) (Rate: 8.5) (Name: Inception)]
```

### `ArrayList<Movie> lookup(int year, double rating)`
Finds all movies from a specific **year** with at least the given **rating**.

```java
ArrayList<Movie> results = tree.lookup(2010, 8.0);
System.out.println(results);
```

### `int height()`
Computes the height (depth) of the BST.

```java
System.out.println(tree.height());  // Output: 1
```

### `String toString()`
Prints all movies in **sorted order**.

```java
System.out.println(tree.toString());
```

---

## Testing

The project includes a `MovieTreeTester` class that performs unit tests on key functionalities:

### `testAddMovieToStringSize()`
- Ensures movies are correctly added and displayed in order.

### `testContains()`
- Checks if the tree correctly finds existing movies.

### `testHeight()`
- Validates that the tree height is computed correctly.

### `testGetBestMovie()`
- Confirms that the best-rated movie is returned.

### `testLookup()`
- Ensures lookup functionality works as expected.

To run the tests, compile and execute `MovieTreeTester.java`:

```sh
javac MovieTreeTester.java
java MovieTreeTester
```

Expected output:
```sh
true
```

---

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        MovieTree movieTree = new MovieTree();

        movieTree.addMovie(new Movie(1994, 9.3, "The Shawshank Redemption"));
        movieTree.addMovie(new Movie(2008, 9.0, "The Dark Knight"));
        movieTree.addMovie(new Movie(1994, 8.9, "Pulp Fiction"));

        System.out.println("MovieTree Size: " + movieTree.size());
        System.out.println("Best Movie: " + movieTree.getBestMovie());
        System.out.println("Contains 'The Dark Knight'? " + movieTree.contains(2008, 9.0, "The Dark Knight"));
        System.out.println("Tree Height: " + movieTree.height());
        System.out.println("All Movies:\n" + movieTree);
    }
}
```

Expected Output:
```sh
MovieTree Size: 3
Best Movie: [(Year: 2008) (Rate: 9.0) (Name: The Dark Knight)]
Contains 'The Dark Knight'? true
Tree Height: 2
All Movies:
[(Year: 1994) (Rate: 8.9) (Name: Pulp Fiction)]
[(Year: 1994) (Rate: 9.3) (Name: The Shawshank Redemption)]
[(Year: 2008) (Rate: 9.0) (Name: The Dark Knight)]
```

---

## Compilation & Execution

1. **Compile all files:**
   ```sh
   javac *.java
   ```

2. **Run the program:**
   ```sh
   java Main
   ```

3. **Run the unit tests:**
   ```sh
   java MovieTreeTester
   ```

---

## Summary

This project implements a **Binary Search Tree (BST)** to efficiently manage a movie catalog. The tree structure allows:
- **Fast insertion & lookup** of movies.
- **Efficient searching** based on **year** and **rating**.
- **Retrieving the highest-rated movie**.
- **Maintaining an ordered list** of movies.

This implementation is useful for **movie databases**, **recommendation systems**, and **entertainment applications** where structured movie data needs to be managed efficiently.
