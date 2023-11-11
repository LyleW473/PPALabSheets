public class While
{
    public static void main(String[] args)
    {
        While test1 = new While();
        System.out.println("Result: " + test1.sum(3, 5));
        System.out.println("IsPrime: " + 1 + " " + test1.isPrime(1));
        System.out.println("IsPrime: " + 2 + " " + test1.isPrime(2));
        System.out.println("IsPrime: " + 3 + " " + test1.isPrime(3));
        System.out.println("IsPrime: " + 8 + " " + test1.isPrime(8));
        System.out.println("IsPrime: " + 12 + " " + test1.isPrime(12));
        System.out.println("IsPrime: " + 13 + " " + test1.isPrime(13));
    }

    public While()
    {
    }

    public int sum(int a, int b)
    {   
        int total = 0;
        while (a < b)
        {   
            total += a;
            a++;
        }

        return total;
    }

    public boolean isPrime(int n)
    {   
        int m = n - 1;
        while (m > 1) // Between 2 and (n - 1)
        {   
            if (n % m == 0)
            {
                return false;
            }
            m --;
        }

        return true;
    }
}