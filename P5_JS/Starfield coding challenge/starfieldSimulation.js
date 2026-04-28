let stars =new Array(8400);
var speeed=1;
function setup(){
    let canvas = createCanvas(windowWidth,windowHeight);
    canvas.position(0,0);
    canvas.style('z-index','-1');
    background('black');
    for(let i = 0; i<stars.length;i++){
        stars[i] =new Star();
    }
}


function draw(){
    speeed = int(document.getElementById("speed").value);
    translate(width/2,height/2);
    background('Darkblue');
    for(let i=0;i<stars.length;i++){
        stars[i].Setspeed(speeed);
        stars[i].update();
        stars[i].show();
    }


}