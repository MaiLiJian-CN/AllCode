package 链表;

public class JosepFu {
    public static void main(String[] args) {
        CircleSingleLinkList list = new CircleSingleLinkList();
        list.addBoy(5);
        list.showBoy();
    }
}

class CircleSingleLinkList{
    private Boy first=new Boy(0);
    public void addBoy(int nums){
        if (nums<2){
            return;
        }
        Boy curBoy=null;
        for (int i = 1; i <= nums; i++) {
            Boy boy=new Boy(i);
            if (i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    public void showBoy(){
        if (first==null) return;
        Boy cur=first;
        while (true){
            System.out.printf("编号:%d\n",cur.getNo());
            if (cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        if (first==null||startNo<1||startNo>nums) return;
        Boy helper=first;
        while (helper.getNext()!=first){
            helper= helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (helper!=first){
            for (int i = 0; i < countNum - 1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("出圈"+first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("剩下"+first.getNo());
    }
}

class Boy{
    private int no;

    public Boy(int no) {
        this.no = no;
    }
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
