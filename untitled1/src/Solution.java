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

         public TreeNode() {
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
        if (str.length()==0){

            return 0;
        }
        /*char[] chars=str.toCharArray();
        ArrayList<Character> stringArrayList=new ArrayList<>();
        for (int i=0;i<chars.length;i++){
            if (stringArrayList.remove((Character)chars[i])){
                return i;
            }
            else stringArrayList.add((Character)chars[i]);
        }
        return -1;*/
        char[] chars=str.toCharArray();
       /* Map<Integer,Character> map=new HashMap<>();
        Map<Integer,Character> map2=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if (!map.containsValue(chars[i])){
                map.put(i,chars[i]);
            }else map2.put(i,chars[i]);
        }
        for (Map.Entry<Integer,Character> entry:map2.entrySet() ){
            map.remove(entry.getValue());
        }
        for (Integer c:map.keySet()){
            return c;
        }
        return 0;*/
        List<Character> characterList=new ArrayList<>();
        List<Character> characterList2=new ArrayList<>();
        for (int i=0;i<chars.length;i++) {
            if (!characterList.contains(chars[i]))
            {characterList.add(chars[i]);}
            else if

        (characterList.contains(chars[i])){
                    characterList2.add(chars[i]);
                }

        }

        for (int i=0;i<chars.length;i++){
            if (!characterList2.contains(chars[i]))
                return i;
        }
        return -1;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        return null;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
     * 则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String min=numbers.toString();
        for (int i=0;i<numbers.length;i++){

        }
        return null;
    }

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
     * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
     * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int x=0;

        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<n;i++){
            stringBuffer.append(i+"");
        }
        char[] chars=stringBuffer.toString().toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='1')x++;
        }
        return x;
      /*  char[] chars=strN.toCharArray();
        for (int i=0;i<n;i++){
            chars=(i+"").toCharArray();
            for (int j=0;i<chars.length;j++){
                if (chars[i]=='1'){
                    x++;
                }
            }
        }
        return x;*/
    }

    /**
     * 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。要求时间复杂度为O(n)。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int frameSetSum = array[0];
        int biggestSum = array[0];
        for (int i = 1; i < array.length; i++)
        {
            frameSetSum = Math.max(array[i], frameSetSum + array[i]); //第一个变量大则框集前移，第二个变量大则框集扩增
            biggestSum = Math.max(biggestSum, frameSetSum); //记录遍历过程中最大的子数组和
        }
        return biggestSum;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length||input.length==0||k<=0)return new ArrayList<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<Integer> arrayList1=new ArrayList<>();
        for (int i=0;i<input.length;i++){
            arrayList.add(input[i]);
        }
        Collections.sort(arrayList);
        for (int i=0;i<k;i++){
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     * 超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length<0)return 0;

        Map<Integer,Integer> integerIntegerMap=new HashMap<>();
        for (int i=0;i<array.length;i++){
           if (!integerIntegerMap.containsKey(array[i]))
               integerIntegerMap.put(array[i],1);
           else {
               integerIntegerMap.put(array[i],integerIntegerMap.get(array[i])+1);

           }
        }
        for (Map.Entry<Integer,Integer> entry:integerIntegerMap.entrySet()){
            if (entry.getValue()>array.length/2){
                return entry.getKey();
            }
        }
        return 0;

    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        re.addAll(set);
        Collections.sort(re);
        return re;
    }
    void fun(HashSet<String> re, char[] str, int k) {
        if (k == str.length) {
            re.add(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }
    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
    /*public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList=new ArrayList<>();
        List<String> list=new ArrayList<>();
        char[] chars=str.toCharArray();
        for (int i=0;i<chars.length;i++){
            list.add(chars[i]+"");
        }

    }*/
 /*   public  static String Permutation_dex(List<String> list,int m){
        if (list.isEmpty())
            return null;
        else {
            list.remove(m);

        }
    }*/

    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target==2){
            return 1;
        }
        if (target==3)
            return 2;
        if (target%3==0){
            return (int)Math.pow(3,target/3);
        }else if (target%3==1){
            return 4*(int)Math.pow(3,target/3-1);
        }else if (target%3==2){
            return 2*(int)Math.pow(3,target/3);
        }
        return 0;
    }

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        int sum=0;
       /* char[] chars=new char[];
        for ()*/
        return 1;
    }

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
     *    矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
     *    因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     *    dfs 回溯
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if(judge(matrix,i,j,rows,cols,flag,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        //递归终止条件
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length-1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)  )
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }


    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
     * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
     * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
     * 使用GetMedian()方法获取当前读取数据的中位数。
     * @param num
     */
    public void Insert(Integer num) {
        if (count %2 == 0){
            maxHeap.offer(num);
            int max=maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min=minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }
    int count=0;
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public Double GetMedian() {
        if (count%2==0){
            return new Double(minHeap.peek()+maxHeap.peek())/2;

        }else
            return new Double(minHeap.peek());
    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     * @param pRoot
     * @param k
     * @return
     */
    int index=0;
  /*  TreeNode KthNode(TreeNode pRoot, int k)
    {

        if(pRoot != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(pRoot.left,k);//一直查询到左节点，最小的节点
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
    }*/
    TreeNode KthNode(TreeNode pRoot, int k)
    {

        if (pRoot!=null){
            TreeNode node=KthNode(pRoot.left,k);
            if (node!=null){
                return node;
            }

            index++;
            if (index==k){
                return pRoot;
            }
            node=KthNode(pRoot.right,k);
            if (node!=null){
                return node;
            }
        }
        return null;
    }


    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        List<Integer> integerList=new ArrayList<>();
        if (numbers.length==0||length<1)return false;

        int n=0;
        for (int i=0;i<length;i++){
            if (integerList.contains(numbers[i])){
                duplication[n]=numbers[i];
                System.out.println(numbers[i]);
                n++;
            }else integerList.add(numbers[i]);
        }
        System.out.println(duplication[0]);
        return true;
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();

        if (matrix.length<=0){
            return null;
        }
        if (matrix.length==1) {
            arrayList.add(1);
            return arrayList;
        }
        int n=matrix.length;
        int m=matrix.length;
        int x=0,y=0;
        System.out.println(matrix[0][1]);
        for (int i=0;i<(n-1)/2+1;i++){
            //向右
            while (y<=n-1){
                y++;
                arrayList.add(matrix[x][y]);

            }y--;
            n--;
            //向下
            while (x<m-1){
                x++;
                arrayList.add(matrix[x][y]);

            }m--;

            //向左
            while (y>=matrix.length-n){
                y--;
                arrayList.add(matrix[x][y]);

            }
            //向上
            while (x>matrix.length-m){
                arrayList.add(matrix[x][y]);
                x--;
            }
            y--;

            /*public ArrayList<Integer> printMatrix(int [][] array) {
                ArrayList<Integer> result = new ArrayList<Integer> ();
                if(array.length==0) return result;
                int n = array.length,m = array[0].length;
                if(m==0) return result;
                int layers = (Math.min(n,m)-1)/2+1;//这个是层数
                for(int i=0;i<layers;i++){
                    for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
                    for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
                    for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
                    for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
                }
                return result;
            }*/
           /* //向右
            while (matrix[x][y]!=0||y<n){
                arrayList.add(matrix[x][y]);
                matrix[x][y]=0;
                index++;
                y++;
            }
            //向下
            while (matrix[x][y]!=0||x>=0){
                arrayList.add(matrix[x][y]);
                matrix[x][y]=0;
                index++;
                x--;
            }
            //向左
            while (matrix[x][y]!=0||y>=0){
                arrayList.add(matrix[x][y]);
                matrix[x][y]=0;
                index++;
                y--;
            }
            //向上
            while (matrix[x][y]!=0||x<n){
                arrayList.add(matrix[x][y]);
                matrix[x][y]=0;
                index++;
                x++;
            }*/
        }return arrayList;

    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }


        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后的一个相同节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
       /* List<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        while (pHead.next!=null){
            if (list.contains(pHead.val)){
                list2.add(pHead.val);
            }else list.add(pHead.val);
            pHead=pHead.next;
        }
        ListNode headNode=pHead;
        ListNode node=pHead.next;
        ListNode preNode=pHead;
        pHead=headNode;*/
       /* while (pHead.next!=null){
            if (list2.contains(pHead.val)){
                preNode.next=pHead.next;

                pHead=preNode.next;

            }else pHead=pHead.next;
            preNode=preNode.next;
        }*/

       /* while (pHead.next!=null){


            if (list2.contains(pHead.next.val)){
                pHead.next=pHead.next.next;

                pHead=pHead.next;

            }else pHead=pHead.next;

        }
*/
       /* while (pHead.next!=null){
            if (pHead.val==node.val){
                preNode.next=node.next;
            }
            preNode=preNode.next;
            pHead=node.next;
            node=pHead.next;
        }*/
       /* while (pHead.next!=null){
            if (pHead.val==pHead.next.val){
                preNode.next=pHead.next.next;
            }
        }*/
     /*   while (pHead.next!=null){
            if (pHead.next)
        }*/

    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        String s="";
        if (str=="")return 0;
        boolean num=true;
        char[] chars=str.toCharArray();
        if (chars.length<=0)return 0;
        if (chars[0]=='-'){
            num=false;
            chars[0]='0';
        }
        if (chars[0]=='+'){
            chars[0]='0';
        }

        for (int i=0;i<chars.length;i++){
            if (chars[i]<='9'&&chars[i]>='0'){
                s+=chars[i];
            }else return 0;
        }
        if (num)
            return Integer.parseInt(s);
        else return (0-Integer.parseInt(s));
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
    //import java.util.*;
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1,2},{3,4}}));
        //System.out.println(solution.duplicate(new int[]{2,4,3,1,4},5,new int []{0}));
    }
}

