import java.util.Scanner;

public class P_Number_0_100_to_Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int n1 = num/10;
        int n2 = num%10;
        String s2 ="";
        if(n2==0) s2 = "zero";
        else if(n2==1) s2= "one";
        else if(n2==2) s2= "two";
        else if(n2==3) s2= "three";
        else if(n2==4) s2= "four";
        else if(n2==5) s2= "five";
        else if(n2==6) s2= "six";
        else if(n2==7) s2= "seven";
        else if(n2==8) s2= "eight";
        else if(n2==9) s2= "nine";

        if(num<0||num>100) System.out.println("invalid number");
        else if(n1==0) System.out.printf("%s",s2);
        else if(n1==1&&n2==0) System.out.println("ten");
        else if(n1==1&&n2==1) System.out.println("eleven");
        else if(n1==1&&n2==2) System.out.println("twelve");
        else if(n1==1&&n2==3) System.out.println("thirteen");
        else if(n1==1&&n2==5) System.out.println("fifteen");
        else if(n1==1) System.out.printf("%steen",s2);
        else if(n1==2&&n2==0) System.out.println("twenty");
        else if(n1==2) System.out.printf("twenty %s",s2);
        else if(n1==3&&n2==0) System.out.println("thirty");
        else if (n1==3) System.out.printf("thirty %s",s2);
        else if(n1==4&&n2==0) System.out.println("forty");
        else if (n1==4) System.out.printf("forty %s",s2);
        else if(n1==5&&n2==0) System.out.println("fifty");
        else if (n1==5) System.out.printf("fifty %s",s2);
        else if(n1==6&&n2==0) System.out.println("sixty");
        else if (n1==6) System.out.printf("sixty %s",s2);
        else if(n1==7&&n2==0) System.out.println("seventy");
        else if (n1==7) System.out.printf("seventy %s",s2);
        else if(n1==8&&n2==0) System.out.println("eighty");
        else if (n1==8) System.out.printf("eighty %s",s2);
        else if(n1==9&&n2==0) System.out.println("ninety");
        else if (n1==9) System.out.printf("ninety %s",s2);
        else if (n1==10) System.out.println("one hundred");
    }
}
