package test_for_every_dont_know;

import java.io.File;
import java.util.Arrays;

public class linkList {
	protected Node[] nodelst;
	protected Node treeroot;
	protected int count ;
	public linkList() {
		nodelst = new Node[2*Node.getNodeLength()];
		treeroot=null;
		count=0;
	}
	public int findindex(String strlst[],String str)//Ѱ���ַ�������strlst��str������,δ�ҵ��򷵻�-1��//ָ������ʱʹ��
	{
		int i,num = -1;
		for(i=0;i<strlst.length;i++)
		{
			if(strlst[i].equalsIgnoreCase(str))
			{
				num=i;
				break;
			}
		}
		return num;
		
	}
	public int Strlength(String strlst[])//�ַ�������(����䳤��+1)//�½�ָ��ʱʹ��
	{
		int i;
		for(i=0;i<strlst.length;i++)
		{
			if(strlst[i].equalsIgnoreCase(""))
			{
				break;
			}
		}
		return i;
	}
	public int Strlength(Node[] nodelst)//�������أ�����Node����(����䳤��+1)
	{
		int top=0;
		for(int i=0;i<nodelst.length;i++)
		{
			if(nodelst[i]==null)
				{
				top=i;
				break;
				}
		}
		return top;
	}
	public Node searchnode(String str)//��nodelst��Ѱ���ַ���str��ָ�룬δ�ҵ��򷵻�null//����ָ��
	{
		Node findnode=null;
		boolean findflag=false;
		for(int i=0;i<count;i++)
		{	
			if(nodelst[i].getData().equalsIgnoreCase(str))
			{
				findnode= nodelst[i];
				findflag=true;
			}
		}
		if(findflag==true)
		{
			return findnode;
		}
		else{
			return null;
		}
	}
	public void insertnode(String str1,String str2)//�����ַ���//����1
	{
		Node tmp1;
		Node tmp2;
		if(count==0)//�տ�ʼʱ��������������
		{
			tmp1=new Node(str1);
			tmp2=new Node(str2);
			tmp2.getWeightparent()[Strlength(tmp2.getWeightparent())]=str1;
			tmp2.getWeightnum()[findindex(tmp2.getWeightparent(),str1)]++;
			tmp1.getNext()[tmp1.getNumber()]=tmp2;
			tmp1.setNumber(tmp1.getNumber() + 1);
			nodelst[0]=tmp1;
			nodelst[1]=(tmp2);
			count=2;
			treeroot=tmp1;
			//root=tmp1;
			//return root;
		}else//���ǿ�
		{
				tmp1=searchnode(str1);//Ѱ��str1ָ��
				tmp2=searchnode(str2);//Ѱ��str2ָ��
				if(tmp2==null)//δ�ҵ�str2�����½�str2ָ�벢����
				{
					tmp2=new Node(str2);
					tmp2.getWeightparent()[Strlength(tmp2.getWeightparent())]=str1;//�������ڵ���Ϣ
					tmp2.getWeightnum()[findindex(tmp2.getWeightparent(),str1)]++;//���ڵ�Ȩ��+1
					tmp1.getNext()[tmp1.getNumber()]=tmp2;//�����ӽ��
					tmp1.setNumber(tmp1.getNumber() + 1);//�ӽ�����+1
					nodelst[count]=tmp2;//���½���str2ָ���������
					count++;//�ڵ����+1
				}
				else{//�ҵ�str2����str2ָ�����ӽ�ȥ
					if(findindex(tmp2.getWeightparent(),str1)==-1)//��str1����str2���ڵ㣬��������
					{
						tmp2.getWeightparent()[Strlength(tmp2.getWeightparent())]=str1;//�������ڵ���Ϣ
						tmp2.getWeightnum()[findindex(tmp2.getWeightparent(),str1)]++;//���ڵ�Ȩ��+1
						tmp1.getNext()[tmp1.getNumber()]=tmp2;//�����ӽ��
						tmp1.setNumber(tmp1.getNumber() + 1);//�ӽ�����+1
					}
					else{//str1��str2���ڵ㣬Ȩ��+1
						tmp2.getWeightnum()[findindex(tmp2.getWeightparent(),str1)]++;//Ȩ��+1
					}
					//tmp2.weightparent[Strlength(tmp2.weightparent)]=str1;
				}
		}
		
		//return root;
		
	}
	public int indexOfNodeInlst(String str)//��Node�����з���str������
	{
		int tmp=-1;
		for(int i=0;i<count;i++)
		{
			if(nodelst[i].getData().equalsIgnoreCase(str))
			{
				tmp=i;
			}
		}
		return tmp;
	}
	public Node[] searchroad(String str1,String str2,Node visitlst[])//����·�Ƿ���ڣ�����ǣ�����·���ڵ����飨���򣩣�û�еĻ�����������Ϊstr1�ڵ���߿�����
	{
		if(indexOfNodeInlst(str1)==-1)//�ڵ㲻���ڣ����ؿ�����
		{
			//System.out.println("the string "+str1+"not exiet");
			return visitlst;
		}
		if(indexOfNodeInlst(str2)==-1)//�ڵ㲻���ڣ����ؿ�����
		{
			//System.out.println("the string "+str2+"not exiet");
			return visitlst;
		}
		if(indexOfNodeInlst(str1)>indexOfNodeInlst(str2))//seek->to·�������ڣ����ؿ�����
		{
			//System.out.println("No bridge words from "+str1+" to "+str2+"!");
			return visitlst;
		}
		else
		{
			Node p;
			//Node visitlst[]=new Node[Node.nodeLength];
			int top=0;
			visitlst[0]=nodelst[indexOfNodeInlst(str1)];
			p=visitlst[0];
			p.setVisitflag(true);
			do{										//Ѱ��·��
				if(p.getVisitcount()<p.getNumber())
				{
					if(p.getNext()[p.getVisitcount()].isVisitflag()==false)
					{
						p.setVisitcount(p.getVisitcount() + 1);
						p=p.getNext()[p.getVisitcount()-1];
						top++;
						visitlst[top]=p;
						p.setVisitflag(true);
					}
					else{
						p.setVisitcount(p.getVisitcount() + 1);
					}
					
					
				}
				else{
					if(top!=0)
					{
						top--;
						p=visitlst[top];
					}
					else
					{
						return visitlst;
					}
				}
			}while(!str2.equalsIgnoreCase(p.getData()));
			for(int i=top+1;i<visitlst.length;i++)//��շ�·������
			{
				visitlst[i]=null;
			}
			for(int i=0;i<Strlength(nodelst);i++)//�ָ����ʱ�־Ϊfalse��Ϊ�´η�����׼��
			{
				nodelst[i].setVisitflag(false);;
				nodelst[i].setVisitcount(0);
			}
		return visitlst;
		}
	}//searchroad
	public void displaytree()//����2 չʾͼ
	{
		String type = "jpg";
		GraphViz gv = new GraphViz();
	    gv.addln(gv.startgraph());
	    for(int i=0;i<count;i++)
	    {
	    	for(int j=0;j<nodelst[i].getNumber();j++)
	    	{
	    		//if(nodelst[i].!=0)
	    		//{
	    			gv.addlnlabel(nodelst[i].getData()+"->"+nodelst[i].getNext()[j].getData(),""+nodelst[i].getNext()[j].getWeightnum()[findindex(nodelst[i].getNext()[j].getWeightparent(),nodelst[i].getData())]);
	    		//}
	    	}
	    }
	    gv.addln(gv.endgraph());
	    File out = new File("F:\\EclipseWorkspace\\test_for_every_dont_know\\out." + type);    // Windows
	    //System.out.println(gv.getDotSource());
	    byte[] temp=gv.getGraph( gv.getDotSource(), type );
	    //System.out.println(temp);
	    gv.writeGraphToFile( temp, out );
	}
	public void searchBridgeWords(String str1,String str2)//����3��ѯ�ŽӴ�
	{
		int visitnodenum=2*Node.getNodeLength(),top = 0,findin1,findin2;
		Node visitlst[]=new Node[visitnodenum];
		Arrays.fill(visitlst,null);
//		for(int i=0;i<visitnodenum;i++)
//		{
//			visitlst[i]=null;
//		}
		findin1=indexOfNodeInlst(str1);
		findin2=indexOfNodeInlst(str2);
		if(findin1==-1&&findin2==-1)
		{
			System.out.println("No ��"+str1+"�� and ��"+str2+"�� in the graph"); 
			return;
		}
		else if(findin1==-1)
		{
			System.out.println("No ��"+str1+"�� in the graph");
			return;
		}
		else if(findin2==-1)
		{
			System.out.println("No ��"+str2+"�� in the graph");
			return;
		}
		visitlst=searchroad(str1,str2,visitlst);//����·����������searchroad���·������
		for(int i=0;i<visitnodenum;i++)
		{
			if(visitlst[i]==null){
				top=i;
				break;
			}
		}
		//System.out.println("================Task 3================");
		if(top<=2)
		{
			System.out.println("No bridge words from "+str1+" to "+str2+"!");
		}
		else
		{
			System.out.println("The bridge words from "+ str1+ " to "+ str2+" are: ");
			for(int i=1;i<top-1;i++)
			{
				System.out.print(visitlst[i].getData());
				if(i!=top-2)
				{
					System.out.print(",");
				}
				else{
					System.out.println(".");
				}
			}
		}
		return;
	}//searchBridgeWords

	public void createNewTxtBasisOfBridgeWords(String strinput)//����4����bridge word�������ı�
	{
		String regex="[^\\p{Alpha}]+";
		String[] strspilt=strinput.split(regex);
		String[] strout=new String[(int)(10*strspilt.length)];
		Arrays.fill(strout,"");
//		for(int i=0;i<strout.length;i++){
//			strout[i]="";
//		}
		String[] strtmp=new String[Node.getNodeLength()];
		Arrays.fill(strtmp,"");
//		for(int i=0;i<strtmp.length;i++){
//			strtmp[i]="";
//		}
		Node[] strnodetmp=new Node[Node.getNodeLength()];
//		for(int i=0;i<strnodetmp.length;i++)
//		{
//			strnodetmp[i]=null;
//		}
		strout[0]=strspilt[0];
		int nodetmplength;
		for(int i=0;i<strspilt.length-1;i++)
		{
			strnodetmp=searchroad(strspilt[i],strspilt[i+1],strnodetmp);//����·����������searchroad���·������
			nodetmplength=Strlength(strnodetmp);//·�����鳤��
			if(nodetmplength<=2)//����<=2�������Ӵ�
			{
				strout[Strlength(strout)]=strspilt[i+1];//��Ӵ���
				continue;
			}
			else//�����Ӵ�
			{
				for(int j=0;strnodetmp[j]!=null;j++)
				{
					strtmp[j]=strnodetmp[j].getData();
				}
				for(int k=1;!"".equals(strtmp[k]);k++)//��Ӵ���
				{
					strout[Strlength(strout)]=strtmp[k];
				}
				for(int j=0;j<Strlength(strnodetmp);j++)
				{
					strnodetmp[j]=null;
				}
			}
		}
		//System.out.println("================Task 4================");
		for(int i=0;i<Strlength(strspilt);i++)
		{
			System.out.print(strspilt[i]);
			if(i!=Strlength(strspilt)-1)
			{
				System.out.print(" ");
			}
			else{
				System.out.println(".");
			}
		}
		for(int i=0;i<Strlength(strout);i++)
		{
			System.out.print(strout[i]);
			if(i!=Strlength(strout)-1)
			{
				System.out.print(" ");
			}
			else{
				System.out.println(".");
			}
		}
		for(int i=0;i<strout.length;i++){
			strout[i]="";
		}
	}//createNewTxtBasisOfBridgeWords
	public boolean isallvisited()//�ж��Ƿ�ȫ�������ʹ�
	{
		boolean flag=true;
		for(int i=0;i<Strlength(nodelst);i++)
		{
			if(nodelst[i].isVisitflag()==false)
			{
				flag=false;
				break;
			}
		}
		return flag;
		
	}
	public void shortestroad(String str1,String str2)//��������5��������������֮������·��
	{
		Node resultlst[][] = new Node[Node.getNodeLength()][];
		for(int i=0;i<Node.getNodeLength();i++)
		{
			resultlst[i]=new Node[2*Node.getNodeLength()];
		}
		Node tmpnode[] = new Node[2*Node.getNodeLength()],minroad[][]=new Node[Node.getNodeLength()][];
		for(int i=0;i<Node.getNodeLength();i++)
		{
			minroad[i]=new Node[2*Node.getNodeLength()];
		}
		int count=0;
		int maxofallroads;
		boolean allnodevisitflag;//ȫ����ʱ�־������־Ϊtrue��ʾȫ��ڵ㱻����
		tmpnode=searchroad(str1,str2,tmpnode);
		if(Strlength(tmpnode)>2)
		{
			resultlst[0]=tmpnode;
			do{
				for(int i=0;i<=count;i++)//���Ѿ���õ�·����ӷ��ʹ��ı�־
				{
					for(int j=1;j<Strlength(resultlst[i])-1;j++)
					{
						resultlst[i][j].setSelfvisitcount(resultlst[i][j].getSelfvisitcount()+1);
						if(resultlst[i][j].getNumber()==resultlst[i][j].getSelfvisitcount())
						{
							resultlst[i][j].setVisitflag(true);
						}
						else{
							break;
						}
					}//break;
				}
				allnodevisitflag=isallvisited();//���ȫ����ʱ�־
				tmpnode=new Node[2*Node.getNodeLength()];
				if(allnodevisitflag==false)//����ȫ�嶼�����ʣ������·������
				{
					tmpnode=searchroad(str1,str2,tmpnode);//����·����������searchroad���·������
				}
				if(Strlength(tmpnode)>2)//��·�����ڣ���·�����������·��
				{
					count++;
					resultlst[count]=tmpnode;
					tmpnode=new Node[2*Node.getNodeLength()];
				}
				else{
					allnodevisitflag=true;//·�������ڣ���ȫ����ʱ�־��Ϊtrue����ʾ���ʽ�������ʱ����ѭ��
				}
				for(int i=0;i<Strlength(nodelst);i++)
				{
					nodelst[i].setVisitcount(0);
					nodelst[i].setVisitflag(false);
					nodelst[i].setSelfvisitcount(0);
				}
			}while(allnodevisitflag==false);
			maxofallroads = count+1;//ð������
			if(maxofallroads>1)
			{
				for(int i=0;i<maxofallroads;i++)
				{
					for(int j=0;j<=maxofallroads-j-1;j++)
					{
						if(Strlength(resultlst[j])>=Strlength(resultlst[j+1])){
							tmpnode=resultlst[j];
							resultlst[j]=resultlst[j+1];
							resultlst[j+1]=tmpnode;
						}
					}
				}
			}
			
			int minroadlength=Strlength(resultlst[0]);
			if(maxofallroads==1)
			{
				System.out.println("********The road between ��"+str1+"�� and ��"+str2+"�� is:    ");
			}
			else{
				System.out.println("********The "+maxofallroads+" roads between ��"+str1+"�� and ��"+str2+"�� are:    ");
			}
			for(int i=0;i<maxofallroads;i++)
			{
				if(Strlength(resultlst[i])==minroadlength)
				{
					for(int j=0;j<Strlength(resultlst[i]);j++)
					{
						System.out.print(resultlst[i][j].getData());
						if(j!=Strlength(resultlst[i])-1)
						{
							System.out.print("->");
						}
						else{
							System.out.print(".");
							//System.out.println();
						}
					}
					
				}
				else{
					break;
				}
				System.out.println();
			}
			
		}
		else{
			System.out.println("********There is no road between ��"+str1+"�� and ��"+str2+"��");
		}
		for(int i=0;i<Strlength(nodelst);i++)
		{
			
			nodelst[i].setVisitcount(0);
			nodelst[i].setVisitflag(false);
			nodelst[i].setSelfvisitcount(0);
		}
		allnodevisitflag=false;
		count=0;
		for(int i=0;i<Node.getNodeLength();i++)
		{
			resultlst[i]=new Node[2*Node.getNodeLength()];
		}
		return;
		//System.out.println("================Task 5================");
		
	}//shortestroad
	public void randomvisit()
	{
		int randhead,randinttmp;
		randhead=(int)(Math.random()*count);
		Node randomroot=nodelst[randhead];
		String randomVisitRoad[]=new String[count*2];
		for(int i=0;i<randomVisitRoad.length;i++){
			randomVisitRoad[i]="";
		}
		Node p,q;
		boolean allvisitofnodelst=false;
		Node visitlst[]=new Node[2*Node.getNodeLength()];
		int top=0;
		visitlst[0]=randomroot;
		p=visitlst[0];
		randomVisitRoad[Strlength(randomVisitRoad)]=p.getData();
		p.setSelfvisitcount(p.getSelfvisitcount() + 1);
		if(p.getSelfvisitcount()==p.getNumber())
		{
			p.setVisitflag(true);
		}
		do{
			if(!allvisitofnodelst)
			{
				randinttmp=(int)(Math.random()*p.getNumber());
				if(p.getNumber()==0)
				{
					allvisitofnodelst=true;
				}
				else if(p.getNext()[randinttmp].isVisitflag()==false)
				{
					p.setVisitcount(p.getVisitcount() + 1);
					p=p.getNext()[randinttmp];
					randomVisitRoad[Strlength(randomVisitRoad)]=p.getData();
					p.setSelfvisitcount(p.getSelfvisitcount() + 1);
					if(p.getSelfvisitcount()==p.getNumber())
					{
						p.setVisitflag(true);
					}
					top++;
					visitlst[top]=p;
				}
				else{
					p=p.getNext()[randinttmp];
					randomVisitRoad[Strlength(randomVisitRoad)]=p.getData();
					allvisitofnodelst=true;
				}
			}

		}while(!allvisitofnodelst);
		//System.out.println("================Task 6================");
		for(int i=0;i<Strlength(randomVisitRoad);i++)
		{
			System.out.print(randomVisitRoad[i]);
			if(i!=Strlength(randomVisitRoad)-1)
			{
				System.out.print("->");
			}
			else{
				System.out.println(".");
			}
		}
		for(int i=0;i<Strlength(nodelst);i++)
		{
			nodelst[i].setVisitcount(0);
			nodelst[i].setVisitflag(false);
			nodelst[i].setSelfvisitcount(0);
		}
		
	}//randomWalk
}//linkList
