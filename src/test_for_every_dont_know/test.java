package test_for_every_dont_know;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
	public static linkList creatlnklst(String Strlst[])
	{
		linkList lnklst=new linkList();
		for(int i=0;i<Strlst.length-1;i++)
		{
			lnklst.insertnode(Strlst[i], Strlst[i+1]);
		}
		return lnklst;
	}

	public static void main(String[] args) {
		 String regex="[^\\p{Alpha}]+";
		 String localAddress="test2.txt";
		 String wordstmp;
		 String[] strArrays = null;
		try
        {
            FileInputStream fis = new FileInputStream(localAddress);
            InputStreamReader dis = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(dis);
            String strSentence="",strtemp;
             while( (strtemp = reader.readLine()) != null )  
             {
            	 strSentence=strSentence+strtemp;
             }
             dis.close();
            
             strArrays=strSentence.split(regex);
            
         }catch(IOException e)
         {
             System.out.println(e);
         }
		String str1=new String("To @ explore strange new worlds,\r\n" + 
				"To seek out new life and new civilizations?");
		String strinput="Seek to explore new and exciting synergies";//�����ַ���//Seek to explore strange new life and exciting synergies.
		String[] strspilt=str1.split(regex);//�ָ���ַ���
		linkList lnklst=creatlnklst(strArrays);//����Ҫ��1����������
		
		lnklst.displaytree();//չʾ����
		System.out.println("================Task 3================");
		lnklst.searchBridgeWords("explore","worlds");//����Ҫ��3����ѯ�ŽӴ�
		lnklst.searchBridgeWords("explore","strange");
		lnklst.searchBridgeWords("explore","happy");
		lnklst.searchBridgeWords("happy","worlds");
		lnklst.searchBridgeWords("the","assuming");
		lnklst.searchBridgeWords("package","built");
		System.out.println("================Task 4================");
		lnklst.createNewTxtBasisOfBridgeWords(strinput);//����Ҫ��4���������ַ�������ŽӴ�
		//lnklst.createNewTxtBasisOfBridgeWords("welcome to out strange worlds");//welcome to seek out strange new worlds.
		lnklst.createNewTxtBasisOfBridgeWords("The java API is  of the  the package, "
				+ "depending  who built the  you are using.");
		lnklst.createNewTxtBasisOfBridgeWords("you  a spell over my  and every time I'm  your hand");
		//									   The java API is part of the  the package, 
		//		   depending on who built the package you are using.
		System.out.println("================Task 5================");
		lnklst.shortestroad("to","new");//����Ҫ��5����ѯ���·��
		lnklst.shortestroad("to","and");		
		lnklst.shortestroad("to","seek");	
		lnklst.shortestroad("seek","to");	
		lnklst.shortestroad("seek","civilizations");
		System.out.println("================Task 6================");
		for(int i=0;i<10;i++)//����Ҫ��6���������
		{
			System.out.print("��"+(int)(i+1)+"�α���	");
			lnklst.randomvisit();
		}
		//Proba p = new Proba();
		//p.start();
		//p.start2();
		 
		

		return;
	}
}
