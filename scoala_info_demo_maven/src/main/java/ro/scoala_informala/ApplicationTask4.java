package ro.scoala_informala;

public class ApplicationTask4 {
    public static void main(String[] args) {

        String a = "34143";
        String b = "";
        for (int index=a.length()-1;index >=0; index--) {
            b += a.charAt(index);}
        System.out.println("Result: " + b);
if (a.equalsIgnoreCase(b)){System.out.println(a+" is a palindrome  ");}
else {System.out.println(a+" is not a palindrome, sorry!  " );}
    }
    }


