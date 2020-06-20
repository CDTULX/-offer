import java.util.*;

public class Solution {
    public String replaceSpace(StringBuffer str) {
      /*  String[] strings=str.toString().split(" ");
        String str1="";
        for (int i=0;i<strings.length;i++){
            str1=str1+strings[i]+"%20";

        }
        return str1;*/
        char cc=' ';
        String str1="";
        char[] chars=str.toString().toCharArray();
        char[] c=" ".toCharArray();
        for (int i=0;i<chars.length;i++){
           if (chars[i] == cc){
               str1=str1+"%20";
           }else  str1=str1+chars[i];
        }
        return str1;
    }


    public boolean Find(int target, int [][] array) {
        int i=0;
        int j=array[0].length-1;
        while (i<=array.length-1&&j>=0){
            if (target>array[i][j]) i++;
            else if (target<array[i][j])j--;
            else if (target==array[i][j])return true;

        }

        return false;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     *
     用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     * @param node
     */
    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());

        }
        return stack2.pop();
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n>2){
            int[] number=new int[n+1];
            number[0]=1;
            number[1]=1;
            for (int i=2;i<n;i++){
                number[i]=number[i-1]+number[i-2];
            }
            return number[n-1];
        }
        else if (n==0 ) return 0;
        else return 1;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target==1){
            return 1;
        }
        if (target ==2 ){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {

        if (target==1){
            return 1;
        }
        if (target <=0 ){
            return -1;
        }
        return 2*JumpFloorII(target-1);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target<1)return 0;
        if (target==1){
            return 1;
        }else if (target==2){
            return 2;
        }else {
            return RectCover(target-1)+RectCover(target-2);
        }

    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *  // HD, Figure 5-2
     *         i = i - ((i >>> 1) & 0x55555555);
     *         i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
     *         i = (i + (i >>> 4)) & 0x0f0f0f0f;
     *         i = i + (i >>> 8);
     *         i = i + (i >>> 16);
     *         return i & 0x3f;
     * @param n
     * @return
     */
    public int NumberOf1(int n) {

            return Integer.bitCount(n);

    }
    public int NumberOf2(int n) {
        //>>>：无符号右移。无论正数还是负数，高位通通补0.
        //>>:带符号右移。正数右移高位补0，负数右移高位补1。比如
        //0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
        //
        //0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
        //
        //0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
        //
        //0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)
        //
        //x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
        //
        //0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
        System.out.println(n>>1);
        System.out.println(n<<1);
        System.out.println(n& 0x55555555);
        return 1;

    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * 保证base和exponent不同时为0
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if(exponent==0)
            return 1;
        if (base==0)
            return 0;
        double type=base;
        if (exponent>0){

            for (int i=1;i<exponent;i++){
                base=base*type;}

        }else {

          for (int i=1;i<0-exponent;i++){
              base=base*type;
          }
          return (double)1/base;


        }

        return base;
    }

    /**
     * 题目描述
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public void reOrderArray(int [] array) {
        List<Integer> odd=new ArrayList<Integer>();
        List<Integer> even=new ArrayList<Integer>();
        for (int i=0;i<array.length;i++){
            if (array[i]%2==1){
                odd.add(array[i]);
            }else even.add(array[i]);
        }
        Integer[] a=odd.toArray(new Integer[odd.size()]);
        Integer[] b=even.toArray(new Integer[even.size()]);
        for (int i=0;i<a.length;i++){
            array[i]=a[i];
        }
        for (int i=0;i<b.length;i++){
            array[i+a.length]=b[i];
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0){
            return null;
        }
        ListNode one=head;
        ListNode two=head;
        for (int i=1;i<k;i++){
            if (one.next==null)return null;
            one=one.next;
        }
        while (one.next!=null){
            one= one.next;
            two=two.next;
        }
        return two;

    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode next=null;
        ListNode pre=null;
        while (head!=null){
            next=head.next;

            head.next=pre;
            pre=head;

            head=next;
        }

        return pre;

    }


    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1==null)return list2;
        if (list2==null)return list1;
            if (list1.val<=list2.val){

                list1.next=Merge(list1.next,list2);
                return list1;
            }else{

                list2.next=Merge(list1,list2.next);
                return list2;
            }

    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        if (num1>=0&&num2>=0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < num1; i++) {
                list.add("s");
            }
            for (int i = 0; i < num2; i++) {
                list.add("s");
            }
            System.out.println(list.size());
        }
        return 0;
    }

    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     * @param str
     * @return
     */
    public int StrToInt(String str) {
return 0;
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum=n;
        /*i==0 ? (i =i+ Sum_Solution(n-1)):i=i;*/
       // boolean ans=(n>0) && ((sum+=Sum_Solution(n-1))>0);
        sum=(n>0)?(sum+=Sum_Solution(n-1)):sum;
        return sum;

    }

    /**
     * 随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列并且不再回到圈中,从他的下一个开始,继续0...m-1报数
     * 直到剩下最后一个小朋友,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     *
     * 如果没有小朋友，请返回-1
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        /*int last=n;
        Map<Integer,Boolean> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(i,true);
        }
        while (last<1){
            for (int i=0;i<n;i++){

            }
            n--;
        }*/
        /*if (n<=0)return -1;

        int now=0;
        int all=n;
        for (int i=0;i<all-1;i++){

        }*/
        /*List<ListNode> listNodes=new ArrayList<>();*/
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        int start = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size(); // 【A】
            }
            list.remove(idx);

        }
        return list.get(0);
    }

    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str==null)return null;
        String[] strings=str.split(" ");
        if (strings.length==0)return str;
        for (int i=0;i<strings.length;i++) System.out.println(strings[i]);
        //String s="";
        for (int i=strings.length;i>0;i--){
            System.out.println(strings[i-1]);
           // s=s+strings[i];
        }
        return null;
    }

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        char[] chars=str.toCharArray();
        if (chars.length==0){
            String s="";
            for (int i=0;i<n;i++){
                s+=s;
            }
            return s;
        }
        String s="";

        int m=n%(chars.length);

       /* for (i;i<chars.length+m-1;i++){
            s=s+chars[i];
        }*/
        for (int i=m-1;i<chars.length+m-1;i++){
            s=s+chars[i%chars.length];
        }
        return s;

    }

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<Integer> sout=new ArrayList<>();

        for (int i=0;i<array.length&&array[i]<sum;i++){
            for (int j=array.length-1;j>i;j--){
                if (array[i]+array[j]==sum){
                    arrayList.add(array[i]);
                    arrayList.add(array[j]);
                }
            }
        }
        int min=999;
        sout.add(1);
        sout.add(2);
        if (arrayList.size()==2||arrayList.size()==0)return arrayList;
        for (int i=0;i<arrayList.size();i+=2){
            if (arrayList.get(i)*arrayList.get(i+1)<min){
                sout.remove(0);
                min=arrayList.get(i)*arrayList.get(i+1);
                sout.remove(0);
                sout.add(arrayList.get(i));
                sout.add(arrayList.get(i+1));
            }
        }
        /*{        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                int i=o1>o2?1:-1;
                return i;
            }
        });*/
        return sout;
    }

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
     * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
     * 的找出所有和为S的连续正数序列? Good Luck!
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> returnArry=new ArrayList<ArrayList<Integer>>();
        if (sum<=1)return returnArry;
        int theSum=0;
        for (int i=1;i<100;i++) {
            for (int j=i;theSum<100||j<100;j++){
                theSum+=j;
                if (theSum==sum){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    for (int n=i;n<j;n++){
                        arrayList.add(n);
                    }
                    if (arrayList.size()>=2){

                        returnArry.add(arrayList);
                    }
                }
            }
            theSum=0;
        }

        return returnArry;
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
      /*  Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
        for (int i=0;i<array.length;i++){
            if (map.get(i)==null){
                map.put(i,true);
            }
            if (map.get(i)!=null){
                map.remove(i);
            }
        }
        for (Map.Entry<Integer,Boolean> map1:map.entrySet()){
            if (num1==null){
                num1=num1+map1.getKey();
            }
        }
*/
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<array.length;i++){
            if (!arrayList.contains(array[i]))arrayList.add(array[i]);
            else arrayList.remove(new Integer(array[i]));
        }
        if (arrayList.size()>0){
            num1[0]=arrayList.get(0);
            num2[0]=arrayList.get(1);
        }


    }



     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }

     }

    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
       if (root ==null)return 0;
      int left=TreeDepth(root.left);
      int right=TreeDepth(root.right);
      return Math.max(left,right)+1;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array.length<1)return 0;
        int n=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==k)n++;
        }
        return n;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null){
            return null;
        }
        ArrayList<ListNode> arrayList=new ArrayList<>();
        ListNode node=pHead1;
        while (node!=null){
            arrayList.add(node);
            node=node.next;
        }
        while (pHead2!=null){
            if (arrayList.remove(pHead2)==true)
                return pHead2;
            pHead2=pHead2.next;
        }
        return null;
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，132,111,为 1 2 3 1 1 1
     * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if (array.length<2)return 0;
        String s=array.toString();
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i=0;i<array.length;i++){

            stringBuffer.append(array[i]);
        }
        char[] chars=stringBuffer.toString().toCharArray();
        int n=0;
        int i=0;
        int j=chars.length-1;
      /*  for (int i=0;i<array.length-1;i++){
            if (array[i]<array[i+1])n++;
        }
        return n%1000000007;*/
        while (i<=j&&i!=j){

            if (chars[i]>chars[i+1]){
                n+=(int)chars[i]-'0';
            }
            if (chars[j]<chars[j-1]){
                n+=(int)chars[j-1]-'0';
            }
            i++;
            j--;
        }
        for (i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }
        System.out.println((int)chars[0]+(int)chars[1]);
        return n%1000000007;
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
        return 0;
        /*char[] chars=str.toCharArray();
        ArrayList<Character> stringArrayList=new ArrayList<>();
        for (int i=0;i<chars.length;i++){
            if (stringArrayList.remove((Character)chars[i])){
                return i;
            }
            else stringArrayList.add((Character)chars[i]);
        }
        return -1;*/
        
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.InversePairs(new int[]{1,2,4,7,15,16}));
    }
}

