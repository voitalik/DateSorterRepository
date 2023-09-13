package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * Implement in single class.
 */
public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Comparator<LocalDate> comparator = (firstDate, secondDate) -> {
            boolean firstMonthWithR = firstDate.getMonth().toString().toLowerCase().contains("r");
            boolean secondMonthWithR = secondDate.getMonth().toString().toLowerCase().contains("r");
            if (firstMonthWithR && ! secondMonthWithR) {
                return - 1;
            } else if (! firstMonthWithR && ! secondMonthWithR) {
                return secondDate.compareTo(firstDate);
            } else if (firstMonthWithR){
                return firstDate.compareTo(secondDate);
            } else {
                return 1;
            }
        };

        return new ArrayList<>(unsortedDates)
                .stream()
                .sorted(comparator).toList();
    }

    public static void main(String[] args) {
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> unsortedDates = List.of(LocalDate.parse("2005-07-01")
                , LocalDate.parse("2005-01-02")
                , LocalDate.parse("2005-09-30")
                , LocalDate.parse("2005-01-01")
                , LocalDate.parse("2005-05-03")
                , LocalDate.parse("2005-08-26")
                , LocalDate.parse("2005-09-26")
                , LocalDate.parse("2004-04-02")
                , LocalDate.parse("2004-07-02")
                , LocalDate.parse("2003-09-02")
                , LocalDate.parse("2006-05-19")
                , LocalDate.parse("2003-05-02")
                , LocalDate.parse("2003-05-10")
                , LocalDate.parse("2006-04-15")
                , LocalDate.parse("2003-08-10"));
        System.out.println(dateSorter.sortDates(unsortedDates));
    }
}
