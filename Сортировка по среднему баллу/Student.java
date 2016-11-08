public class Student {
    private String DEFAULT_NAME = "DEFAULT";
    private int DEFAULT_MAX_COUNT = 10;
    private String name;
    private int age;
    private int[] marks;
    private double middleMark;
    
    //пустой конструктор
    public Student() {
        this.name = DEFAULT_NAME;
        this.marks= int[DEFAULT_MAX_COUNT];
    }
 
    //конструктор с параметрами
    public Student(String name, int age, int[] marks) {
        this.name = name;
        this.age = age;
        // this.marks = marks; - передается ссылка
        this.marks = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = marks[i];
        }
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