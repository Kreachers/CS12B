class BubbleSortSB{
    public static void main(String[] args){
	StringBuffer data = new StringBuffer("734295816");
	System.out.println(data);
	bubbleSortSB(data);
	System.out.println(data);
    }

    public static void bubbleSortSB(StringBuffer sbuf){
	char temp;
	int bottom = sbuf.length() - 1;
	for (int top = 0; top < bottom; top++){
	    for (int i = bottom; i > top; i--){
		if (sbuf.charAt(i) < sbuf.charAt(i-1)){
		    temp = sbuf.charAt(i);
		    sbuf.setCharAt(i, sbuf.charAt(i-1));
		    sbuf.setCharAt(i-1, temp);
		}
	    }
	}
    }
}
