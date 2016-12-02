public class KeyNotFoundException extends RuntimeException{
  public KeyNotFoundException() {
    System.out.println("cannot delete non-existent key");
  }
}
