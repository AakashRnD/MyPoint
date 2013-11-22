
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

//GLOBAL VARIABLES

var xa,ya,flag=0;
var x,y,t=0,mm,timer=0;

//-------------------------------------------------------------------

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

//---------------------------------------------------------------

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
  var elem = document.getElementById('xx');
 elem.parentNode.removeChild(elem);
  var elem = document.getElementById('yy');
 elem.parentNode.removeChild(elem);
 var elem = document.getElementById('a');
 elem.parentNode.removeChild(elem);
   var elem = document.getElementById('b');
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
//Calling function from pie.js file for drawing Pie chart for the result
 createPieChart();
}

//---------------------------------------------
//Onload function

window.onload = function(){
   qno=1;        //Present question number
   ca=0;         //Number of correct answers
   wa=0;         //Number of wrong answers
   intervalId = setInterval(function () {
   timer++;
   var elem = document.getElementById('timer');
   elem.innerHTML="<br>Total Time: "+timer+" sec";
}, 1000);
   reset();     //calling of reset function from the same js file
};
jQuery(document).ready(function(){
})

//------------------------------------------------------------------

//DRAWING THE GRAPH
function drawGraph() {
  
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	var ctr = 1;	
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	ctx.fillStyle="white";
	ctx.fillRect(0,0,canvas.width,canvas.height);
	ctx.lineWidth = 0.5;
	ctx.strokeStyle = "66FF99";
	
	
	//HORIZONTAL LINES ABOVE X-AXIS
	for(var i =canvas.height/2-10; i >=-1000; i=i-10,ctr++)
	{
	ctx.beginPath();
	ctx.moveTo(-1000, i);
	ctx.lineTo(canvas.width+1000, i);
	if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
		ctx.lineWidth = 1.5;
		ctx.strokeStyle="red";
	}
	else{
		ctx.strokeStyle="66FF99";
		ctx.lineWidth = 1;
	}
	
	ctx.closePath();
	ctx.stroke();
	
	}
	
//HORIZONTAL LINES BELOW X-AXIS
	ctr=1;
	for(var i =canvas.height/2+10; i <=canvas.height+1000; i=i+10,ctr++)
		{
		ctx.beginPath();
		ctx.moveTo(-1000, i);
		ctx.lineTo(canvas.width+1000, i);
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			ctx.lineWidth = 1.5;
			ctx.strokeStyle="red";
		}
		else{
			ctx.lineWidth = 1;
			ctx.strokeStyle="66FF99";
		}
		
		ctx.closePath();
		ctx.stroke();
		
		}
	ctr=1;
	
//VERTICAL LINES TO LEFT OF Y-AXIS
	for(var j = canvas.width/2-10; j >=-1000; j = j - 10,ctr++)
	{
		ctx.beginPath();
		ctx.moveTo(j, -1000);
		ctx.lineTo(j, canvas.height+1000);
		if(ctr%10==0 && ctr!=0) {	//Every 10th line is bold and red
			ctx.lineWidth = 1.5;
			ctx.strokeStyle="red";
	}
	else{
		ctx.lineWidth = 1;
		ctx.strokeStyle="66FF99"; //Others line are green
	}
		ctx.closePath();
		ctx.stroke();
	}

//VERTICAL LINES TO RIGHT OF Y-AXIS
	ctr=1;
	for(var j = canvas.width/2+10; j <=canvas.width+1000; j = j + 10,ctr++)
	{
		ctx.beginPath();
		ctx.moveTo(j, -1000);
		ctx.lineTo(j, canvas.height+1000);
		if(ctr%10==0 && ctr!=0) {	//Every 10th line is bold and red
			ctx.lineWidth = 1.5;
			ctx.strokeStyle="red";
	}
	else{
		ctx.lineWidth = 1;
		ctx.strokeStyle="66FF99";  //Others line are 66FF99
	}
		ctx.closePath();
		ctx.stroke();
	}

//DRAW Y-AXIS
	ctx.beginPath();
	
	ctx.strokeStyle = "black";
	ctx.lineWidth=2.5;
	ctx.moveTo(canvas.width/2,-1000);
	ctx.lineTo(canvas.width/2,canvas.height+1000);
	ctx.closePath();
	ctx.stroke();

//DRAWING ARROW ON Y AXIS	
	ctx.save();
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	drawArrow(ctx,[[canvas.width/2,0], [canvas.width/2-10,20], [canvas.width/2+10, 20]]);
	drawArrow(ctx,[[canvas.width/2,canvas.height], [canvas.width/2-10,canvas.height-20], [canvas.width/2+10,canvas.height-20]]);
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillText("Y-axis",canvas.width/2+5,30);
	ctx.restore();

//DRAW X-AXIS	
	ctx.beginPath();
	ctx.strokeStyle = "black";
	ctx.lineWidth=2.5;
	ctx.moveTo(-1000,canvas.height/2);
	ctx.lineTo(canvas.width+1000,canvas.height/2);
	ctx.closePath();
	ctx.stroke();
	

//DRAWING ARROWS ON X AXIS	
	ctx.save();
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	drawArrow(ctx,[[0,canvas.height/2], [20,canvas.height/2-10], [20,canvas.height/2+10]]);
	drawArrow(ctx,[[canvas.width,canvas.height/2], [canvas.width-20,canvas.height/2-10], [canvas.width-20,canvas.height/2+10]]);
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 18px Comic Sans MS";
	
//Writing X AXIS ON RIGHT CENTER 
	ctx.fillText("X-axis",canvas.width-55,canvas.height/2-10);
	ctx.restore();
	
	ctx.fillStyle="black";
	ctx.TextAlign="end";
	ctx.font="bold italic 18px Comic Sans MS";
//Writing 0,0 AT CENTER 
	ctx.fillText("(0,0)", canvas.width/2+5,canvas.height/2-5);

	ctx.save();
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	var x=canvas.width/2;
	var y = canvas.height/2;
	ctx.restore();
	ctx.font="normal 20px Tahoma";

	for(var g=1;g<20;g++)
	{
	ctx.fillText(-g,x-20,y+(110*g));
	
	ctx.fillText(g,x-20,y-(90*g));
	
}

for(var g=1;g<20;g++)
	{
	ctx.fillText(g,x+(90*g)+5,y+20);
	
	ctx.fillText(-g,x-(110*g)+5,y+20);
	}
		
	
	
}
//--------------------------------------------------------------


//WHEN MOUSE CLICKED
function mouseMove(e)
{
        if(flag==0)
        {
        flag=1;
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");
	var xPos=e.clientX;
	var yPos=e.clientY;	
	if(xPos > canvas.width || yPos>canvas.height || xPos<5 || yPos<5){		
	}
	else{
	var x=(xPos-(canvas.width)/2-70)/100+0.6;
	var y=((yPos-(canvas.height)/2-8)/100)*-1+.2;
	x=Math.round(x*10)/10;
	y=Math.round(y*10)/10;	
	
    
	
    var qx = xa;
	var qy = ya;
	//Checking answer	
	if((x > qx-0.2 && x< qx+0.2) && (y > qy-0.2 && y < qy+0.2)){		
		drawToast("Correct!");
		if(mm==0)
	{
	ca++;
	mm=1;
	}
	}
	else{		
		drawToast("Wrong Answer");
		if(mm==0)
	{
	wa++;
	mm=1;
	}
//drawing dashed lines for wrong answer
	var point = "("+x+","+y+")";
	var aa = x*100+canvas.width/2-5;
	var bb = (y*100+canvas.height/2+3)-y*100*2;
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillStyle="red";
	ctx.fillText(point, aa+5, bb-10);
	ctx.font="bold 36px Tahoma";	
	ctx.fillStyle="red";
	ctx.fillText(".",aa-1,bb);	
	ctx.strokeStyle="red";
	ctx.dashedLine(canvas.width/2,bb-2,aa,bb-2,7);
	ctx.dashedLine(aa+3,canvas.height/2,aa+3,bb,7);	
	}
//drawing dashed lines for correct answer
	var point = "("+qx+","+qy+")";
	var a = qx*100+canvas.width/2;
	var b = (qy*100+canvas.height/2+3)-qy*100*2;
	ctx.font="bold italic 18px Comic Sans MS";
	ctx.fillStyle="blue";
	ctx.fillText(point, a+5, b-10);
	ctx.font="bold 36px Tahoma";	
	ctx.fillStyle="blue";
	ctx.fillText(".",a-1,b);
    ctx.strokeStyle="blue";
	ctx.dashedLine(canvas.width/2,b-2,a,b-2,7);
	ctx.dashedLine(a+3,canvas.height/2,a+3,b,7);
	}
}
}

//-------------------------------------------------------------------


//FUNCTION TO RESET GRAPH
function reset(){
flag=0;
	var canvas = document.getElementById("workspace");
	var ctx = canvas.getContext("2d");	
	scale=1.0;
	minus_count=0;
	ctx.setTransform(1, 0, 0, 1, 0, 0);
	ctx.clearRect(0,0,canvas.width,canvas.height);
	drawGraph();
    var element=document.getElementById("result");
     element.innerHTML="you are on question no. "+qno;
	qno++;
	mm=0;
	window.addEventListener('mousemove', mouseMove,true);
 
 //GENERATING RANDOM VALUES
    	xa=(Math.random()*4)-2;
    	ya=(Math.random()*3)-1.5;
//Rounding off randomly generated values	
	xa=Math.round(xa*10)/10;
	ya=Math.round(ya*10)/10;
	  var elem = document.getElementById("xx");
   elem.innerHTML=" X : "+xa;
     var elem = document.getElementById("yy");
   elem.innerHTML="Y : "+ya;
	hideToast();
	
}

