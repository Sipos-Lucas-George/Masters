
public class AlarmApplication {

    public static final int SECONDS_IN_DAY = 86400;

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.setTime(23, 59, 55);

        Person jack = new Person("Jack");
        Person jj = new Person("JJ");
        Person cj = new Person("CJ");

        jack.setObservedClock(alarmClock);
        jj.setObservedClock(alarmClock);
        cj.setObservedClock(alarmClock);

        jack.goToBed();
        jj.goToBed();
        cj.goToBed();

        alarmClock.attach(jack);
        alarmClock.attach(jj);
        alarmClock.attach(cj);

        Cron backupCron = new Cron("Database Backup", 0, 0, 10);
        backupCron.setClock(alarmClock);
        alarmClock.attach(backupCron);

        alarmClock.setAlarmTime(0, 0, 10);

        for (int i = 1; i <= SECONDS_IN_DAY && !alarmClock.isAlarmReached(); i++) {
            alarmClock.tick();
        }

        System.out.println("The time is: " + alarmClock.getTime());

        alarmClock.attach(jack);
        alarmClock.setAlarmTime(0, 0, 15);

        for (int i = 1; i <= SECONDS_IN_DAY && !alarmClock.isAlarmReached(); i++) {
            alarmClock.tick();
        }

        System.out.println("The time is: " + alarmClock.getTime());
    }
}
