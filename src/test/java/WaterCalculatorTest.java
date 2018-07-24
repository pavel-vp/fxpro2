import org.junit.Assert;
import org.junit.Test;

public class WaterCalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void null_test() {
        int[] arr = null;
        WaterCalculator.calculateWaterAmount(arr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agr_0_test() {
        int[] arr = new int[] {};
        WaterCalculator.calculateWaterAmount(arr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arg_2_test() {
        int[] arr = new int[] {1,1};
        WaterCalculator.calculateWaterAmount(arr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arg_minus_test() {
        int[] arr = new int[] {-1,1};
        WaterCalculator.calculateWaterAmount(arr);
    }

    @Test
    public void good_pit_1_test() {
        int[] arr = new int[] {3,1,3};
        long result = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertEquals(2, result);
    }

    @Test
    public void good_pit_2_test() {
        int[] arr = new int[] {3,1,3,1,3};
        long result = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertEquals(4, result);
    }

    @Test
    public void good_pit_1_deep_test() {
        int[] arr = new int[] {32000,0,32000};
        long result = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertEquals(32000, result);
    }

    @Test
    public void good_pit_open_1_test() {
        int[] arr = new int[] {1,0,0};
        long result = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertEquals(0, result);
    }

    @Test
    public void good_pit_open_2_test() {
        int[] arr = new int[] {0,3,0};
        long result = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertEquals(0, result);
    }

}
