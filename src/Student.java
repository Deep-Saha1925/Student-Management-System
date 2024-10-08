public class Student {
    private int ROLL;
    private String NAME;
    private float MARKS;

    public Student(int roll, String name, float marks){
        this.ROLL = roll;
        this.MARKS = marks;
        this.NAME = name;
    }

    public int getRoll(){
        return this.ROLL;
    }

    public String getName(){
        return this.NAME;
    }

    public float getMarks(){
        return this.MARKS;
    }

    public String toString(){
        return "\nSTUDENT [ROLL = "+this.ROLL+", NAME = " + this.NAME + ", MARKS = "+this.MARKS+"]";
    }
}