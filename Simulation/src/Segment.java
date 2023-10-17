import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Segment {
    int time;
    Queue<Action> actions;

    public Segment() {
        actions = new LinkedList<>();
    }

    public Segment(int time, Action action) {
        this.time = time;
        actions = new LinkedList<>();
        actions.add(action);
    }

    public int getTime() {
        return time;
    }
    public boolean isEmpty(){
        return actions.size() == 0;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public void addToSegment(Action action){
        actions.add(action);
    }

    public Queue<Action> getActions() {
        return actions;
    }
    public List<String> getActionsNames(){
        List<String> actionsNames = new ArrayList<>();
        for (Action action : actions) {
            actionsNames.add(action.getActionName());
        }
        return actionsNames;
    }
}
