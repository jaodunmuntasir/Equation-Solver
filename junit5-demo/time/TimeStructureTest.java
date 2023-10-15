package time;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class TimeStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("time.Time")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldHour() {
        it.hasField("hour", ofType("int"))
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER, SETTER);
    }

    @Test
    public void fieldMin() {
        it.hasField("min", ofType("int"))
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructorWithParams("int", "int")
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGetEarlier() {
        it.hasMethod("getEarlier", withParams("Time"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("Time");
    }
}

