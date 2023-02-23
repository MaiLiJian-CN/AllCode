package 链表;


import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "林冲2", "豹子头2");
        HeroNode node6 = new HeroNode(6, "鲁智深", "花和尚");
        HeroNode node7 = new HeroNode(7, "鲁智深", "花和尚");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(node5);
        singleLinkedList1.addByOrder(node6);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node7);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
//        singleLinkedList.list();
//        singleLinkedList1.list();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        SingleLinkedList node = SingleLinkedList.addHeroListByOrder(singleLinkedList, singleLinkedList1);
        node.list();
    }
}
/**
 *管理英雄
 */
class SingleLinkedList{
    /*初始化头节点,头节点不能动*/
    public HeroNode head=new HeroNode(0,"","");


    /**
     *  添加节点到列表
     *  找到当前链表的最后节点
     *  将最后节点的next指向新节点
     */
    public void add(HeroNode heroNode){
        /*头节点不能动，用temp辅助遍历*/
        HeroNode temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next=heroNode;
    }
    //显示链表【遍历】
    public void list(){
        if (head.next==null){
            System.out.println("链表为空!!!");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
            System.out.println("=========================");
        }
    }
    /**
     * 根据排序插入链表位置
     */
    public void addByOrder(HeroNode heroNode){
        //temp是要位于添加位置的前一个，否则插入失败
        HeroNode temp=head;
        //判断该序号是否已存在
        boolean flag=false;
        while (temp.next!=null){
            if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            //找到位置
            if (temp.next.no>heroNode.no) break;
            temp = temp.next;
        }
        if (flag){
            System.out.printf("该英雄编号%d已存在，请更改\n",heroNode.no);
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
            System.out.printf("该英雄编号%d成功加入\n",heroNode.no);

        }
    }
    /**
     * 合并添加链表排序
     */
    public static SingleLinkedList addHeroListByOrder(SingleLinkedList list1,SingleLinkedList list2){
        if (list1.getLength()<=0||list2.getLength()<=0) return null;
        HeroNode temp1=list1.head.next;
        HeroNode temp2=list2.head.next;
        SingleLinkedList list=new SingleLinkedList();
        HeroNode temp = list.head;
        while (temp1!=null&&temp2!=null){
            if (temp1.no>temp2.no){
                temp.next=temp2;
                temp2=temp2.next;
            }else {
                temp.next=temp1;
                temp1=temp1.next;
            }
            temp = temp.next;
        }
        if (temp2!=null){
            temp.next=temp2;
        }else if (temp1!=null){
            temp.next=temp1;
        }
        return list;
    }
    /**
     * update根据no节点查找修改值，no不能改
     */
    public void update(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空!!!");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;//判断是否找到该节点
        while (temp!=null){
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name= heroNode.name;
            temp.nickname= heroNode.nickname;
            System.out.println("修改完成");
        }else {
            System.out.printf("查无该编号%d\n",heroNode.no);
        }

    }

    /**
     * 删除
     */
    public void remove(int noId){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;
        while (temp!=null){
            if (temp.next.no==noId){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.printf("无该英雄编号%d\n",noId);
        }
    }

    /**
     * 获取链表长度
     */
    public int getLength(){
        int length=0;
        HeroNode temp = head.next;
        while (temp!=null){
            length++;
            temp=temp.next;
        }

        return length;
    }
    public HeroNode findLastNode(int index){
        if (head.next==null) return null;
        if (index<=0||index>getLength()) return null;
        HeroNode hero=head.next;
        for (int i = head.no; i <getLength()-index; i++) {
            hero=hero.next;
        }
        return hero;
    }
    /**
     * 反转
     */
    public static void reverseList(HeroNode head){
        if (head.next==null||head.next.next==null) return;
        HeroNode cur=head.next;
        HeroNode next=null;
        HeroNode reverseHead=new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next = reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }
    /**
     * 逆序打印
     */
    public void reversePrint(){
        if (head.next==null) return;
        Stack<HeroNode> nodes=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            nodes.push(cur);
            cur=cur.next;
        }
        while (nodes.size()>0){
            System.out.println(nodes.pop());
        }
    }
}

/**
 * 每个HeroNode对象就是一个节点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{"+"no="+no+","+"name="+name+","+"nickname="+nickname+"}";
    }
}