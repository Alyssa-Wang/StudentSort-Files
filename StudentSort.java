import java.util.*;
import java.io.*;

/**
 * <p>
 * Problem 2 of the Arrays Assignments
 * Reads from a file with student names and marks. Sorts by highest to lowest marks as well as alphabetically.
 * </p>
 *
 * Variable Name         Type          Purpose
 * <b>stu</b>            String []     stores the names of the students in an array of 35
 * <b>mark</b>           int []        stores the marks of the students in an array of 35
 * @author Alyssa Wang, Marina Semenova, Nayaab Ali 
 * @version 1.0, Mar. 26, 2019
 */
public class StudentSort 
{

    String[] stu = new String[35];
    int[] mark = new int[35];

    /**
     * Reads from the original file, stores data in an array
     * Puts data into new file
     *
     * Local Variables
     * <b>input</b> Scanner for reading input
     * <b>file</b> gets file
     * <b>x</b> goes to next index of array each increment of while loop
     * <b>output</b> PrintWriter to write to a new file
     */
    public void readInput() throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File("A7-1.txt");
        int x = 0;

        input = new Scanner(file);

        while (input.hasNextLine()) {
            stu[x] = input.nextLine();
            mark[x] = Integer.parseInt(input.nextLine());
            x++;
        }
        input.close();
        PrintWriter output=new PrintWriter(new BufferedWriter(new FileWriter("StudentMarksA")));
        for (int y = 0; y < 35; y++) {
            output.println(stu[y]);
            output.println(mark[y]);
        }
        output.close();
    }

    /**
     * Displays data to console
     */
    public void display() {
        for (int i = 0; i < 35; i++) {
            System.out.print(stu[i] + "     ");
            System.out.println(mark[i]);
        }
    }

    /**
     * Sorts the data in array from original file alphabetically
     * Puts data into new file
     *
     * Local Variables
     * <b>n</b> array length for the while loop
     * <b>maxPos</b> stores position that needs to be switched
     * <b>temp</b> stores element of array temporarily to be switched with other element
     * <b>output</b> PrintWriter to write to a new file
     */
    public void sortName() throws IOException {
        int n = 35;
        int maxPos = 0;
        while (n > 1) {
            maxPos = 0;
            for (int x = 1; x < n; x++)
                if (stu[x].charAt(0) != stu[maxPos].charAt(0)) {
                    if (stu[x].charAt(0) > stu[maxPos].charAt(0))
                        maxPos = x;
                } else {
                    if (stu[x].substring(1).compareTo(stu[maxPos].substring(1)) > 0) {
                        maxPos = x;
                    }
                }

            String temp = stu[maxPos];
            stu[maxPos] = stu[n - 1];
            stu[n - 1] = temp;
            int tempM = mark[maxPos];
            mark[maxPos] = mark[n - 1];
            mark[n - 1] = tempM;
            n--;
        }

        PrintWriter output=new PrintWriter(new BufferedWriter(new FileWriter("StudentMarksB")));
        for (int x = 0; x < 35; x++) {
            output.println(stu[x]);
            output.println(mark[x]);
        }
        output.close();
    }

    /**
     * Sorts original data by marks from highest to lowest
     * Puts data into new file
     *
     * Local Variables
     * <b>n</b> array length for the while loop
     * <b>maxPos</b> stores position that needs to be switched
     * <b>temp</b> stores element of array temporarily to be switched with other element
     * <b>output</b> PrintWriter to write to a new file
     */
    public void sortMark() throws IOException {
        int n = 35;
        int maxPos = 0;
        while (n > 1) {
            maxPos = 0;
            for (int x = 1; x < n; x++)
                if (mark[x] <= mark[maxPos])
                    maxPos = x;

            String temp = stu[maxPos];
            stu[maxPos] = stu[n - 1];
            stu[n - 1] = temp;
            int tempM = mark[maxPos];
            mark[maxPos] = mark[n - 1];
            mark[n - 1] = tempM;
            n--;
        }

        PrintWriter output=new PrintWriter(new BufferedWriter(new FileWriter("StudentMarksC")));
        for (int x = 0; x < 35; x++) {
            output.println(stu[x]);
            output.println(mark[x]);
        }
        output.close();
    }

    /**
     * Main method creates new StudentSort object and runs methods
     *
     * @param args args
     */
    public static void main(String[] args) throws IOException {
        StudentSort m = new StudentSort();
        m.readInput();
        m.display();
        m.sortName();
        m.display();
        m.sortMark();
        m.display();
    }
}