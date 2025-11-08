public class Cron implements Observer {
    private String taskName;
    private int targetHour, targetMinute, targetSecond;
    private AlarmClock clock;

    public Cron(String taskName, int hour, int minute, int second) {
        this.taskName = taskName;
        this.targetHour = hour;
        this.targetMinute = minute;
        this.targetSecond = second;
    }

    public void setClock(AlarmClock clock) {
        this.clock = clock;
    }

    @Override
    public void update() {
        if (clock == null) return;

        if (clock.getAlarmHours() == targetHour
                && clock.getAlarmMinutes() == targetMinute
                && clock.getAlarmSeconds() == targetSecond) {
            runTask();
        }
    }

    private void runTask() {
        System.out.println("Cron Task [" + taskName + "] is running at "
                + String.format("%02d:%02d:%02d", targetHour, targetMinute, targetSecond));
    }
}