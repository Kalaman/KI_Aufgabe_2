/**
 * Created by Kalaman on 21.11.17.
 */
public class AlphabeticNode extends Node {
    int [] alphabeticValues;

    public static final int VALUE_A = 0;
    public static final int VALUE_B = 1;
    public static final int VALUE_C = 2;

    public AlphabeticNode(String name) {
        super(name);

        //0 => A , 1 => B , 2 => C
        alphabeticValues = new int [3];
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getValue() {
        return -1;
    }

    public int getValue(int valueIndex) {
        if (valueIndex == VALUE_A || valueIndex == VALUE_B || valueIndex == VALUE_C)
            return alphabeticValues[valueIndex];
        else
            return -1;
    }

    @Override
    public void addValue(int valueIndex) {
        if (valueIndex == VALUE_A || valueIndex == VALUE_B || valueIndex == VALUE_C)
            ++alphabeticValues[valueIndex];
    }

    @Override
    public String toString() {
        return getName() + " (A:"+ alphabeticValues[VALUE_A]+", B:"+ alphabeticValues[VALUE_B] +", C:"+ alphabeticValues[VALUE_C]+")";
    }
}
