package test_for_every_dont_know;

public class Node {
	final static int nodeLength=50; //���ڵ�����
	protected boolean visitflag;//���ʱ�־
	protected Node next[];		//ָ����
	protected String data,weightparent[];//data �ַ�������//weightparent���ڵ���Ϣ��Ӧweightnum
	protected int weightnum[],number,visitcount,selfvisitcount;//weightnum���Ը�ָ��Ĵ���,��Ȩ�ض�Ӧweightparent//number ��ָ��ĸ���//visitcount�ڵ㱻���ʵĸ���//selfvisitcount�������ʵĴ�����¼�������޸�visitflag
	public Node(String str)
	{
		this.data=str;
		number=0;
		weightnum=new int[nodeLength];
		weightparent=new String[nodeLength];
		next=new Node[nodeLength];
		visitflag=false;
		visitcount=0;
		selfvisitcount=0;
		for(int i=0;i<nodeLength;i++)
		{
			next[i]=null;
			weightnum[i]=0;
			weightparent[i]="";
		}
	}
}
