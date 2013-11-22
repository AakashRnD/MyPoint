
//FUNCTION FOR DRAWING DASHED-LINES
CanvasRenderingContext2D.prototype.dashedLine = function(x1, y1, x2, y2, dashLen) {
    if (dashLen == undefined) dashLen = 2;
    
    this.beginPath();
    this.moveTo(x1, y1);
    
    var dX = x2 - x1;
    var dY = y2 - y1;
    var dashes = Math.floor(Math.sqrt(dX * dX + dY * dY) / dashLen);
    var dashX = dX / dashes;
    var dashY = dY / dashes;
    
    var q = 0;
    while (q++ < dashes) {
     x1 += dashX;
     y1 += dashY;
     this[q % 2 == 0 ? 'moveTo' : 'lineTo'](x1, y1);
    }
    this[q % 2 == 0 ? 'moveTo' : 'lineTo'](x2, y2);
    this.lineWidth=3;
    this.stroke();
    this.closePath();
};

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

//FUNCTIONS FOR HIDING TOAST


function hideToast(){
	var alert = document.getElementById("toast");
	alert.style.opacity = 0;
	var rtoast = document.getElementById('toast');
	rtoast.parentNode.removeChild(rtoast);
	t=0;
		
}
//FUNCTIONS FOR DISPLAYING TOAST
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
var elem = document.getElementById('x1');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('y1');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('x2');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('y2');
 elem.parentNode.removeChild(elem);
 var elem = document.getElementById('a');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('b1');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('b2');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('pp');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('submit');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('xx1');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('xx2');
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
	ctx.lineWidth = 0.3;
	ctx.strokeStyle = "66FF99";
	
	//HORIZONTAL LINES ABOVE X-AXIS
	for(var i =canvas.height/2-5; i >=0; i=i-5,ctr++)
	{
	ctx.beginPath();
	ctx.moveTo(0, i);
	ctx.lineTo(canvas.width, i);
	if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
		ctx.lineWidth = 1;
		ctx.strokeStyle="red";
	}
	else{
		ctx.strokeStyle="66FF99";
		ctx.lineWidth = 0.7;
	}
	
	ctx.closePath();
	ctx.stroke();
	
	}
	
	//HORIZONTAL LINES BELOW X-AXIS
	ctr=1;
	for(var i =canvas.height/2+5; i <=canvas.height; i=i+5,ctr++)
		{
		ctx.beginPath();
		ctx.moveTo(0, i);
		ctx.lineTo(canvas.width, i);
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			ctx.lineWidth = 1;
			ctx.strokeStyle="red";
		}
		else{
			ctx.lineWidth = 0.7;
			ctx.strokeStyle="66FF99";
		}
		
		ctx.closePath();
		ctx.stroke();
		
		}
	ctr=1;
	
	//VERTICAL LINES TO LEFT OF Y-AXIS
	for(var j = canvas.width/2-5; j >= 0; j = j - 5,ctr++)
	{
		ctx.beginPath();
		ctx.moveTo(j, 0);
		ctx.lineTo(j, canvas.height);
		if(ctr%10==0 && ctr!=0) {	//Every 10th line is bold and red
			ctx.lineWidth = 1;
			ctx.strokeStyle="red";
	}
	else{
		ctx.lineWidth = 0.7;
		ctx.strokeStyle="66FF99";
	}
		ctx.closePath();
		ctx.stroke();
	}

	//VERTICAL LINES TO RIGHT OF Y-AXIS
	ctr=1;
	for(var j = canvas.width/2+5; j <=canvas.width; j = j + 5,ctr++)
	{
		ctx.beginPath();
		ctx.moveTo(j, 0);
		ctx.lineTo(j, canvas.height);
		if(ctr%10==0 && ctr!=0) {	//Every 10th line is bold and red
			ctx.lineWidth = 1;
			ctx.strokeStyle="red";
	}
	else{
		ctx.lineWidth = 1;
		ctx.strokeStyle="66FF99"; //Others line are green
	}
		ctx.closePath();
		ctx.stroke();
	}
	
//DRAW Y-AXIS
	ctx.beginPath();
	
	ctx.strokeStyle = "black";
	ctx.lineWidth=2.5;
	ctx.moveTo(canvas.width/2,0);
	ctx.lineTo(canvas.width/2,canvas.height);
	
	
	ctx.closePath();
	ctx.stroke();
//DRAW X-AXIS	
	ctx.beginPath();
	ctx.strokeStyle = "black";
	ctx.lineWidth=2.5;
	ctx.moveTo(0,canvas.height/2);
	ctx.lineTo(canvas.width,canvas.height/2);
	
	
	ctx.closePath();
	ctx.stroke();
	
	ctx.fillStyle="black";
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillText("(0,0)", canvas.width/2+5,canvas.height/2-5);
	ctx.TextAlign="end";
	ctx.fillText("X-axis",canvas.width-55,canvas.height/2-10);
	ctx.fillText("Y-axis",canvas.width/2+5,30);
	
	var x=canvas.width/2;
	var y = canvas.height/2;
	
	ctx.font="normal 20px Tahoma";
	
	for(var g=1;g<20;g++)
	{
	ctx.fillText(-g,x-20,y+(55*g));
	
	ctx.fillText(g,x-20,y-(45*g));
	
}

for(var g=1;g<20;g++)
	{
	ctx.fillText(g,x+(45*g),y+20);
	
	ctx.fillText(-g,x-(55*g),y+20);
	}
		
}
//--------------------------------------------------------------
//checking answer
function displayResult()
{
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	
     xx1=parseFloat(document.getElementById("x1").value,10);
	 yy1=parseFloat(document.getElementById("y1").value,10);
	 xx2=parseFloat(document.getElementById("x2").value,10);
	 yy2=parseFloat(document.getElementById("y2").value,10);
		
	if((yy1>=(slope*xx1)+cons-.2 && yy1<=(slope*xx1)+cons+.2) && (yy2>=(slope*xx2)+cons-.2 && yy2<=(slope*xx2)+cons+.2))	
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
	drawToast("Wrong Answer!");
	if(mm==0)
	{
	wa++;
	mm=1;
	}
    }
	xxa = (xx1*50+canvas.width/2-5);
    yyb = ((yy1*50+canvas.height/2+3)-yy1*50*2);
	ctx.fillText("("+xx1+","+yy1+")",xxa,yya);
    ctx.fillText("("+xx2+","+yy2+")",xxb,yyb);
}
//---------------------------------------------------------------


//FUNCTION TO RESET GRAPH
function reset(){
    
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	ctx.clearRect(0,0,canvas.width,canvas.height);
	drawGraph();
	document.getElementById("x1").value="";	
	document.getElementById("y1").value="";	
	document.getElementById("x2").value="";	
	document.getElementById("y2").value="";	
 var element=document.getElementById("result");
     element.innerHTML="you are on question no. "+qno;
	qno++;
	mm=0;
    mm=0;
	xa=6;
 	ya=(Math.random()*8)-4;
	
	
    xb=-6
 	yb=(Math.random()*8)-4;
   
	xa=Math.round(xa*10)/10;
	ya=Math.round(ya*10)/10;
	xb=Math.round(xb*10)/10;
	yb=Math.round(yb*10)/10;
    a=xa;
	b=ya;
	c=xb;
	d=yb;
//adjust values for canvas
    x1 = (a*50+canvas.width/2-5);
    y1 = ((b*50+canvas.height/2+3)-b*50*2);
    x2 = (c*50+canvas.width/2-5);
    y2 = ((d*50+canvas.height/2+3)-d*50*2);
	
	m=(y2-y1)/(x2-x1);
		c=y1-(m*x1);
		
	slope=(yb-ya)/(xb-xa);
	cons=ya-(slope*xa);

		yy=canvas.width*slope+cons;
		xx=(canvas.height-cons)/slope;
		
//drawing the line
	ctx.font="16px Tahoma";	
	ctx.fillStyle="blue";	
	ctx.beginPath();
	ctx.strokeStyle = "black";
	ctx.lineWidth=1.5;
	ctx.moveTo(x1,y1);
	ctx.lineTo(x2,y2);
	ctx.closePath();
	ctx.stroke();

	hideToast();

	}