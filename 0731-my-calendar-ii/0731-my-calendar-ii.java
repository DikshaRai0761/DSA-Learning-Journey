import java.util.*;

class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwo() {

        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        // Triple booking check
        for (int[] interval : overlaps) {

            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }

        // Create new double-booked intervals
        for (int[] interval : bookings) {

            if (start < interval[1] && end > interval[0]) {

                overlaps.add(new int[]{
                        Math.max(start, interval[0]),
                        Math.min(end, interval[1])
                });
            }
        }

        bookings.add(new int[]{start, end});

        return true;
    }
}