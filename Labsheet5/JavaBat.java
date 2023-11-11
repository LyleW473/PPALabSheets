public class JavaBat 
{

    public static void main(String[] args)
    {
        JavaBat myJavaBat = new JavaBat();
        System.out.println(myJavaBat.doubleChar("hello"));
    }

    public String doubleChar(String str)

    {   
        String result = "";
    
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++)
        {   
            for (int j = 0; j < 2; j++)
            {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
