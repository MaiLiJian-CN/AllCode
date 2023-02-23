package 链表;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 node5 = new HeroNode2(5, "林冲2", "豹子头2");
        HeroNode2 node6 = new HeroNode2(6, "鲁智深", "花和尚");
        HeroNode2 node7 = new HeroNode2(7, "鲁智深", "花和尚");
        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node5);
        list.addByOrder(node7);
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.addByOrder(node6);
        list.list();
        System.out.println("==============================");
        list.remove(5);
        list.list();
    }
}
class DoubleLinkedList{
    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 获取链表长度
     */
    public int getLength(){
        int length=0;
        HeroNode2 temp = head.next;
        while (temp!=null){
            length++;
            temp=temp.next;
        }

        return length;
    }
    /**
     *  添加节点到列表
     *  找到当前链表的最后节点
     *  将最后节点的next指向新节点
     */
    public void add(HeroNode2 heroNode){
        /*头节点不能动，用temp辅助遍历*/
        HeroNode2 temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    //显示链表【遍历】
    public void list(){
        if (head.next==null){
            System.out.println("链表为空!!!");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //自我删除
    public void remove(int no){
        if (head.next==null) return;
        boolean flag=false;
        HeroNode2 temp = head.next;
        while (temp!=null){
            if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null)temp.next.pre=temp.pre;
        }
    }
    //根据排序添加
    public void addByOrder(HeroNode2 hero){
        HeroNode2 temp = head;
        while (temp.next!=null){
            if (temp.next.no>hero.no){
                break;
            }
            temp=temp.next;
        }
        hero.next=temp.next;
        temp.next=hero;
        hero.pre=temp;
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "HeroNode{"+"no="+no+","+"name="+name+","+"nickname="+nickname+"}";
    }
}