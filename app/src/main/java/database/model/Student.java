package database.model;

public class Student {
    public static final String TABLE_NAME = "students";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STUDENT = "student";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_COURSE = "course";
    public static final String COLUMN_PRIORITY = "priority";


    private int id;
    private String student;
    private String timestamp;
    private String course;
    private int priority;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_STUDENT + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
                    + COLUMN_COURSE + " TEXT, "
                    + COLUMN_PRIORITY + " INTEGER"
                    + ")";

    public Student() {
    }

    public Student(int id, String student, String timestamp, String course, int priority) {
        this.id = id;
        this.student = student;
        this.timestamp = timestamp;
        this.course = course;
        this.priority = priority;
    }


    public int getId() {
        return id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }
}
