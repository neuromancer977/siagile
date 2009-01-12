package code.siagile.dojo.cases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class CodeReplacerTest{
    BadCodeReplacer badReplacer;
    GoodCodeReplacer goodReplacer;

    @Before
    public void setUp() {
    	badReplacer = new BadCodeReplacer();
    	goodReplacer = new GoodCodeReplacer();
    }
    @Test
    public void testTemplateLoadedProperly() {
        try {
            badReplacer.substitute("anything", new PrintWriter(new StringWriter()));
            goodReplacer.substitute("anything", new PrintWriter(new StringWriter()));
        } catch (Exception ex) {
        	fail("No exception expected, but saw:" + ex);
        }

        assertEquals(
                "xxx%CODE%yyy%ALTCODE%zzz\n",
                badReplacer.sourceTemplate);
        assertEquals(
                "xxx%CODE%yyy%ALTCODE%zzz\n",
                goodReplacer.sourceTemplate);
    }

    @Test
    public void testSubstitution() {
        StringWriter stringOut = new StringWriter();
        PrintWriter testOut = new PrintWriter (stringOut);
        String trackingId = "01234567";
        
        try {
            badReplacer.substitute(trackingId, testOut);
        } catch (IOException ex) {
            fail ("testSubstitution exception - " + ex);
        }

        assertEquals("xxx01234567yyy01234-567zzz\n", stringOut.toString());
        
        try {
            goodReplacer.substitute(trackingId, testOut);
        } catch (IOException ex) {
            fail ("testSubstitution exception - " + ex);
        }

        assertEquals("xxx01234567yyy01234-567zzz\n", stringOut.toString());
    }

}
