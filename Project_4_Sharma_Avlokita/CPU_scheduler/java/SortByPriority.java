import java.util.Comparator;
public class SortByPriority implements Comparator<Task> {
    public int compare(Task x, Task y)
    {
        return y.getPriority() - x.getPriority();
    }
}

//returns an integer after comparing the priority of the parameter task x and task y
