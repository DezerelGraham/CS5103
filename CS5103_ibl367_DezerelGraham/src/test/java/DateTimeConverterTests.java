import com.cs5103.DateTimeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateTimeConverterTests {
    DateTimeConverter dateTimeConverter;
    String time;
    String targetZone;
    String dayLightStartTime;
    String dayLightEndTime;

    @BeforeEach
    void setUp() {
        dateTimeConverter = new DateTimeConverter();
        time = "2021-05-04 05:02:02";
        targetZone = "PST";
        dayLightStartTime = "2021-04-04 02:02:02";
        dayLightEndTime = "2021-09-04 02:02:02";
    }

    @Test
    void convertTimeHappyPath() {
        String convertedTime = dateTimeConverter.convertTime(time, targetZone, dayLightStartTime, dayLightEndTime);
        Assertions.assertEquals("2021-05-04 TUESDAY 04:02:02", convertedTime);
    }
}
