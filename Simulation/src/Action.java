public class Action {
    Runnable action;
    String actionName;
    public void execute(){
        action.run();
    }
    public Runnable getAction() {
        return action;
    }
    public String getActionName(){
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }
}
