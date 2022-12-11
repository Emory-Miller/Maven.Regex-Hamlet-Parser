import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {

        String expected = hamletParser.loadFile("hamletChangedLeon");

        String actual = hamletParser.replaceHamlet("Leon", hamletText);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletParser.loadFile("hamletChangedTariq");

        String actual = hamletParser.replaceHoratio("Tariq", hamletText);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {

        int expected = 158;

        int actual = hamletParser.findHoratio(hamletText);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHamlet() {

        int expected = 472;

        int actual = hamletParser.findHamlet(hamletText);

        Assert.assertEquals(expected, actual);
    }
}