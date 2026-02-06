let stars =new Array(8400);

function setup(){
    createCanvas(2500,1440);
    background('black');
    for(let i = 0; i<stars.length;i++){
        stars[i] =new Star();
    }
}


function draw(){
    let speeed = map(mouseX, 0, width, 1, 60);
    translate(width/2,height/2);
    background('black');
    for(let i=0;i<stars.length;i++){
        stars[i].Setspeed(speeed);
        stars[i].update();
        stars[i].show();
    }


}