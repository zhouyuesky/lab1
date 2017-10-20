package test_for_every_dont_know;
/**.
* javadoc
*/
public class Node {
    /**.
    * javadoc
    */
    private static final int NODE_LENGTH = 50; //���ڵ�����
    /**.
     * javadoc
     */
    //private boolean visitflag; //���ʱ�־
    private Node[] next;  //ָ����
    /**.
     * javadoc
     */
    private String[] weightparent;
    /**.
     * javadoc
     */
    private String data;
    //data �ַ�������//weightparent���ڵ���Ϣ��Ӧweightnum
    /**.
     * javadoc
     */
    private int number, visitcount, selfvisitcount;
    /**.
     * javadoc
     */
    private int[] weightnum;
    /**.
     * javadoc
     */
    private boolean visitflag;
    //weightnum���Ը�ָ��Ĵ���,��Ȩ�ض�Ӧweightparent
    //number ��ָ��ĸ���
    //visitcount�ڵ㱻���ʵĸ���
    //selfvisitcount�������ʵĴ�����¼�������޸�visitflag
    /**.
     * javadoc
     * @param str str
     */
    public Node(final String str) {
        this.setData(str);
        setNumber(0);
        setWeightnum(new int[getNodeLength()]);
        setWeightparent(new String[getNodeLength()]);
        setNext(new Node[getNodeLength()]);
        //@SuppressWarnings("unused")
        //boolean visitflag = false;
        setVisitcount(0);
        setSelfvisitcount(0);
        for (int i = 0; i < getNodeLength(); i++) {
            getNext()[i] = null;
            getWeightnum()[i] = 0;
            getWeightparent()[i] = "";
            }
        }
    /**.
     * javadoc
     * @return a Str
     */
    public String getData() {
        return data;
    }
    /**.
     * javadoc
     * @param data data
     */
    public void setData(final String data) {
        this.data = data;
    }
    /**.
     * javadoc
     */
    public String[] getWeightparent() {
        return weightparent;
    }
    /**.
     * javadoc
     */
    public void setWeightparent(String[] weightparent) {
        this.weightparent = weightparent;
    }
    /**.
     * javadoc
     */
    public int[] getWeightnum() {
        return weightnum;
    }
    /**.
     * javadoc
     */
    public void setWeightnum(int[] weightnum) {
        this.weightnum = weightnum;
    }
    /**.
     * javadoc
     */
    public Node[] getNext() {
        return next;
    }
    /**.
     * javadoc
     */
    public void setNext(final Node[] next) {
        this.next = next;
    }
    /**.
     * javadoc
     */
    public int getNumber() {
        return number;
    }
    /**.
     * javadoc
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**.
     * javadoc
     */
    public static int getNodeLength() {
        return NODE_LENGTH;
    }
    /**.
     * javadoc
     */
    public boolean isVisitflag() {
        return visitflag;
    }
    /**.
     * javadoc
     */
    public void setVisitflag(boolean visitflag) {
        this.visitflag = visitflag;
    }
    /**.
     * javadoc
     */
    public int getVisitcount() {
        return visitcount;
    }
    /**.
     * javadoc
     */
    public void setVisitcount(int visitcount) {
        this.visitcount = visitcount;
    }
    /**.
     * javadoc
     */
    public int getSelfvisitcount() {
        return selfvisitcount;
    }
    /**.
     * javadoc
     */
    public void setSelfvisitcount(int selfvisitcount) {
        this.selfvisitcount = selfvisitcount;
    }
    }
