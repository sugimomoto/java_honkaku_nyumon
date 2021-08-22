package chapter_3_3_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

    @Test
    public void PointHashCodeCheck(){
        Point point = new Point(1,2);
        Point pointSame = new Point(1,2);
        Point pointDiffX = new Point(2, 2);
        Point pointDiffY = new Point(1, 3);

        assertEquals(point.hashCode(), pointSame.hashCode());
        assertNotEquals(point.hashCode(), pointDiffX.hashCode());
        assertNotEquals(point.hashCode(), pointDiffY.hashCode());
    }

    @Test
    public void PointEqualsMethodCheck(){
        Point point = new Point(1,2);
        Point pointSame = new Point(1,2);
        Point pointDiffX = new Point(2, 2);
        Point pointDiffY = new Point(1, 3);
        Point pointSameObj = point;

        assertTrue(point.equals(pointSame));
        assertTrue(point.equals(pointSameObj));

        assertFalse(point.equals(pointDiffX));
        assertFalse(point.equals(pointDiffY));
    }

    @Test
    public void PointToStringCheck(){
        Point point = new Point(1, 2);

        assertEquals("Point [x=1,y=2]", point.toString());
    }
    
}
