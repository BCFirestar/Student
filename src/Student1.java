/**
 * Created by Barry on 1/20/2016.
 */
import java.io.*;
import java.util.ArrayList;

public class Student1 {
    public static void main(String [] args) throws FileNotFoundException{
        ArrayList<Student> kids = new ArrayList<Student>();

        File file = new File("studentRecord.txt");
        BufferedReader read = null;

        try{
            read = new BufferedReader(new FileReader(file));
            String text;

            while ((text = read.readLine()) != null){
                String[] life = text.split(" ");
                kids.add(new Student(life[0],Integer.parseInt(life[1])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (read != null) {
                    read.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < kids.size()-1; i++)
            System.out.println(kids.get(i).getName()+ kids.get(i).getGrade());
        boolean t = true;
        Student temp;
        while(t){
            t = false;
            for(int i=0; i<kids.size()-1; i++){
                if (kids.get(i).getGrade() > kids.get(i+1).getGrade()){
                    temp = kids.get(i);
                    kids.set(i,kids.get(i+1));
                    kids.set(i+1, temp);
                    t = true;
                }
            }
        }
        //for(int i = 0; i < kids.size()-1; i++)
        System.out.println(kids);//.get(i).getName()+ kids.get(i).getGrade());
        PrintStream write = new PrintStream("results.txt");
        for(Student str: kids)
            write.println(str);
        write.close();
    }
}