/**
 * Created by Admin on 07/09/2015.
 */
public class Utils {
    public static float functionNormalize(int max, int min, int value) {
        int intermediateValue = max - min;
        value -= intermediateValue;
        float var = Math.abs((float)value/(float)intermediateValue);
        return Math.abs((float)value/(float)intermediateValue);
    }
}
