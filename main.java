import java.util.List;

// Класс для представления преподавателя
class Teacher {
    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Класс для представления студента
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Класс для представления учебной группы
class EducationalGroup {
    private Teacher teacher;
    private List<Student> students;

    public EducationalGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    // Геттеры
    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}

// Класс сервиса для работы с учебными группами
class EducationalGroupService {
    public EducationalGroup createEducationalGroup(Teacher teacher, List<Student> students) {
        return new EducationalGroup(teacher, students);
    }
}

// Контроллер
class Controller {
    private EducationalGroupService groupService;

    public Controller() {
        groupService = new EducationalGroupService();
    }

    public EducationalGroup createAndReturnEducationalGroup(Teacher teacher, List<Student> students) {
        return groupService.createEducationalGroup(teacher, students);
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример использования
        Teacher teacher = new Teacher(1, "John Doe");
        List<Student> students = List.of(
            new Student(1, "Student 1"),
            new Student(2, "Student 2"),
            new Student(3, "Student 3")
        );

        Controller controller = new Controller();
        EducationalGroup group = controller.createAndReturnEducationalGroup(teacher, students);

        System.out.println("Учебная группа с преподавателем " + group.getTeacher().getName() + " и " +
                group.getStudents().size() + " студентами создана.");
    }
}
