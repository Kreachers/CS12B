//demo of swapping chars at two locations in a StringBuffer
class SwapInStringBuf {
    public static void main(String[] args){
	StringBuffer sbuf = new StringBuffer("abcdef");
	int i=2, j=4; //locations to be swapped

	System.out.println(sbuf); //picture before swap

	char temp;
	temp = sbuf.charAt(j);
	sbuf.setCharAt(j, sbuf.charAt(i));
	sbuf.setCharAt(i, temp);

	System.out.println(sbuf); //picture after swap
    }
}
