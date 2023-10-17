import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Wire {
    int signal_value = 0;
    ArrayList<Action> action_functions;
    String wireName;

    public String getWireName() {
        return wireName;
    }

    public void setWireName(String wireName) {
        this.wireName = wireName;
    }

    boolean isChange = false;

    public Wire() {
        action_functions = new ArrayList<>();
    }

    public void setSignal_value(int new_value){
        if (new_value != signal_value) {
            signal_value = new_value;
            isChange = true;
            call_each();
        }
    }
    public int getSignal(){
        return this.signal_value;
    }
    public void add_action(Action action){
        action_functions.add(0, action);
        action.execute();
    }
    public void call_each(){
        for (Action action : action_functions){
            action.execute();
        }
    }
}
