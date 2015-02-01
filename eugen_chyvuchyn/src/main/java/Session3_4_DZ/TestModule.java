package Session3_4_DZ;


/**
 * Created by Chuvychin on 22.01.2015.
 */
public class TestModule {
    User usertest1 = new User();
    User usertest2 = new User("Ivan", "12345pass");
    User usertest3 = new User("Иван", "пароль на русском, втф??? О_О");


    public static void main (String[]args){
        TestModule test = new TestModule();

        System.out.println(test.testHash());
        System.out.println(test.testEquals());
       }

    public boolean testEquals(){
        usertest2.setRating(100);
        usertest3.setSex("М");
        User usertestequals = new User();

        if (usertest1.equals(usertest2) == true){
            System.out.println("333");
            return false;
        }

        if (usertest1.equals(usertest2) == true || usertest1.equals(usertest3) == true || usertest2.equals(usertest3) == true){
            System.out.println("1");
            return false;
        }
        if (usertestequals.equals(usertest1)==true){
            System.out.println("2");
            return false;
        }

        if (usertest2.equals(usertest2)==true && usertest3.equals(usertest3)==true && usertestequals.equals(usertestequals) == true && usertest1.equals(usertest1) == true){
            return true;
        }
       return false;
    }

    public boolean testHash() {


            try {
                int result1 = usertest1.getDate().hashCode();
                result1 = 31 * result1 + usertest1.getPass().hashCode() + usertest1.getLogin().hashCode() + usertest1.getSex().hashCode();

                if (result1 != usertest1.hashCode()) {
                    System.out.println("1");
                    return false;
                }

                int result2 = usertest2.getDate().hashCode();
                result2 = 31 * result2 + usertest2.getPass().hashCode() + usertest2.getLogin().hashCode() + usertest2.getSex().hashCode();

                if (result2 != usertest2.hashCode()) {
                    System.out.println("2");
                    return false;
                }
                int result3 = usertest3.getDate().hashCode();
                result3 = 31 * result3 + usertest3.getPass().hashCode() + usertest3.getLogin().hashCode() + usertest3.getSex().hashCode();

                if (result3 != usertest3.hashCode()) {
                    System.out.println("3");
                    return false;
                }
            } catch (NullPointerException es){

                int result1 = usertest1.getDate().hashCode()*31;
                if (result1 != usertest1.hashCode()) {
                    System.out.println("4");
                    return false;
                }
                int result2 = usertest2.getDate().hashCode()*31;
                if (result2 != usertest2.hashCode()){
                    System.out.println("5");
                    return false;
                }
                int result3 = usertest3.getDate().hashCode()*31;
                if (result3 != usertest1.hashCode()){
                    System.out.println("6");
                    return false;
                }
            }

        return true;

    }


}
