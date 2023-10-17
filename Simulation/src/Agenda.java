import java.util.ArrayList;
import java.util.List;

public class Agenda {
    int currentTime;
    List<Segment> segments;
    static int i = 0;
    public Agenda() {
        currentTime = 0;
        segments = new ArrayList<>();
    }
    public void after_delay(int delay, Action action){
        addToAgenda(delay + currentTime, action);
    }
    public void addToAgenda(int time, Action action){
        if (segments.size() == 0) {
            Segment newSegment = new Segment(time, action);
            segments.add(newSegment);
        }else{
            for (Segment segment : segments){
                if (segment.time == time) {
                    segment.addToSegment(action);
                    break;
                }else if (time < segment.getTime()) {
                    int index = segments.indexOf(segment);
                    Segment newSegment = new Segment(time, action);
                    segments.add(index, newSegment);
                    break;
                }else if (segments.indexOf(segment) == segments.size() - 1) {
                    Segment newSegment = new Segment(time, action);
                    segments.add(newSegment);
                    break;
                }
            }
        }
    }
    //删除第一个segment的第一个action,若删除这个action使segment为空，那么删除这个segment。
    public void remove_first_agenda_item(){
        segments.get(0).actions.poll();
        if (segments.get(0).isEmpty()) {
            segments.remove(0);
        }
    }
    public Action first_agenda_item(){
        if (!segments.isEmpty()) {
            Segment first_segment = segments.get(0);
            currentTime = first_segment.getTime();
            return segments.get(0).actions.element();
        }
        return null;
    }
    public void propagate(){
        if (segments.isEmpty()) {
            return;
        }else{
            Action firAction = first_agenda_item();
            firAction.execute();
            remove_first_agenda_item();
            i++;
            System.out.println("========================================= ");
            System.out.println("agenda第 " + i + " 次更新");
            for (Segment segment : segments){
                System.out.println("time: " + segment.getTime() + " actions: " + segment.getActionsNames());
            }
        }
        propagate();
    }
}
