// demo StringBuffer methods
class StringBufferTest{
    public static void main(String[] args){
	StringBuffer sbuf1 = new StringBuffer();
	StringBuffer sbuf2 = new StringBuffer("abcd");
	StringBuffer sbuf3 = new StringBuffer(30);

	System.out.println(sbuf1.length());
	System.out.println(sbuf2.length());
	System.out.println(sbuf3.length());

	System.out.println(sbuf1.capacity());
	System.out.println(sbuf2.capacity());
	System.out.println(sbuf3.capacity());

	System.out.println(sbuf2.charAt(1));

	sbuf2.setCharAt(2, 'Z');
	System.out.println(sbuf2);

	sbuf2.append("xyz");
	System.out.println(sbuf2);

	sbuf2.append('?');
	sbuf2.insert(4, "---");
	sbuf2.insert(2, '+');
	System.out.println(sbuf2);

	sbuf2.reverse();
	System.out.println(sbuf2);

	System.out.println("sbuf2 capacity " + sbuf2.capacity());
	System.out.println("sbuf2 length " + sbuf2.length());
    }
}
