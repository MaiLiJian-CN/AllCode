/*
var num=1;
var num2=1.2;
var num3=NaN;
decument.write(num+"=="+typeof(num)+"<br>");
decument.write(num2+"=="+typeof(num2)+"<br>");
decument.write(num3+"=="+typeof(num3)+"<br>");*/

/*
alert("HelloWorld");
document.write("HelloWorld");
console.log("Hello,JavaScript");
// <br/>
var a=10;
document.write(a+"\n");
a="测试";
document.write(a)*/

function on() {
    document.getElementById('myImage').src="../images/on.gif";
}
function off() {
    document.getElementById('myImage').src="../images/off.gif";
}
var x=0;
setInterval(function (){
    if (x%2 ==0){
        on();
    }else {
        off();
    }
    x++;
},1000)
