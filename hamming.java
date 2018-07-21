import java.io.*;
import java.util.*;

public class hamming{
	public static void main(String[]args){
	//variable
	String checked_bit,bit,check="";
	Scanner sc;
	char[] char_bit=new char[11];
	int check_error_bit=0,r8_total=0,r4_total=0,r1_total=0,r2_total=0,check_r8=0,check_r4=0,check_r2=0,check_r1=0,sum=0;
	hamming hamming=new hamming();
	
	checked_bit=hamming.mustinsert11();
	char_bit=hamming.convertotchar(checked_bit);
	r1_total=hamming.r1(char_bit);
	check_r1=hamming.remaining(r1_total,1);
	
	r2_total=hamming.r2(char_bit);
	check_r2=hamming.remaining(r2_total,2);
	
	r4_total=hamming.r4(char_bit);
	check_r4=hamming.remaining(r4_total,4);
	
	r8_total=hamming.r8(char_bit);
	check_r8=hamming.remaining(r8_total,8);
	sum=check_r1+check_r2+check_r4+check_r8;
	System.out.println("Error bit in the position "+sum);
	}
	
	//method
	public String mustinsert11(){
	Scanner sc;
	String bit;
	do{
	do{
	System.out.println("insert only 11 bit");
	sc=new Scanner(System.in);
	bit=sc.nextLine();
	}while(bit.length()!=11);
	}while(
	bit.toLowerCase().contains("a")||bit.toLowerCase().contains("b")||bit.toLowerCase().contains("c")||bit.toLowerCase().contains("d")||bit.toLowerCase().contains("e")
	||bit.toLowerCase().contains("f")||bit.toLowerCase().contains("g")||bit.toLowerCase().contains("h")||bit.toLowerCase().contains("i")||bit.toLowerCase().contains("j")
	||bit.toLowerCase().contains("k")||bit.toLowerCase().contains("l")||bit.toLowerCase().contains("m")||bit.toLowerCase().contains("n")||bit.toLowerCase().contains("o")
	||bit.toLowerCase().contains("p")||bit.toLowerCase().contains("q")||bit.toLowerCase().contains("r")||bit.toLowerCase().contains("s")||bit.toLowerCase().contains("t")||bit.toLowerCase().contains("u")||bit.toLowerCase().contains("v")
	||bit.toLowerCase().contains("w")||bit.toLowerCase().contains("x")||bit.toLowerCase().contains("y")||bit.toLowerCase().contains("z")||bit.toLowerCase().contains("2")||bit.toLowerCase().contains("3")||bit.toLowerCase().contains("4")
	||bit.toLowerCase().contains("5")||bit.toLowerCase().contains("6")||bit.toLowerCase().contains("7")||bit.toLowerCase().contains("8")||bit.toLowerCase().contains("9"));
	return bit;
	}
	
	public char[] convertotchar(String checked_bit){
	char[] char_bit=new char[11];
	int a=0;
	while(a<11){
	char_bit[a]=checked_bit.charAt(a);
	System.out.println(char_bit[a]);
	a++;
	}
	return char_bit;
	}
	
	public int r1(char[] char_bit){
	int[] r1={0,2,4,6,8,10};
	int a=0;
	int r1_total=0;
	while(a<6){
	r1_total+=Character.getNumericValue(char_bit[r1[a]]);
	a++;
	}
	return r1_total;
	}	
		
	public int r2(char[] char_bit){
	int[] r2={1,2,5,6,9,10};
	int a=0;
	int r2_total=0;
	while(a<6){
	System.out.println("a"+char_bit[r2[a]]);
	r2_total+=Character.getNumericValue(char_bit[r2[a]]);
	a++;
	}
	return r2_total;
	}	
	
	public int r4(char[] char_bit){
	int[] r4={3,4,5,6};
	int a=0;
	int r4_total=0;
	while(a<4){
	r4_total+=Character.getNumericValue(char_bit[r4[a]]);
	a++;
	}
	return r4_total;
	}	
		
	public int r8(char[] char_bit){
	int[] r8={7,8,9,10};
	int a=0;
	int r8_total=0;
	while(a<4){
	r8_total+=Character.getNumericValue(char_bit[r8[a]]);
	a++;
	}
	return r8_total;
	}
	
	public int remaining(int total,int multiple){
	int divided;
	if((total%2)==0){
	divided=0;
	}else{
	divided=1*multiple;
	}
	return divided;
	}
}