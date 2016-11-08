public class Program {
    public static void main(String[] args) {

        Student[] studentList = new Student[5];

        int[] ivanovMarks = {3, 5, 3, 5};
        studentList[0] = new Student("ivanov", 30, ivanovMarks);

        int[] petrovMarks = {4, 3, 4, 1};
        studentList[1] = new Student("petrov", 30, petrovMarks);

        int[] sidorovMarks = {2, 4, 3, 5};
        studentList[2] = new Student("sidorov", 30, sidorovMarks);

        int[] mokeevMarks = {4, 4, 5, 5};
        studentList[3] = new Student("mokeev", 30, mokeevMarks);

        int[] ilushinMarks = {5, 4, 3, 5};
        studentList[4] = new Student("ilushin", 30, ilushinMarks);

        for (int i = 0; i < studentList.length; i++) {
            System.out.println(studentList[i].getName()+" "+studentList[i].getMiddleMark());
        }

        boolean mona = true;
        while (mona) {
            for (int i = 0; i < studentList.length-1; i++) {
                Student temp = studentList[i+1];
                mona = false;
                if (studentList[i].getMiddleMark() > studentList[i+1].getMiddleMark()) {
                    studentList[i+1] = studentList[i];
                    studentList[i] = temp;
                    mona = true;
                }
            }
        }

        for (int i = 0; i < studentList.length; i++) {
            System.out.println(studentList[i].getName()+" "+studentList[i].getMiddleMark());
        }

    }
}