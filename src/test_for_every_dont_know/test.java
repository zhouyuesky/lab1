package test_for_every_dont_know;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**.
* javadoc
*/
public class Test {
/**.
* javadoc
* @param strlst strlst
* @return a Linkst
*/
public static linkList creatlnklst(final String[] strlst) {
    linkList lnklst = new linkList();
    for (int i = 0; i < strlst.length - 1; i++) {
     lnklst.insertnode(strlst[i], strlst[i + 1]);
    }
    return lnklst;
}
/**.
* javadoc
* @param args args
*/
public static void main(final String[] args) {
	Scanner in = new Scanner(System.in);
	in.next();
	int count = 0;
	while(count++ < 50){
		    String regex = "[^\\p{Alpha}]+";
		 String localAddress = "test2.txt";
		 //String wordstmp;
		 String[] strArrays = null;
		try {
		    FileInputStream fis = new FileInputStream(localAddress);
		    InputStreamReader dis = new InputStreamReader(fis);
		    BufferedReader reader = new BufferedReader(dis);
		    String strSentence = "";    
		    String strtemp = reader.readLine();
		    while (strtemp != null) {
		         strSentence = strSentence + strtemp;
		         strtemp = reader.readLine();
		     }
		     dis.close();
		
		     strArrays = strSentence.split(regex);
		
		 } catch (IOException e) {
		     System.out.println(e);
		 }
		String str1 = new String("To @ explore strange new worlds,\r\n"
		 + "To seek out new life and new civilizations?");
		String strinput = "Seek to explore new and exciting synergies";
		//�����ַ���//Seek to explore strange new life and exciting synergies.
		@SuppressWarnings("unused")
		String[] x = str1.split(regex); //�ָ���ַ���
		if (strArrays != null) {
		linkList lnklst = creatlnklst(strArrays); //����Ҫ��1����������
		
		lnklst.displaytree(); //չʾ����
		System.out.println("================Task 3================");
		lnklst.searchBridgeWords("explore", "worlds"); //����Ҫ��3����ѯ�ŽӴ�
		lnklst.searchBridgeWords("explore", "strange");
		lnklst.searchBridgeWords("explore", "happy");
		lnklst.searchBridgeWords("happy", "worlds");
		lnklst.searchBridgeWords("the", "assuming");
		lnklst.searchBridgeWords("package", "built");
		System.out.println("================Task 4================");
		lnklst.createNewTxtBasisOfBridgeWords(strinput); //����Ҫ��4���������ַ�������ŽӴ�
		
		lnklst.createNewTxtBasisOfBridgeWords("The java API is  of the  the package, "
		        + "depending  who built the  you are using.");
		lnklst.createNewTxtBasisOfBridgeWords("you  a spell over my  and"
		        + " every time I'm  your hand");
		//   The java API is part of the  the package
		//      depending on who built the package you are using.
		System.out.println("================Task 5================");
		lnklst.shortestroad("to", "new"); //����Ҫ��5����ѯ���·��
		lnklst.shortestroad("to", "and");
		lnklst.shortestroad("to", "seek");
		lnklst.shortestroad("seek", "to");
		lnklst.shortestroad("seek", "civilizations");
		System.out.println("================Task 6================");
		final int num = 10;
		for (int i = 0; i < num; i++) { //����Ҫ��6���������
		    System.out.print("��" + (int) (i + 1) + "�α���  ");
		    lnklst.randomvisit();
		}
		//Proba p = new Proba();
		//p.start();
		//p.start2();
		}
	}
	}
}
