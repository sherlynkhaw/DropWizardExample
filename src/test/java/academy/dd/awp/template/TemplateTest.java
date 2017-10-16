package academy.dd.awp.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TemplateTest {

    @Test(expected = IllegalArgumentException.class)
    public void templateConstructorTest()
    {
        new Template();
    }

    @Test
    public void templateExceptionMessage()
    {
        try {
            new Template();
        }
        catch (IllegalArgumentException e){
            assertThat("Should throw an exception", e.getMessage(),is("This should throw an exception"));
        }
    }

}
