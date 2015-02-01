package OOP.homework10;

import java.io.*;
import java.util.*;


/**
 * Написать приложение управления курсами.
 Используемые сущности: Группа (название, студенты), 
 Студент (имя, фамилия, отчество, оценки по викендам).
 Добавить следующие возможности в виде консольного меню, 
 а так же методы в класс Courses:
 - Задать новое имя группы (старое имя, новое имя), 
 void setGroupName(String groupName) throws NoSuchGroupException
 - Добавить студента на курсы, void addStudent(Student student)
 - Добавить группу по имени, 
 void addGroup(String groupName) throws GroupExistsException
 - Вывести информацию о группе, 
 void printGroupInfo(String groupName)  throws NoSuchGroupException
 - Добавить студента в группу по фамилии, 
 void addStudentToGroup(String studentSName, String groupName) 
 throws NoSuchStudentException
 - Удалить студента из группы по фамилии (на курсах студент остается), 
 void removeStudentFromGroup(String studentSName, String groupName) 
 throws NoSuchStudentException
 - Создать копию группы со студентами, 
 void cloneGroup(String groupName) throws NoSuchGroupException
 - Сохранить информацию о курсах в файл, void serialize()
 - Прочитать информацию о курсах из файла, void deserialize()

 Классы задания hw6.courses.Group,
 hw6.courses.Student
 hw6.courses.Courses
 hw6.courses.NoSuchGroupException
 hw6.courses.NoSuchStudentException
 hw6.courses.GroupExistsException
 *
 */

public class Courses implements Serializable {
	private static final long serialVersionUID = 4952627963219800672L;
	private ArrayList<Student> coursesList;
	private ArrayList<Group> groupList;

	public Courses() {
		setCoursesList(new ArrayList<Student>());
		setGroupList(new ArrayList<Group>());
	}
	
	public void setGroupName(String groupName, String newGroupName)
			throws NoSuchGroupException {
		boolean groupFound = false;
		for (Group group : getGroupList()) {
			if (group.getName().equals(groupName)) {
				group.setName(newGroupName);
				groupFound = true;
			}
		}
		if (!groupFound) {
			throw new NoSuchGroupException();
		}
	}

	public void addStudent(Student student) {
		coursesList.add(student);
	}

	public void addGroup(String groupName) throws GroupExistsException {
		boolean groupFound = false;
		for (Group group : getGroupList()) {
			if (group.getName().equals(groupName)) {
				groupFound = true;
			}
		}
		if (groupFound) {
			throw new GroupExistsException();
		} else {
			getGroupList().add(new Group(groupName));
		}
	}

	public void printGroupInfo(String groupName) throws NoSuchGroupException {
		boolean groupFound = false;
		for (Group group : getGroupList()) {
			if (group.getName().equals(groupName)) {
				System.out.println(group.toString());
				groupFound = true;
			}
		}
		if (!groupFound) {
			throw new NoSuchGroupException();
		}
	}

	public void addStudentToGroup(String studentSName, String groupName)
			throws NoSuchStudentException, NoSuchGroupException {
		boolean studentFound = false;
		boolean groupFound = false;
		for (Student student : getCoursesList()) {
			if (student.getName().equals(studentSName)) {
				studentFound = true;

				for (Group group : getGroupList()) {
					if (group.getName().equals(groupName)) {
						groupFound = true;

						group.getGroupList().add(student);
					}
				}
			}
		}
		if (!studentFound) {
			throw new NoSuchStudentException();
		}
		if (!groupFound) {
			throw new NoSuchGroupException();
		}
	}

	public void removeStudentFromGroup(String studentSName, String groupName)
			throws NoSuchStudentException, NoSuchGroupException {
		boolean studentFound = false;
		boolean groupFound = false;
		for (Student student : getCoursesList()) {
			if (student.getName().equals(studentSName)) {
				studentFound = true;

				for (Group group : getGroupList()) {
					if (group.getName().equals(groupName)) {
						groupFound = true;

						group.getGroupList().remove(student);
					}
				}
			}
		}
		if (!studentFound) {
			throw new NoSuchStudentException();
		}
		if (!groupFound) {
			throw new NoSuchGroupException();
		}

	}

	public void cloneGroup(String groupName, String newName) 
			throws NoSuchGroupException, CloneNotSupportedException {
		boolean groupFound = false;
		for (Group group : getGroupList()) {
			if (group.getName().equals(groupName)) {
				groupFound = true;
				Group newGroup = (Group) group.clone();
				newGroup.setName(newName);
				getGroupList().add(newGroup);
			}
		}
		if (!groupFound) {
			throw new NoSuchGroupException();
		}
	}

	public void serialize() {
		ObjectOutputStream objOut = null;
		try {
			objOut = new ObjectOutputStream(new FileOutputStream("Courses.ser"));
			objOut.writeObject(this);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (objOut != null) {
					objOut.close();
				}
			} catch (IOException ioe) {}
		}
	}

	public void deserialize() {
		ObjectInputStream objIn = null;
		try {
			objIn = new ObjectInputStream(new FileInputStream("Courses.ser"));
			objIn.readObject();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (objIn != null) {
					objIn.close();
				}
			} catch (IOException ioe) {}
		}
	}

	public ArrayList<Student> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(ArrayList<Student> coursesList) {
		this.coursesList = coursesList;
	}

	public ArrayList<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}
}

class Group implements Cloneable {

	@Override
	public Object clone() throws CloneNotSupportedException {
		Group myClone = (Group) super.clone();
		@SuppressWarnings("unchecked")
		ArrayList<Student> groupListClone = 
		(ArrayList<Student>) myClone.groupList.clone();
		myClone.setGroupList(groupListClone);
		return myClone;
	}

	@Override
	public String toString() {
		return getName() + " " + getGroupList().toString();
	}

	private String name;
	private ArrayList<Student> groupList;

	public Group() {
		setGroupList(new ArrayList<Student>());
	}

	public Group(String name) {
		this();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<Student> groupList) {
		this.groupList = groupList;
	}
}

class Student {
	private String name;
	private String secondName;
	private String familyName;
	private ArrayList<Integer> weekendMarksList;

	public Student() {
		weekendMarksList = new ArrayList<Integer>();
	}

	public Student(String name, String secondName, String familyName) {
		this();
		setName(name);
		setSecondName(secondName);
		setFamilyName(familyName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public ArrayList<Integer> getWeekendMarksList() {
		return weekendMarksList;
	}

	public void setWeekendMarksList(ArrayList<Integer> weekendMarksList) {
		this.weekendMarksList = weekendMarksList;
	}

}

@SuppressWarnings("serial")
class NoSuchGroupException extends Exception {
	public NoSuchGroupException() {
		super("No Such Group");
	}
}

@SuppressWarnings("serial")
class NoSuchStudentException extends Exception {
	public NoSuchStudentException() {
		super("No Such Student");
	}
}

@SuppressWarnings("serial")
class GroupExistsException extends Exception {
	public GroupExistsException() {
		super("Group Exists");
	}
}
