import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeDemo {

    public static void main(String args[]) {

        //current system date
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //Current system time (hr:min:seconds.nanoseconds)
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //from the date, get the day, month and the year value separately
        int dd = date.getDayOfMonth();
        int dd1 = date.getDayOfYear();

        int mm = date.getMonthValue();
        int yyyy = date.getYear();

        System.out.println(dd+"..."+mm+"..."+yyyy);
        System.out.printf("%d-%d-%d", dd, mm, yyyy);

        System.out.println();

        //from the time, get the hr, min,second or nanosecond values separately
        int h = time.getHour();
        int min = time.getMinute();
        int sec = time.getSecond();
        int nano = time.getNano();

        System.out.printf("%d:%d:%d:%d", h, min, sec, nano);

        //Represent both date time simultaneously
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        //Whatever methods we called on LocalDate object can be called on LocalDateTime object, if we want to represent each component of the date and time separately.
        int dddt = dt.getDayOfMonth();
        int mmdt = dt.getMonthValue();
        int yyyydt = dt.getYear();
        System.out.printf("%d-%d-%d", dddt, mmdt, yyyydt);

        int hh = dt.getHour();
        int mindt = dt.getMinute();
        int secdt = dt.getSecond();
        int nanodt = dt.getNano();
        System.out.printf("\n%d:%d:%d:%d", hh, mindt, secdt, nanodt);

        //Representing a particular date and time
        LocalDateTime dateTime = LocalDateTime.of(1995, 5, 28, 12, 45);
        LocalDateTime dateTime1 = LocalDateTime.of(1994, Month.OCTOBER, 20, 3, 45);

        System.out.println(dateTime);
        System.out.println(dateTime1);

        //LocalDateTime class has multiple methods to find the date and time of the day after a certain period.
        System.out.println("After 6 months : "+dt.plusMonths(6));
        System.out.println("Before 6 months : "+dt.minusMonths(6));



    }





}
