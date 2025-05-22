class Student {
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    Student(String name, int exam1, int exam2, int exam3) {
        this.name = name;
        if (!isValidScore(exam1) || !isValidScore(exam2) || !isValidScore(exam3)) {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    String getName() {
        return name;
    }

    int getExam1() {
        return exam1;
    }

    int getExam2() {
        return exam2;
    }

    int getExam3() {
        return exam3;
    }

    double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("John", 75, 110, 90);
            double average = student.calculateAverage();
            System.out.printf("Student: %s, Average Score: %.2f%n", student.getName(), average);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}