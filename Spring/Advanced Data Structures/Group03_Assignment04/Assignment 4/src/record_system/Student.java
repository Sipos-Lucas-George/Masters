package record_system;

public class Student implements Comparable<Student> {
	public String name;
	public boolean gender; // true = male, false = female
	public int age;
	public String address;
	public String phoneNumber;
	public String email;

	public Student(String name, boolean gender, int age, String address, String phoneNumber, String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format(
			"Name: %s\nGender: %s\nAge: %d\nAddress: %s\nPhone: %s\nEmail: %s",
			name,
			gender ? "Male" : "Female",
			age,
			address,
			phoneNumber,
			email
		);
	}

	@Override
	public int compareTo(Student other) {
		int cmp;

		cmp = this.name.compareTo(other.name);
		if (cmp != 0) return cmp;

		cmp = Boolean.compare(this.gender, other.gender);
		if (cmp != 0) return cmp;

		cmp = Integer.compare(this.age, other.age);
		if (cmp != 0) return cmp;

		cmp = this.address.compareTo(other.address);
		if (cmp != 0) return cmp;

		cmp = this.phoneNumber.compareTo(other.phoneNumber);
		if (cmp != 0) return cmp;

		return this.email.compareTo(other.email);
	}
}