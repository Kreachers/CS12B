public class DuplicateKeyException extends RuntimeException{
  public DuplicateKeyException() {
    System.out.println( "cannot insert duplicate keys");
  }
}
