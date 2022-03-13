package apiTest;

import annotation.TestType;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ApiDouSteps;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TestTypeRunner.class)
public class DouApiTests {

    @Test
    @TestType(testType = "UI")
    public void testConnection() {
        assertThat(ApiDouSteps.getDouRequest().getStatusCode()).as("200 status code expected").isEqualTo(200);
    }

    @Test
    @TestType(testType = "TEST_UI")
    public void testDou() {
        assertThat(ApiDouSteps.getDouRequest().asString()).as("Gamedev should be present on the Main page").contains(
                "Gamedev");
    }

}