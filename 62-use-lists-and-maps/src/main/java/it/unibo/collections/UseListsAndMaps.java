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
    private final static int MIN_RANGE = 1000;
    private final static int MAX_RANGE = 2000;
    private final static int FIRST_ELEMENT = 0;
    private final static int ELEMENTS = 100_000;
    private final static int ELEMENTS_TO_READ = 1000;

    private final static long AFRICA_POPULATION = 1_110_635_000L;
    private final static long AMERICAS_POPULATION = 972_005_000L;
    private final static long ANTARTICA_POPULATION = 0L;
    private final static long ASIA_POPULATION = 4_298_723_000L;
    private final static long EUROPE_POPULATION = 742_452_000L;
    private final static long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }

    private static void printPerformanceMessage(
        final String msg,
        final long time,
        final long millis
    ) {
        IO.println(msg + " took " + time + "ns (" + millis + "ms)");
    }

    private static void measureAddingPerformance(final List<Integer> list) {
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMENTS; i++) {
            list.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        printPerformanceMessage("Insert as first operation", time, millis);
    }

    private static void measureReadingPerformance(final List<Integer> list) {
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMENTS_TO_READ; i++) {
            list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        printPerformanceMessage("Reading in the middle operation", time, millis);
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final var arrayList = new ArrayList<Integer>();
        for (int i = MIN_RANGE; i < MAX_RANGE; i++) {
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final var linkedList = new LinkedList<Integer>(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tmp = arrayList.get(FIRST_ELEMENT);
        arrayList.set(FIRST_ELEMENT, arrayList.getLast());
        arrayList.set(arrayList.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        IO.print("[ ");
        for (final var elem : arrayList) {
            IO.print(elem + " ");
        }
        IO.println("]");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        IO.println("\nArrayList adding performance:");
        measureAddingPerformance(arrayList);
        IO.println("LinkedList adding performance:");
        measureAddingPerformance(linkedList);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        IO.println("\nArrayList reading performance:");
        measureReadingPerformance(arrayList);
        IO.println("LinkedList reading performance:");
        measureReadingPerformance(linkedList);

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
        final var world = new HashMap<String, Long>();
        world.put("Africa", AFRICA_POPULATION);
        world.put("Americas", AMERICAS_POPULATION);
        world.put("Antartica", ANTARTICA_POPULATION);
        world.put("Asia", ASIA_POPULATION);
        world.put("Europe", EUROPE_POPULATION);
        world.put("Oceania", OCEANIA_POPULATION);

        /*
         * 8) Compute the population of the world
         */
        long worldPopoulation = 0;
        for (final var val : world.entrySet()) {
            worldPopoulation += val.getValue();
        }
        IO.println("\nWe're " + worldPopoulation + " in the Earth");
    }
}
