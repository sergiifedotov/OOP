package OOP.homework14;

/**
 *  Написать метод быстрой сортировки для массива студентов по оценкам,
 *   от отличников к двоечникам.
 void sort(Student[] students)

 Студент (имя, фамилия, отчество, оценки по викендам).
 Оценки по викендам представляют собой массив целых чисел.

 Классы задания: hw8.sort.QuickSorter, hw8.sort.Student
 *
 */

public class QuickSorter {
	private Student[] students;
	
	public QuickSorter() {
		
	}
	
	public void sort(Student[] students) {
		quickSort(students, 0, students.length - 1);
	}
	
	private void quickSort(Student[] students, int left, int right) {
		int l = left;
		int r = right;
		Student pivot = students[(left + right) / 2];
		while (l <= r) {
			while (students[l].compareTo(pivot) < 0) { l++; }
			while (students[r].compareTo(pivot) > 0) { r--; }
			if (l <= r) {
				swap(students, l++, r--);
			}
		}
		if (left < r) {
			quickSort(students, left, r);
		}
		if (l < right) {
			quickSort(students, l, right);
		}
	}

	
	private void swap(Student[] vector, int l, int r) {
		Student tmp = vector[l];
		vector[l] = vector[r];
		vector[r] = tmp;
	}

	@Override
	public String toString() {
		String outString = "";
		for (Student currentStudent : students) {
			outString += currentStudent;
		}
		return outString;
	}

	
	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}


	private class Student implements Comparable<Student> {
		private String name;
		private String secondName;
		private String familyName;
		private int[] weekendMarksList;

		public Student() {

		}

		public Student(String name, String secondName, String familyName) {
			this();
			setName(name);
			setSecondName(secondName);
			setFamilyName(familyName);
		}

		public double averageMark() {
			int weekendMarksSum = 0;
			for (int currentMark : weekendMarksList) {
				weekendMarksSum += currentMark;
			}
			return (double)weekendMarksSum / weekendMarksList.length;
		}
		
		@Override
		public int compareTo(Student student) {
			double markDifference = this.averageMark() - student.averageMark();
			if (markDifference > 0) {
				return -1; // reverse sort
			} else if (markDifference < 0) {
				return 1;
			} else {
				return 0;
			}
		}

		@Override
		public String toString() {
			return familyName + " " + name + " " + secondName + " " + averageMark() + "\n";
		}
		
		
		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@SuppressWarnings("unused")
		public String getSecondName() {
			return secondName;
		}

		public void setSecondName(String secondName) {
			this.secondName = secondName;
		}

		@SuppressWarnings("unused")
		public String getFamilyName() {
			return familyName;
		}

		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}

		@SuppressWarnings("unused")
		public int[] getWeekendMarksList() {
			return weekendMarksList;
		}

		public void setWeekendMarksList(int[] weekendMarksList) {
			this.weekendMarksList = weekendMarksList;
		}

	}
	
	public static void main(String[] args) {
		QuickSorter myQuickSorter = new QuickSorter();
		myQuickSorter.students = new Student[3];
		
		myQuickSorter.students[0] = myQuickSorter.new Student("Иван", "Иваныч", "Иванов");
		myQuickSorter.students[1] = myQuickSorter.new Student("Петр", "Петрович", "Петров");
		myQuickSorter.students[2] = myQuickSorter.new Student("Сидор", "Сидорыч", "Сидоров");
		
		myQuickSorter.students[0].setWeekendMarksList(new int[] {1, 1, 2, 2, 2, 3, 3, 3});
		myQuickSorter.students[1].setWeekendMarksList(new int[] {2, 2, 2, 3, 3, 3});
		myQuickSorter.students[2].setWeekendMarksList(new int[] {2, 2, 3, 3, 4, 4});
		
		System.out.println(myQuickSorter);
		myQuickSorter.sort(myQuickSorter.students);
		System.out.println(myQuickSorter);
	}

}
