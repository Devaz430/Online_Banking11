package EmailVerify;
import java.util.regex.Pattern;
import java.util.*;

public class ValidateEmail {
    public String cl(){
        Scanner input = new Scanner(System.in);

        String email;
        do{
            System.out.println("Enter your email:");
            email = input.nextLine();

            System.out.println("email:"+Validate(email));
        }while(Validate(email).equals("Invalid"));
        return email;
    }
    public static String Validate(String email)
    {
        if(email==null||email.isEmpty())
            return("Invalid");
        String emailRegex= "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches())
            return("Valid");
        else
            return("Invalid");
    }

}

