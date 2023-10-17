public class Inverter {
    Wire inverterIn;
    Wire inverterOutput;
    int inverter_delay = 2;

    public Inverter(Wire inverterIn, Wire inverterOutput) {
        this.inverterIn = inverterIn;
        this.inverterOutput = inverterOutput;
        Action action = new Action();
        action.setAction(this::inverter_action_procedure);
        action.setActionName("inverter_action_procedure");
        inverterIn.add_action(action);
    }
    public int logical_inverter(int signal){
        if (signal == 0) {
            return 1;
        }
        return 0;
    }
    public void inverter_action_procedure(){
        int newSignal = logical_inverter(inverterIn.getSignal());
        Action action = new Action();
        action.setAction(() -> inverterOutput.setSignal_value(newSignal));
        action.setActionName("seg_inverter()");
        Ciruit.agenda.after_delay(inverter_delay, action);
    }
}
