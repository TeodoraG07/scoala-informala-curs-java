package ro.scoala_informala;


public class Application2 {
    public static void main(String[] args) {
        int result = 0;

        for (int index = 1; index <= 100; index++) {
          if (index % 2 == 0) {result=result+index;}

        }

     System.out.println(result);
    }
    }
