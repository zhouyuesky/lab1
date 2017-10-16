//b1
package test_for_every_dont_know;

public class Node {
	final static int nodeLength=50; //最大节点数量
	protected boolean visitflag;//访问标志
	protected Node next[];		//指针域
	protected String data,weightparent[];//data 字符串数据//weightparent父节点信息对应weightnum
	protected int weightnum[],number,visitcount,selfvisitcount;//weightnum来自父指针的次数,即权重对应weightparent//number 子指针的个数//visitcount节点被访问的个数//selfvisitcount自身被访问的次数记录，用于修改visitflag
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
