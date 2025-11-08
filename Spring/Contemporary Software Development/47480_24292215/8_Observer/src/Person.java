
public class Person implements Observer {
    private String name;
    private int wakeHour, wakeMinute, wakeSecond;
    private AlarmClock observedClock;

    public Person(String name) {
        this.name = name;
    }

    public void setObservedClock(AlarmClock clock) {
        this.observedClock = clock;
    }

    public String getWakeUpTime() {
        return String.format("%02d:%02d:%02d", wakeHour, wakeMinute, wakeSecond);
    }

    public void goToBed() {
        System.out.println(name + " is going to bed...");
    }

    public void wakeUp() {
        System.out.println(name + " has woken up!");
    }

    @Override
    public void update() {
        if (observedClock == null) return;

        int h = observedClock.getAlarmHours();
        int m = observedClock.getAlarmMinutes();
        int s = observedClock.getAlarmSeconds();

        if (h == wakeHour && m == wakeMinute && s == wakeSecond) {
            wakeUp();
            System.out.println(name + " is detaching from the alarm clock.");
            observedClock.detach(this);
        } else {
            wakeHour = h;
            wakeMinute = m;
            wakeSecond = s;
            System.out.println(name + "'s wake-up time is set to " + getWakeUpTime());
        }
    }
}
