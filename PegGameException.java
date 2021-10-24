package peggame;
public class PegGameException extends Exception {
        public PegGameException (){
            super("Invalid Move Detected");
        }
        public PegGameException (String message){
            super(message);
        }
}
