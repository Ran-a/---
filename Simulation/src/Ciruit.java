public class Ciruit {
    static Agenda agenda = new Agenda();
    public static void main(String[] args) {
        Wire a = new Wire();
        Wire b = new Wire();
        Wire s = new Wire();
        Wire c = new Wire();

        HalfAdder halfAdder = new HalfAdder(a, b, s, c);
        System.out.println("初始化半加器对象的agenda内容如下：");
        probe(a);
        probe(b);
        b.setSignal_value(1);
        agenda.propagate();
        System.out.println("currentTime:" + agenda.currentTime + " C: " + c.getSignal() + " S:" + s.getSignal());
        a.setSignal_value(1);
        agenda.propagate();
        System.out.println("currentTime:" + agenda.currentTime + " C: " + c.getSignal() + " S:" + s.getSignal());
//
//        a.setSignal_value(1);
//        for (Segment segment : agenda.segments){
//            System.out.println(segment.getTime()+","+segment.getActions());
//        }
//        agenda.propagate();
//        System.out.println(agenda.currentTime);
//
//        b.setSignal_value(1);
//        for (Segment segment : agenda.segments){
//            System.out.println(segment.getTime()+","+segment.getActions());
//        }
//        agenda.propagate();
//        System.out.println(agenda.currentTime);
//        System.out.println(c.getSignal());
//        System.out.println(s.getSignal());
    }
    public static void probe(Wire wire){
        Action action = new Action();
        action.setAction(() -> printSegment(wire));
        wire.add_action(action);
    }
    public static void printSegment(Wire wire){
        if (wire.isChange) {
            for (Segment segment : agenda.segments){
                System.out.println("time: " + segment.getTime() + " actions: " + segment.getActionsNames());
            }
        }

    }
}
