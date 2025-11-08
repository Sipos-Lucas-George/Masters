import java.util.ArrayList;
import java.util.List;

enum Grade {NONE, FAIL, PASS, DISTINCTION};

public class ModuleAttendee {

  public static void main(String[] args) {
    ModuleAttendee john = new ModuleAttendee("John");
    john.addModuleAttempt(new ModuleAttempt("OOP", "COMP1234", Grade.PASS));
    john.addModuleAttempt(new ModuleAttempt("DSA", "COMP4321", Grade.DISTINCTION));
    System.out.println(john.toString());
  }
  
  public ModuleAttendee(String name) {
    this.name = name;
    this.attempts = new ArrayList<>();
  }

  public void addModuleAttempt(ModuleAttempt attempt) {
    attempts.add(attempt);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder(name + " took\n");
    for (ModuleAttempt attempt : attempts) {
      sb.append(attempt.toString()).append("\n");
    }
    return sb.toString().strip();
  }

  private String name;
  private List<ModuleAttempt> attempts;
}

class ModuleAttempt {
  private String moduleName;
  private String moduleCode;
  private Grade grade;

  public ModuleAttempt(String moduleName, String moduleCode, Grade grade) {
    this.moduleName = moduleName;
    this.moduleCode = moduleCode;
    this.grade = grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return String.format("%s:%s, achieving the grade: %s", moduleCode, moduleName, grade);
  }
}
