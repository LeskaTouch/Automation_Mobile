import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass main = new MainClass();

    @Test
    public void testGetClassNumber() {
        int result = main.getClassNumber();

        Assert.assertTrue("Classnumber is less than 45", result > 45);
    }

}
