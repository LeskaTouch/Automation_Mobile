import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
MainClass main = new MainClass ();

    @Test
    public void testGetClassString () {
        String result = main.getClassString ();
        Assert.assertTrue( "No Hello substring",result.contains("hello")||result.contains("Hello") );
    }

}
