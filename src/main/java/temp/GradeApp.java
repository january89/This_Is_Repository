package temp;


import java.util.Arrays;
import java.util.List;

public class GradeApp {
    public static void main(String[] args) {
        final Student student1 = new Student(1L, "Tom");
        final Student student2 = new Student(2L, "Kevin");
        final Student student3 = new Student(3L, "John");
        final Student student4 = new Student(4L, "Jon Snow");
        final Student student5 = new Student(5L, "Jane");
        final List<Score> scores = Arrays.asList(
                new Score(1L, 49, student1),
                new Score(2L, 55, student2),
                new Score(3L, 68, student3),
                new Score(4L, 78, student4),
                new Score(5L, 88, student5)
        );
        ​
        for (final Score score : scores) {
            System.out.println("Student: " + score.getStudent());
            System.out.println("  Score: " + score.getScore());
            System.out.println("  Grade: " + score.getGrade());
        }
    }
}
​
class GradeUtil{
    public static String grade(double score) {
        if(score < 50) return "Fail";
        if(score < 65) return "Pass";
        if(score < 75) return "Credit";
        if(score < 85) return "Distinct";
        else return "High Distinction";
    }
}
​
class Student {
    ​
    private Long id;
    private String name;
    ​
    public Student(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
}
​
class Score {
    ​
    private Long id;
    private double value;
    private Student student;
    ​
    public Score(final Long id, final double value, final Student student) {
        this.id = id;
        this.value = value;
        this.student = student;
    }
    ​
    public Student getStudent() {
        return student;
    }
    ​
    public double getScore(){
        return value;
    }
    public String getGrade(){
        return GradeUtil.grade(value);
    }
    ​​
}