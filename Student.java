public class Student {

    private String name;
    private int age;
    private int[] marks;
    private double middleMark;

    public Student(String name, int age, int[] marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        setMiddleMark(marks);
    }
    private void setMiddleMark(int[] marks) {
        double sum = 0;
        int marksCount = 0;
        for (int i = 0; i < marks.length; i++) {
            if ((marks[i] > 0) && (marks[i]<6)) {
                sum += marks[i];
                marksCount++;
            }
        }
        this.middleMark = sum/marksCount;
    }

    public void setAge(int age) {
        if ((age >= 0) && (age <= 110)) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }
    public int getAge() {
        return this.age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setMarks(int[] marks) {
        this.marks = marks;
        setMiddleMark(marks);
    }
    public int[] getMarks() {
        return this.marks;
    }
    public void setMiddleMark() {

    }
    public double getMiddleMark() {
        return this.middleMark;
    }

}