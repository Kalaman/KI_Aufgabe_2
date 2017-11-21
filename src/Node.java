/**
 * Created by Kalaman on 21.11.17.
 */
public class Node {
    private String name;
    private int value;

    public Node(String name)
    {
        this.name = name;
        value = 0;
    }

    public String getName() {
        return name;
    }

    public int getValue () {
        return value;
    }

    public void addValue(int value)
    {
        this.value += value;
    }

    @Override
    public String toString() {
        return name + " ("+value+")";
    }
}
