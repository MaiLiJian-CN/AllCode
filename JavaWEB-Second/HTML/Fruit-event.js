function showBGC(){
    //event:当前发生的事件
    console.log(event.srcElement.tagName)
    if(event.srcElement.tagName=="TD"){
        var td = event.srcElement;
        var tr=td.parentElement;
        tr.style.backgroundColor="red";
        var tds=tr.cells;
        for(var i=0;i<tds.length;i++){
            tds[i].style.color="white"
        }
    }
}