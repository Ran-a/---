public class HalfAdder {
    Wire a;
    Wire b;
    Wire s;
    Wire c;
    public HalfAdder(Wire a, Wire b, Wire s, Wire c) {
        this.a = a;
        this.b = b;
        this.s = s;
        this.c = c;
        Wire d = new Wire();
        Wire e = new Wire();
        AndGate andGateLeft = new AndGate(a, b, c);
        OrGate orGate = new OrGate(a, b, d);
        Inverter inverter = new Inverter(c, e);
        AndGate andGateRight = new AndGate(d, e, s);
        a.setWireName("a");
        b.setWireName("b");
        c.setWireName("c");
        d.setWireName("d");
        e.setWireName("e");
        s.setWireName("s");
        printActionFunctions(a);
        printActionFunctions(b);
        printActionFunctions(d);
        printActionFunctions(e);
        printActionFunctions(s);
        printActionFunctions(c);

    }
    public void  printActionFunctions(Wire wire){
        System.out.println(wire.getWireName()+"导线的action_functions为：");
        if (wire.action_functions.isEmpty()) {
            System.out.println("空");
        }else {
            for (Action action : wire.action_functions)
                System.out.println(action.actionName);
        }
    }
}
