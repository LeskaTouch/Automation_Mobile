import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass main = new MainClass();

    @Test
    public void testGetLocalNumber() {
        int result = main.getLocalNumber();

        Assert.assertEquals("Local number does not equal 14",14, result);
    }

}
