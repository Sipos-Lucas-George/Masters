import java.util.ArrayList;
import java.util.List;

public class AlarmClock extends Subject {
    private int hours, minutes, seconds;
    private int alarmHours, alarmMinutes, alarmSeconds;

    public int getAlarmHours() {
        return alarmHours;
    }

    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    public int getAlarmSeconds() {
        return alarmSeconds;
    }

    public void setTime(int hrs, int mins, int secs) {
        if (isValidTime(hrs, mins, secs)) {
            hours = hrs;
            minutes = mins;
            seconds = secs;
        } else {
            throw new IllegalArgumentException("Invalid time format");
        }
    }

    public void setAlarmTime(int hrs, int mins, int secs) {
        if (isValidTime(hrs, mins, secs)) {
            alarmHours = hrs;
            alarmMinutes = mins;
            alarmSeconds = secs;
            notifyObservers();
        } else {
            throw new IllegalArgumentException("Invalid alarm time format");
        }
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours = (hours + 1) % 24;
            }
        }
        System.out.println("Time is: " + getTime());

        if (isAlarmReached()) {
            notifyObservers();
        }
    }

    public String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public boolean isAlarmReached() {
        return hours == alarmHours && minutes == alarmMinutes
                && seconds == alarmSeconds;
    }

    private boolean isValidTime(int hrs, int mins, int secs) {
        return hrs >= 0 && hrs < 24 && mins >= 0 && mins < 60 && secs >= 0
                && secs < 60;
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersCopy = new ArrayList<>(observers);
        for (Observer obs : observersCopy) {
            obs.update();
        }
    }
}
