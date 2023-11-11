public class FizzBuzz 
{
    public FizzBuzz()
    {
    }

    public static void main(String[] args)
    {
        FizzBuzz myFizzBuzz = new FizzBuzz();
        myFizzBuzz.print();
    
    }


    public void print()
    {
        
        for (int i = 0; i < 100; i++)
        {
            boolean mult3 = (i % 3 == 0);
            boolean mult5 = (i % 5 == 0);
            String result = "";
            if (mult3){result += "Fizz";}
            if (mult5){result += "Buzz";}
            System.out.println(i + " " + result);
        }
    }
}
