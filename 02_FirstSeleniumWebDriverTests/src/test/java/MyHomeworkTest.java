import org.junit.Assert;
import org.junit.Test;

public class MyHomeworkTest {

    @Test
    public void testConcertCancelled() {
        var actualResult = getRefundTicketPricePercent(0, true, false);
        Assert.assertEquals("100", actualResult);
    }

    @Test
    public void testConcertRescheduled() {
        var actualResult = getRefundTicketPricePercent(0, false, true);
        Assert.assertEquals("100", actualResult);
    }

    @Test
    public void testConcertCancelledConcertRescheduled() {
        var actualResult = getRefundTicketPricePercent(0, true, true);
        Assert.assertEquals("100", actualResult);
    }

    @Test
    public void testReturnOver10Days() {
        var actualResult = getRefundTicketPricePercent(264, false, false);
        Assert.assertEquals("100", actualResult);
    }

    @Test
    public void testReturn10Days() {
        var actualResult = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals("100", actualResult);
    }

    @Test
    public void testReturn6Days() {
        var actualResult = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals("50", actualResult);
    }

    @Test
    public void testReturn5Days() {
        var actualResult = getRefundTicketPricePercent(120, false, false);
        Assert.assertEquals("30", actualResult);
    }

    @Test
    public void testReturn3Days() {
        var actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals("30", actualResult);
    }

    @Test
    public void testReturnLessThan3Days() {
        var actualResult = getRefundTicketPricePercent(60, false, false);
        Assert.assertEquals("0", actualResult);
    }

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия,
    посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }


}
