import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {
    private AikidoTracker tracker = new AikidoTracker();

    @BeforeEach
    void setUp() {
    }


    @Test
    void addSession() {
        tracker.addSession("2025-02-01", 90);
        assertEquals(90, tracker.viewTotalTime());
    }

    @Test
    void viewTotalTime() {
        tracker.addSession("2025-02-01", 90);
        tracker.addSession("2025-02-02", 90);
        assertEquals(180, tracker.viewTotalTime());
    }

    @Test
    void checkGraduationEligibility() {
        tracker.addSession("2025-02-01", 90);
        tracker.addSession("2025-02-02", 90);
        tracker.checkGraduationEligibility();
        tracker.addSession("2025-02-03", 90);
        tracker.checkGraduationEligibility();
    }
}