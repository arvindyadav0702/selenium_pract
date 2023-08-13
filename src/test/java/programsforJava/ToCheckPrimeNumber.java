package programsforJava;

public class ToCheckPrimeNumber {


    public static void main(String[] args) {

        int numberToCheck = 99;
        boolean isPrime = true;
        int remainder;

        for (int i=2 ; i<= numberToCheck / 2 ; i++) {

            remainder = numberToCheck % i;
            if (remainder == 0) {
                isPrime = false;
                break;
            }
        }
            if(isPrime){
                System.out.printf(numberToCheck + " is prime number" );
            }else {
                System.out.printf(numberToCheck + " is NOT prime number" );
            }

        }

    }

