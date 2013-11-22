
function createPieChart() {

	//
	// create a PieChart.
	// 
	
	var pieChart = new PieChart( "workspace", 
		{
			includeLabels: true, 
			data: [ca*360/(qno-1), wa*360/(qno-1), (qno-ca-wa-1)*360/(qno-1)],
			labels: ["", "", ""],
			colors: [
            	["green"],
            	["red"],
            	["blue"]
			]
		}
	);

	//
	// nothing appears until you call draw().
	//
	pieChart.draw();
}


function PieChart(id, o) {
	this.includeLabels = false;
	if (o.includeLabels == undefined) {
		this.includeLabels = false;
	}
	else {
		this.includeLabels = o.includeLabels;
	}
	this.data = o.data ? o.data : [30, 70, 45, 65, 20, 130]; // in degrees
	this.labels = o.labels ? o.labels : ["First", "Second", "Third", "Fourth", "Fifth", "Sixth"];
	this.colors = o.colors ? o.colors : [
        	["#bbddb3", "#1d8e04"], // green
        	["#e2f5b4", "#9edd08"], // yellow green
        	["#fdfbb4", "#faf406"], // yellow
        	["#fbd4b7", "#f2700f"], // orange
        	["#f8bdb4", "#ea2507"], // red
        	["#e2bcbd", "#9e2126"]  // purple
    	];

	this.canvas = document.getElementById(id);
}

PieChart.prototype = {

	select: function(segment) {
		var self = this;
		var context = this.canvas.getContext("2d");
		this.drawSegment(this.canvas, context, segment, this.data[segment], true, this.includeLabels);
	},

	draw: function() {
		var self = this;
		var context = this.canvas.getContext("2d");
		for (var i = 0; i < this.data.length; i++) {
			this.drawSegment(this.canvas, context, i, this.data[i], false, this.includeLabels);
		}
	},

	drawSegment: function(canvas, context, i, size, isSelected, includeLabels) {
		var self = this;
		context.save();
		var centerX = Math.floor(canvas.width / 2-75);
		var centerY = Math.floor(canvas.height / 2);
		radius = Math.floor(canvas.height / 2-20);

		var startingAngle = self.degreesToRadians(self.sumTo(self.data, i));
		var arcSize = self.degreesToRadians(size);
		var endingAngle = startingAngle + arcSize;

		context.beginPath();
		context.moveTo(centerX, centerY);
		context.arc(centerX, centerY, radius, startingAngle, endingAngle, false);
		context.closePath();

		isSelected ? 
			context.fillStyle = self.colors[i][1] :
			context.fillStyle = self.colors[i][0];

		context.fill();
		context.restore();
		
		
	  context.beginPath();
      context.rect(375, 255, 10, 10);
      context.fillStyle = "green";
      context.fill();
      context.lineWidth = 1;
      context.strokeStyle = 'black';
      context.stroke();
	  context.beginPath();
     
      context.rect(375, 275, 10, 10);
      context.fillStyle = "red";
      context.fill();
      context.lineWidth = 1;
      context.strokeStyle = 'black';
      context.stroke();

	  context.beginPath();
      context.rect(375, 295, 10, 10);
      context.fillStyle = "blue";
      context.fill();
      context.lineWidth = 1;
      context.strokeStyle = 'black';
      context.stroke();
	  context.font = "bold 12px Arial";
	  context.fillStyle = "black";
      context.fillText("correct : "+ca, 395, 265); 
	  context.fillText("wrong : "+wa, 395, 285);
	   context.fillText("Unattempted : "+(qno-ca-wa-1), 395, 305);

		if (includeLabels && (self.labels.length > i)) {
			self.drawSegmentLabel(canvas, context, i, isSelected);
		}
	},

	drawSegmentLabel: function(canvas, context, i, isSelected) {
		var self = this;
		context.save();
		var x = Math.floor(canvas.width / 2);
		var y = Math.floor(canvas.height / 2);
		var angle;
		var angleD = self.sumTo(self.data, i);
		var flip = (angleD < 90 || angleD > 270) ? false : true;

		context.translate(x, y);
		if (flip) {
			angleD = angleD-180;
			context.textAlign = "left";
			angle = self.degreesToRadians(angleD);
			context.rotate(angle);
			context.translate(-(x + (canvas.width * 0.5))+15, -(canvas.height * 0.05)-10);
		}
		else {
			context.textAlign = "right";
			angle = self.degreesToRadians(angleD);
			context.rotate(angle);
		}
		//context.textAlign = "right";
		var fontSize = Math.floor(canvas.height / 25);
		context.font = fontSize + "pt Helvetica";

		var dx = Math.floor(canvas.width * 0.5) - 80;
		var dy = Math.floor(canvas.height * 0.05);
		context.fillText(self.labels[i], dx, dy);

		context.restore();
	},

	drawLabel: function(i) {
		var self = this;
		var context = this.canvas.getContext("2d");
		var size = self.data[i];

		self.drawSegmentLabel(this.canvas, context, i, size, false);
	},

	// helper functions
	degreesToRadians: function(degrees) {
		return (degrees * Math.PI)/180;
	},

	sumTo: function(a, i) {
		var sum = 0;
		for (var j = 0; j < i; j++) {
			sum += a[j];
		}
		return sum;
	}


}