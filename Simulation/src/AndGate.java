public class AndGate {
    Wire andUp;
    Wire andDown;
    Wire andOutput;
    int and_delay = 3;
    public AndGate(Wire andUp, Wire andDown, Wire andOutput) {
        this.andUp = andUp;
        this.andDown = andDown;
        this.andOutput = andOutput;
        Action action = new Action();
        action.setAction(this::and_action_procedure);
        action.setActionName("and_action_procedure");
        andUp.add_action(action);
        andDown.add_action(action);
    }

    public void and_action_procedure(){
        int newSignal = logical_and(andUp.getSignal(), andDown.getSignal());
        Action action = new Action();
        action.setAction(() -> andOutput.setSignal_value(newSignal));
        action.setActionName("seg_and()");
        Ciruit.agenda.after_delay(and_delay, action);
    }
    public int logical_and(int signalUp, int signalDown){
        if (signalDown == 1 && signalUp == 1) {
            return 1;
        }
        return 0;
    }
}
