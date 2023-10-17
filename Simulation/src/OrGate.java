public class OrGate {
    Wire orUp;
    Wire orDown;
    Wire orOutput;
    int or_delay = 5;

    public OrGate(Wire orUp, Wire orDown, Wire orOutput) {
        this.orUp = orUp;
        this.orDown = orDown;
        this.orOutput = orOutput;
        Action action = new Action();
        action.setAction(this::or_action_procedure);
        action.setActionName("or_action_procedure");
        orUp.add_action(action);
        orDown.add_action(action);
    }
    public void or_action_procedure(){
        int newSignal = logical_or(orUp.getSignal(), orDown.getSignal());
        Action action = new Action();
        action.setAction(() -> orOutput.setSignal_value(newSignal));
        action.setActionName("seg_or()");
        Ciruit.agenda.after_delay(or_delay, action);
    }
    public int logical_or(int signalUp, int signalDown){
        if (signalDown == 1 || signalUp == 1) {
            return 1;
        }
        return 0;
    }

}
