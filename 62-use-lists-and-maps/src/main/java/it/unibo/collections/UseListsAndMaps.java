package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> array = new ArrayList<>();

        for (int i = 1000; i < 2000; i++) {
            array.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linked = new LinkedList<>();

        linked.addAll(array);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int firstItem =  array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.set(array.size() - 1, firstItem);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int element: array) {
            System.out.println(Integer.toString(element));
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            array.add(0, i);
        }

        time = System.nanoTime() - time;

        System.out.println("Tempo per eseguire le operazioni di scrittura su ArrayList: " + String.valueOf(time) + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");

        time = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linked.add(0, i);
        }

        time = System.nanoTime() - time;

        System.out.println("Tempo per eseguire le operazioni di scrittura su LinkedList: " + String.valueOf(time) + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            array.get(Math.floorDiv(array.size(), 2));
        }

        time = System.nanoTime() - time;

        System.out.println("Tempo per eseguire le operazioni di lettura su ArrayList: " + String.valueOf(time) + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");

        time = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linked.get(Math.floorDiv(linked.size(), 2));
        }

        time = System.nanoTime() - time;

        System.out.println("Tempo per eseguire le operazioni di lettura su LinkedList: " + String.valueOf(time) + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> population = new HashMap<>();

        population.put("Africa", Long.parseLong("1110635000"));
        population.put("Americas", Long.parseLong("972005000"));
        population.put("Antarctica", Long.parseLong("0"));
        population.put("Asia", Long.parseLong("4298723000"));
        population.put("Europe", Long.parseLong("742452000"));
        population.put("Oceania", Long.parseLong("38304000"));
        
        /*
         * 8) Compute the population of the world
         */
        long totalPopulation = 0;
        for (long element: population.values()) {
            totalPopulation += element;
        }

        System.out.println("The total population of the world is: " + String.valueOf(totalPopulation));
    }
}
