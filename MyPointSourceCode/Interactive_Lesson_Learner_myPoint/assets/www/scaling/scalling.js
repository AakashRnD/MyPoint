var xa,ya;
var x,y,t=0,mm,timer=0;

//FUNCTION TO DRAW ARROWS

function drawArrow(context, arrow) {
  
  context.beginPath();
  context.moveTo(arrow[0][0],arrow[0][1]);
  context.lineTo(arrow[1][0],arrow[1][1]);
  context.closePath();
  context.stroke();
  
  context.beginPath();
  context.moveTo(arrow[0][0],arrow[0][1]);
  context.lineTo(arrow[2][0],arrow[2][1]);
  context.closePath();
  context.stroke();
  
 
};



//---------------------------------------------------------------



//FUNCTIONS FOR DISPLAYING TOAST



function hideToast(){
	var alert = document.getElementById("toast");
	alert.style.opacity = 0;
	var rtoast = document.getElementById('toast');
	rtoast.parentNode.removeChild(rtoast);
	t=0;
}

function drawToast(message){
	var alert = document.getElementById("toast");
	if (alert == null){
		var toastHTML = '<div id="toast">' + message + '</div>';
		document.body.insertAdjacentHTML('beforeEnd', toastHTML);
	}
	else{
		alert.style.opacity = .9;
	}
	t=1;
}

//---------------------------------------------
//submitting quiz
function submit()
{
var canvas = document.getElementById("workspace");
var ctx = canvas.getContext("2d");
var elem = document.getElementById('xx');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('yy');
 elem.parentNode.removeChild(elem);
 var elem = document.getElementById('a');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('ab');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('b1');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('b2');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('pp');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('submit');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('timer');
   elem.innerHTML="<br>Total Time: "+timer+" sec";
 var elem=document.getElementById("result");
 elem.parentNode.removeChild(elem);
ctx.clearRect(0,0,canvas.width,canvas.height);
if(t==1)
{hideToast();}
clearInterval(intervalId);
 createPieChart();
}

//---------------------------------------------

window.onload = function(){
   qno=1;        //Present question number
   ca=0;         //Number of correct answers
   wa=0;         //Number of wrong answers
   
   intervalId = setInterval(function () {
   timer++;
   var elem = document.getElementById('timer');
   elem.innerHTML="<br>Total Time: "+timer+" sec";
}, 1000);
   reset();
   
};

//---------------------------------------------

jQuery(document).ready(function(){
})

//---------------------------------------------

//DRAWING THE GRAPH
function drawGraph() {
  
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	var ctr = 1;	
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.fillStyle="white";
	ctx.fillRect(0,0,canvas.width,canvas.height);
	ctx.lineWidth = 0.3;
	ctx.strokeStyle = "66FF99";
	
	//HORIZONTAL LINES ABOVE X-AXIS
	for(var i =canvas.height-10; i >=-1000; i=i-5,ctr++)
	{
	ctx.beginPath();
	ctx.moveTo(-1000, i);
	ctx.lineTo(canvas.width+1000, i);
	if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
		ctx.lineWidth = 1;
		ctx.strokeStyle="red";
	}
	else{
		ctx.strokeStyle="66FF99";
		ctx.lineWidth = .7;
	}
	
	ctx.closePath();
	ctx.stroke();
	
	}
	

//VERTICAL LINES TO RIGHT OF Y-AXIS
	ctr=1;
	for(var j = 10; j <=canvas.width+1000; j = j + 5,ctr++)
	{
		ctx.beginPath();
		ctx.moveTo(j, -1000);
		ctx.lineTo(j, canvas.height+1000);
		if(ctr%10==0 && ctr!=0) {	//Every 10th line is bold and red
			ctx.lineWidth = 1;
			ctx.strokeStyle="red";
	}
	else{
		ctx.lineWidth = .7;
		ctx.strokeStyle="66FF99";
	}
		ctx.closePath();
		ctx.stroke();
	}

	//DRAW Y-AXIS
	ctx.beginPath();
	
	ctx.strokeStyle = "black";
	ctx.lineWidth=2;
	ctx.moveTo(5,-1000);
	ctx.lineTo(5,canvas.height+1000);
	ctx.closePath();
	ctx.stroke();

//DRAWING ARROW on y axis
	ctx.save();
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	drawArrow(ctx,[[5,0], [-2,10], [12, 10]]);
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillText("Y-axis",5+5,30);
	
//SCALING GRAPH WITH DIFFERENT VALUES
	ctx.font="bold italic 15px Comic Sans MS";
	xa=(Math.random()*10)+5;
 	ya=(Math.random()*10)+5;
	xa=Math.round(xa);
	ya=Math.round(ya);
	sx=(Math.random()*10);
 	sy=(Math.random()*10);
	sx=Math.round(sx);
	sy=Math.round(sy);
	sx*=5;
	sy*=5;
	if(sx!=0)
	{
	    ctx.beginPath();
		ctx.moveTo(5,canvas.height-5);
		ctx.lineTo(35,canvas.height-10);
		ctx.lineTo(25,canvas.height);
		ctx.lineTo(55,canvas.height-5);
		ctx.closePath();
		ctx.stroke();
	}
	if(sy!=0)
	{
	    ctx.beginPath();
		ctx.lineTo(5,canvas.height-5);
		ctx.lineTo(10,canvas.height-35);
		ctx.lineTo(0,canvas.height-25);
		ctx.lineTo(5,canvas.height-55);
		ctx.closePath();
		ctx.stroke();
	}
	xa*=5;
	ya*=5;
    j=1;
	for(i=50;i<canvas.width;i+=50)
	{
	ctx.fillText(xa*j+sx,i-5,canvas.height-15);
	j++;
	}
	j=1;
	for(i=50;i<canvas.height;i+=50)
	{
	ctx.fillText(ya*j+sy, 10,canvas.height-i);
	j++;
	}
	ctx.restore();

//DRAW X-AXIS	
	ctx.beginPath();
	ctx.strokeStyle = "black";
	ctx.lineWidth=2.5;
	ctx.moveTo(-1000,canvas.height-5);
	ctx.lineTo(canvas.width+1000,canvas.height-5);
	ctx.closePath();
	ctx.stroke();
	

//DRAWING ARROW on x axis	
	ctx.save();
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	drawArrow(ctx,[[canvas.width,canvas.height-5], [canvas.width-12,canvas.height-15], [canvas.width-12,canvas.height+5]]);
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillText("X-axis",canvas.width-55,canvas.height-30);
	ctx.restore();
	
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 15px Comic Sans MS";
	if(sx==0 || sy==0)
	ctx.fillText("0", 15,canvas.height-15);
}
//--------------------------------------------------------------
//CHECKING FOR ANSWER
function displayResult()
{
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	
     q=parseFloat(document.getElementById("xx").value,10);
     w=parseFloat(document.getElementById("yy").value,10);
     e=parseFloat(document.getElementById("a").value,10);
     r=parseFloat(document.getElementById("ab").value,10);
     if(( q==xa && w==ya ) && ( e==sx+xa && r==sy+ya) )
   {
	   drawToast("Correct Answer!");
	   if(mm==0)
	{
	ca++;
	mm=1;
	}
   }
	else
	{
		drawToast("Wrong Answer");
		if(mm==0)
	{
	wa++;
	mm=1;
	}
	}
	
}
//---------------------------------------------------------------


//FUNCTION TO RESET GRAPH
function reset(){
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	ctx.clearRect(0,0,canvas.width,canvas.height);
    drawGraph();
	document.getElementById("xx").value="";
	document.getElementById("yy").value="";
	document.getElementById("a").value="";
	document.getElementById("ab").value="";
	 var element=document.getElementById("result");
     element.innerHTML="you are on question no. "+qno;
	qno++;
	mm=0;
	
	hideToast();
}

