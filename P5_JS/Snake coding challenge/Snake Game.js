var s;
var scl=20;
var f;

function setup(){
    createCanvas(600,600);
    s= new Snake();
    frameRate(10);
    f= new food();
    f.pickLocation();
}

function draw(){
    background(51);
    f.show();
    s.death();
    s.update();
    s.show();

    if(s.eat(f.x,f.y)){
        f.pickLocation();
    }
}

function keyPressed(){
    if(keyCode === UP_ARROW){
        s.dir(0,-1);
    }else if (keyCode === DOWN_ARROW){
        s.dir(0,1);
    }else if(keyCode === RIGHT_ARROW){
        s.dir(1,0);
    }else if (keyCode === LEFT_ARROW){
        s.dir(-1,0);
    }

}


