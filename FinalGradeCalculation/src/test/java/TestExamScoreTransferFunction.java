import org.junit.Assert;
import org.testng.annotations.Test;

public class TestExamScoreTransferFunction {

    @Test
    public void testLessThanZeroMark() {
        var actualMark = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualMark);
    }

    @Test
    public void testZeroMark() {
        var actualMark = getMarkResult(0);
        Assert.assertEquals("2", actualMark);
    }

    @Test
    public void testOverAHundredPoints() {
        var actualMark = getMarkResult(101);
        Assert.assertEquals("no mark result", actualMark);
    }

    @Test
    public void testMaxScoresForGradeTwo() {
        var actualMark = getMarkResult(35);
        Assert.assertEquals("2", actualMark);
    }

    @Test
    public void testMinScoresForGradeThree() {
        var actualMark = getMarkResult(36);
        Assert.assertEquals("3", actualMark);
    }

    @Test
    public void testMaxScoresForGradeThree() {
        var actualMark = getMarkResult(56);
        Assert.assertEquals("3", actualMark);
    }

    @Test
    public void testMinScoresForGradeFour() {
        var actualMark = getMarkResult(57);
        Assert.assertEquals("4", actualMark);
    }

    @Test
    public void testMaxScoresForGradeFour() {
        var actualMark = getMarkResult(71);
        Assert.assertEquals("4", actualMark);
    }

    @Test
    public void testMinScoresForGradeFive() {
        var actualMark = getMarkResult(72);
        Assert.assertEquals("5", actualMark);
    }

    @Test
    public void testMaxScoresForGradeFive() {
        var actualMark = getMarkResult(100);
        Assert.assertEquals("5", actualMark);
    }

    private String getMarkResult(Integer mark) {

        if(mark>=0 && mark <=35) return "2";

        if(mark>35 && mark <=56) return "3";

        if(mark>56 && mark<71) return "4";

        if(mark>72 && mark<100) return "5";

        return "no mark result";

    }
}
