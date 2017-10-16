//CHANGE
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
		String strinput="Seek to explore new and exciting synergies";//输入字符串//Seek to explore strange new life and exciting synergies.
		String[] strspilt=str1.split(regex);//分割后字符串
		linkList lnklst=creatlnklst(strArrays);//功能要求1：创建链表
		
		lnklst.displaytree();//展示链表
		System.out.println("================Task 3================");
		lnklst.searchBridgeWords("explore","worlds");//功能要求3：查询桥接词
		lnklst.searchBridgeWords("explore","strange");
		lnklst.searchBridgeWords("explore","happy");
		lnklst.searchBridgeWords("happy","worlds");
		lnklst.searchBridgeWords("the","assuming");
		lnklst.searchBridgeWords("package","built");
		System.out.println("================Task 4================");
		lnklst.createNewTxtBasisOfBridgeWords(strinput);//功能要求4：对输入字符串添加桥接词
		//lnklst.createNewTxtBasisOfBridgeWords("welcome to out strange worlds");//welcome to seek out strange new worlds.
		lnklst.createNewTxtBasisOfBridgeWords("The java API is  of the  the package, "
				+ "depending  who built the  you are using.");
		lnklst.createNewTxtBasisOfBridgeWords("you  a spell over my  and every time I'm  your hand");
		//									   The java API is part of the  the package, 
		//		   depending on who built the package you are using.
		System.out.println("================Task 5================");
		lnklst.shortestroad("to","new");//功能要求5：查询最短路径
		lnklst.shortestroad("to","and");		
		lnklst.shortestroad("to","seek");	
		lnklst.shortestroad("seek","to");	
		lnklst.shortestroad("seek","civilizations");
		System.out.println("================Task 6================");
		for(int i=0;i<10;i++)//功能要求6：随机遍历
		{
			System.out.print("第"+(int)(i+1)+"次遍历	");
			lnklst.randomvisit();
		}
		//Proba p = new Proba();
		//p.start();
		//p.start2();
		 
		

		return;
	}
}
