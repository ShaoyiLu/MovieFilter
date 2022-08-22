//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 Movie Catalog
// Course: CS 300 Summer 2022
//
// Author: Shaoyi Lu
// Email: slu248@wisc.edu
// Lecturer: Michelle Jensen
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Zhimin Hu
// Partner Email: hu436@wisc.edu
// Partner Lecturer's Name: Michelle Jensen
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 * @author Shaoyi Lu
 */

public class MovieTreeTester {

    /**
     * Checks the correctness of the implementation of both addMovie() and toString() methods
     * implemented in the MovieTree class. This unit test considers at least the following scenarios.
     * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
     * string representation is an empty string "". (2) try adding one movie and then check that the
     * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
     * called on the tree returns the expected output. (3) Try adding another movie which is smaller
     * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
     * root, (5) Try adding at least two further movies such that one must be added at the left
     * subtree, and the other at the right subtree. For all the above scenarios, and more, double
     * check each time that size() method returns the expected value, the add method call returns
     * true, and that the .toString() method returns the expected string representation of the
     * contents of the binary search tree in an increasing order from the smallest to the greatest
     * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
     * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
     * did not change.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddMovieToStringSize() {
        // part (1)
        MovieTree tree = new MovieTree();
        if (tree.size() != 0) {
            return false;
        }
        if (!tree.isEmpty()) {
            return false;
        }
        String emptyString = "";
        if (!tree.toString().equals(emptyString)) {
            return false;
        }

        // part (2)
        Movie movie1 = new Movie(1988, 9.5, "Best");
        Movie movie2 = new Movie(2015, 8.5, "Grand Parents");
        Movie movie3 = new Movie(2017, 5.5, "Dogs");
        Movie movie4 = new Movie(2018, 6.0, "Flights");
        Movie movie5 = new Movie(2018, 6.0, "Yes");
        Movie movie6 = new Movie(2018, 6.5, "Airplanes");
        Movie movie7 = new Movie(2018, 7.5, "Earth");
        Movie movie8 = new Movie(2018, 8.5, "Cats");

        if (!tree.addMovie(movie1)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 1) {
            return false;
        }
        String oneString = "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n";
        if (!tree.toString().equals(oneString)) {
            return false;
        }

        // part (3)
        if (!tree.addMovie(movie5)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 2) {
            return false;
        }
        String twoString =
                "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n" + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n";
        if (!tree.toString().equals(twoString)) {
            return false;
        }

        // part (4)
        if (!tree.addMovie(movie6)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 3) {
            return false;
        }
        String threeString =
                "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n" + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n"
                        + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
        if (!tree.toString().equals(threeString)) {
            return false;
        }

        // part (5)
        if (!tree.addMovie(movie3)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 4) {
            return false;
        }
        String fourString = "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n"
                + "[(Year: 2017) (Rate: 5.5) (Name: Dogs)]\n" + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n"
                + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
        if (!tree.toString().equals(fourString)) {
            return false;
        }
        // add right subtree
        if (!tree.addMovie(movie4)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 5) {
            return false;
        }
        String fiveString =
                "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n" + "[(Year: 2017) (Rate: 5.5) (Name: Dogs)]\n"
                        + "[(Year: 2018) (Rate: 6.0) (Name: Flights)]\n"
                        + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n"
                        + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
        if (!tree.toString().equals(fiveString)) {
            return false;
        }
        // add left subtree
        if (!tree.addMovie(movie2)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 6) {
            return false;
        }
        String sixString = "[(Year: 1988) (Rate: 9.5) (Name: Best)]\n"
                + "[(Year: 2015) (Rate: 8.5) (Name: Grand Parents)]\n"
                + "[(Year: 2017) (Rate: 5.5) (Name: Dogs)]\n"
                + "[(Year: 2018) (Rate: 6.0) (Name: Flights)]\n"
                + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n"
                + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n";
        if (!tree.toString().equals(sixString)) {
            return false;
        }

        // part (6)
        if (tree.addMovie(movie3)) {
            return false;
        }
        if (tree.isEmpty()) {
            return false;
        }
        if (tree.size() != 6) {
            return false;
        }
        if (!tree.toString().equals(sixString)) {
            return false;
        }

        return true;
    }

    /**
     * This method checks mainly for the correctness of the MovieTree.contains() method. It must
     * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
     * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
     * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
     * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
     * left subtrees at different levels considering successful and unsuccessful search operations.
     * Make sure that the contains() method returns the expected output for every method call.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testContains() {
        // part (1)
        MovieTree tree = new MovieTree();
        if (tree.contains(1988, 9.5, "Best")) {
            return false;
        }

        // part (2)
        Movie movie1 = new Movie(1988, 9.5, "Best");
        Movie movie2 = new Movie(2015, 8.5, "Grand Parents");
        Movie movie3 = new Movie(2017, 5.5, "Dogs");
        Movie movie4 = new Movie(2018, 6.0, "Flights");
        Movie movie5 = new Movie(2018, 6.0, "Yes");
        Movie movie6 = new Movie(2018, 6.5, "Airplanes");
        Movie movie7 = new Movie(2018, 7.5, "Earth");
        Movie movie8 = new Movie(2018, 8.5, "Cats");

        tree.addMovie(movie5);
        tree.addMovie(movie7);
        tree.addMovie(movie1);
        tree.addMovie(movie3);
        tree.addMovie(movie2);
        tree.addMovie(movie8);
        tree.addMovie(movie6);
        tree.addMovie(movie4);

        if (!tree.contains(2015, 8.5, "Grand Parents")) {
            return false;
        }

        // part (3)
        if (!tree.contains(1988, 9.5, "Best")) {
            return false;
        }
        if (!tree.contains(2017, 5.5, "Dogs")) {
            return false;
        }
        if (!tree.contains(2018, 6.0, "Flights")) {
            return false;
        }
        if (!tree.contains(2018, 6.0, "Yes")) {
            return false;
        }
        if (!tree.contains(2018, 6.5, "Airplanes")) {
            return false;
        }
        if (!tree.contains(2018, 7.5, "Earth")) {
            return false;
        }
        if (!tree.contains(2018, 8.5, "Cats")) {
            return false;
        }
        if (tree.contains(2018, 8.5, "Dats")) {
            return false;
        }

        return true;
    }

    /**
     * Checks for the correctness of MovieTree.height() method. This test must consider several
     * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
     * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
     * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
     * (*)
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testHeight() {
        // part (1)
        MovieTree tree = new MovieTree();
        if (tree.height() != 0) {
            return false;
        }

        // part (2)
        Movie movie1 = new Movie(1988, 9.5, "Best");
        Movie movie2 = new Movie(2015, 8.5, "Grand Parents");
        Movie movie3 = new Movie(2017, 5.5, "Dogs");
        Movie movie4 = new Movie(2018, 6.0, "Flights");
        Movie movie5 = new Movie(2018, 6.0, "Yes");
        Movie movie6 = new Movie(2018, 6.5, "Airplanes");
        Movie movie7 = new Movie(2018, 7.5, "Earth");
        Movie movie8 = new Movie(2018, 8.5, "Cats");

        tree.addMovie(movie5);
        if (tree.height() != 1) {
            return false;
        }

        // part (3)
        tree.addMovie(movie3);
        if (tree.height() != 2) {
            return false;
        }
        tree.addMovie(movie1);
        if (tree.height() != 3) {
            return false;
        }
        tree.addMovie(movie7);
        if (tree.height() != 3) {
            return false;
        }
        tree.addMovie(movie2);
        if (tree.height() != 4) {
            return false;
        }
        tree.addMovie(movie8);
        if (tree.height() != 4) {
            return false;
        }
        tree.addMovie(movie6);
        if (tree.height() != 4) {
            return false;
        }
        tree.addMovie(movie4);
        if (tree.height() != 4) {
            return false;
        }

        return true;
    }

    /**
     * Checks for the correctness of MovieTree.getBestMovie() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testGetBestMovie() {
        try {
            MovieTree tree = new MovieTree();
            if (tree.getBestMovie() != null) {
                return false;
            }

            Movie movie1 = new Movie(1988, 9.5, "Best");
            Movie movie2 = new Movie(2015, 8.5, "Grand Parents");
            Movie movie3 = new Movie(2017, 5.5, "Dogs");
            Movie movie4 = new Movie(2018, 6.0, "Flights");
            Movie movie5 = new Movie(2018, 6.0, "Yes");
            Movie movie6 = new Movie(2018, 6.5, "Airplanes");
            Movie movie7 = new Movie(2018, 7.5, "Earth");
            Movie movie8 = new Movie(2018, 8.5, "Cats");

            tree.addMovie(movie5);
            if (tree.getBestMovie() != movie5) {
                return false;
            }
            tree.addMovie(movie3);
            if (tree.getBestMovie() != movie5) {
                return false;
            }
            tree.addMovie(movie1);
            if (tree.getBestMovie() != movie5) {
                return false;
            }
            tree.addMovie(movie7);
            if (tree.getBestMovie() != movie7) {
                return false;
            }
            tree.addMovie(movie2);
            if (tree.getBestMovie() != movie7) {
                return false;
            }
            tree.addMovie(movie8);
            if (tree.getBestMovie() != movie8) {
                return false;
            }
            tree.addMovie(movie6);
            if (tree.getBestMovie() != movie8) {
                return false;
            }
            tree.addMovie(movie4);
            if (tree.getBestMovie() != movie8) {
                return false;
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
     * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
     * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
     * list which contains all the movies satisfying the search criteria of year and rating, when
     * called on a non empty movie tree with one match, and two matches and more. Vary your search
     * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
     * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
     * tree with no search results found.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testLookup() {
        // part (1)
        MovieTree tree = new MovieTree();
        ArrayList<Movie> array = new ArrayList<>();
        try {
            tree.lookup(2022, 10.0);
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e) {
            return false;
        }

        // part (2)
        Movie movie1 = new Movie(1988, 9.5, "Best");
        Movie movie2 = new Movie(2015, 8.5, "Grand Parents");
        Movie movie3 = new Movie(2017, 5.5, "Dogs");
        Movie movie4 = new Movie(2018, 6.0, "Flights");
        Movie movie5 = new Movie(2018, 6.0, "Yes");
        Movie movie6 = new Movie(2018, 6.5, "Airplanes");
        Movie movie7 = new Movie(2018, 7.5, "Earth");
        Movie movie8 = new Movie(2018, 8.5, "Cats");

        tree.addMovie(movie5);
        tree.addMovie(movie7);
        tree.addMovie(movie1);
        tree.addMovie(movie3);
        tree.addMovie(movie2);
        tree.addMovie(movie8);
        tree.addMovie(movie6);
        tree.addMovie(movie4);

        array = tree.lookup(2018, 6.0);
        if (!array.toString()
                .equals("[(Year: 2018) (Rate: 6.0) (Name: Flights)]\n"
                        + "[(Year: 2018) (Rate: 6.0) (Name: Yes)]\n"
                        + "[(Year: 2018) (Rate: 6.5) (Name: Airplanes)]\n"
                        + "[(Year: 2018) (Rate: 7.5) (Name: Earth)]\n"
                        + "[(Year: 2018) (Rate: 8.5) (Name: Cats)]\n")) {
            return false;
        }

        // part (3)
        try {
            tree.lookup(2018, 6.0);
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Calls the test methods
     *
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        System.out.println(testAddMovieToStringSize() && testContains() && testHeight()
                && testGetBestMovie() && testLookup());

        MovieTree tree = new MovieTree();
        tree.addMovie(new Movie(2022, 10.0, "SSS"));
        tree.addMovie(new Movie(2012, 0.0, "AAA"));
        tree.addMovie(new Movie(2000, 9.0, "OOO"));
        System.out.print(tree.lookup(2022, 10.0));

    }

}
