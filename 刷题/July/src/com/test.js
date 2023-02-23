var head={next:{next:{next:{next:null,value:4},value:3},value: 2},value:1};
var temp=head;
const reverse = function (headNode) {
    // headNode 包含 value 和 next 属性，value 表示节点值，next 表示下一节点
    let list = null;
    let p = headNode;
    let q = null
    if (p === null) return null
    while(p.next !== null){
        q = p.next;
        p.next = list;
        list = p;
        p = q;
    }
    p.next = list;
    list = p;
    return list;
};
reverse(head);
console.log(head)