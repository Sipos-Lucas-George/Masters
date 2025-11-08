public class HospitalApp {
  public static void main(String[] args) {
    PatientRecord patient = new PatientRecord("John Doe", "087123456", "Allergies: None");
    Doctor doctor = new Doctor("Dr. Smith", "Cardiology");
    SpecialistNurse specialNurse = new SpecialistNurse("Nurse Anne", "Surgery");

    HospitalSystem system = new HospitalSystem(new AdmissionService(), new NotificationService(), new PersistenceService());
    system.admitPatient(patient, doctor);
    system.scheduleNurse(specialNurse);

    String ssn = system.getPatientSsn(patient);
    System.out.println("Patient SSN: " + ssn);

    EmergencyRoom er = new EmergencyRoom(new DatabaseLogger());
    er.handleEmergency(patient);
  }
}

class PatientRecord {
  private String name;
  private String ssn;
  private String medicalNotes;

  public PatientRecord(String name, String ssn, String medicalNotes) {
    this.name = name;
    this.ssn = ssn;
    this.medicalNotes = medicalNotes;
  }

  public String getName() { return name; }
  public String getSsn() { return ssn; }
  public String getMedicalNotes() { return medicalNotes; }
}

abstract class MedicalStaff {
  protected String name;
  protected String department;

  public MedicalStaff(String name, String department) {
    this.name = name;
    this.department = department;
  }

  public String getName() { return name; }
  public String getDepartment() { return department; }
}

class Doctor extends MedicalStaff {
  public Doctor(String name, String specialty) {
    super(name, specialty);
  }
}

interface Clockable {
  void clockIn();
}

interface NurseScheduler {
  void schedule();
}

class Nurse extends MedicalStaff implements Clockable, NurseScheduler {
  public Nurse(String name, String department) {
    super(name, department);
  }

  @Override
  public void clockIn() {
    System.out.println(name + " clocking in to " + department);
  }

  @Override
  public void schedule() {
      System.out.println("Scheduling regular nurse");
  }
}

class SpecialistNurse extends Nurse {
  public SpecialistNurse(String name, String department) {
    super(name, department);
  }

  @Override
  public void schedule() {
    System.out.println("Scheduling specialist nurse");
  }
}

class AdmissionService {
  public void admit(PatientRecord patient, Doctor doctor) {
    System.out.println("Admitting " + patient.getName() + " under " + doctor.getName());
  }
}

class NotificationService {
  public void sendNotification(Doctor doctor, PatientRecord patient) {
    System.out.println("Sending notification email");
  }
}

class PersistenceService {
  public void saveToDatabase(PatientRecord patient) {
    System.out.println("Saving patient data to database");
  }
}

class HospitalSystem {
  private final AdmissionService admissionService;
  private final NotificationService notificationService;
  private final PersistenceService persistenceService;

  public HospitalSystem(AdmissionService admissionService, NotificationService notificationService, PersistenceService persistenceService) {
      this.admissionService = admissionService;
      this.notificationService = notificationService;
      this.persistenceService = persistenceService;
  }

  public void admitPatient(PatientRecord patient, Doctor doctor) {
    admissionService.admit(patient, doctor);
    persistenceService.saveToDatabase(patient);
    notificationService.sendNotification(doctor, patient);
  }

  public void scheduleNurse(NurseScheduler nurse) {
    nurse.schedule();
  }

  public String getPatientSsn(PatientRecord patient) {
    return patient.getSsn();
  }
}

class EmergencyRoom {
  private Logger logger;

  public EmergencyRoom(Logger logger) {
    this.logger = logger;
  }

  public void handleEmergency(PatientRecord patient) {
    logger.log("Emergency for " + patient.getName());
  }
}

interface Logger {
  void log(String message);
}

class DatabaseLogger implements Logger {
  public void log(String message) {
    System.out.println("DB LOG: " + message);
  }
}