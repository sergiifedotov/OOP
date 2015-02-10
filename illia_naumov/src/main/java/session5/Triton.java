package session5;

/**
 * Created by user on 24.01.2015.
 */
    public class Triton{
    public static void main(String[] args) {
        Triton tr1 = Triton.getinstance();
        Triton tr2 = Triton.getinstance();
        Triton tr3 = Triton.getinstance();
        Triton tr4 = Triton.getinstance();
    }
        public static int count = 0;
        private static Triton instance;
        private Triton(){

        }
        public synchronized static Triton getinstance(){
            if(instance == null | count < 3){

                    instance = new Triton();
                    count++;

                } else {
                    System.err.println("Уже создано 3 тритона");
                }

            return instance;
        }
    }


