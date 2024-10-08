import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----WELCOME TO STUDENT MANAGEMENT SYSTEM-----");
        boolean run = true;
        
        do {
            System.out.println("1. INSERT DATA.");
            System.out.println("2. READ DATA.");
            System.out.println("3. UPDATE DATA.");
            System.out.println("4. DELETE DATA.");
            System.out.println("5. Exit.\nENTER YOUR CHOICE");
    
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter ROLL, NAME, MARKS");
                    int r = sc.nextInt();
                    sc.nextLine();
                    String n = sc.nextLine();
                    float m = sc.nextInt();
                    Student s = new Student(r, n, m);
                    StudentDao.addData(s);
                    System.out.println("DATA INSERTED SUCESSFULLY..\n");
                    break;
    
                case 2:
                    System.out.println("--STUDENT DETAILS--");
                    ArrayList<Student> list = StudentDao.displayData();
                    System.out.println(list);
                    break;
    
                case 3:
                    System.out.println("Enter field you want to update(1 for ROLL, 2 for NAME, 3 for MARKS)");
                    int field = sc.nextInt();
                    switch (field) {
                        case 1:
                            System.out.println("Enter the existing ROLL");
                            int old = sc.nextInt();
                            System.out.println("Enter the new ROLL");
                            int newRoll = sc.nextInt();
                            StudentDao.updateRoll(old, newRoll);
                            break;
                        
                        case 2:
                            System.out.println("Enter the ROLL");
                            old = sc.nextInt();
                            System.out.println("Enter the new NAME");
                            String newName = sc.nextLine();
                            StudentDao.updateName(old, newName);
                            break;

                        case 3:
                            System.out.println("Enter the ROLL");
                            old = sc.nextInt();
                            System.out.println("Enter the new MARKS");
                            float marks = sc.nextFloat();
                            StudentDao.updateMarks(old, marks);
                            break;
                        
                        default:
                            break;
                    }
                    System.out.println("DATA UPDATED SUCESSFULLY..\n");
                    break;
    
                case 4:
                    System.out.println("Enter the ROLL");
                    int roll = sc.nextInt();
                    StudentDao.DeleteData(roll);
                    System.out.println("DATA DELETED SUCESSFULLY..\n");
                    break;

                case 5:
                    run = false;
                    System.out.println("CLOSING THE APP..BYE..");
                    System.exit(0);
            
                default:
                    System.out.println("Invalid Option!! Choose another one..");
                    break;
            }
        }while (run);

        sc.close();
    }
}
