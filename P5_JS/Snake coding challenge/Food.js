class food{
    constructor(){
        this.x=0;
        this.y=0;
    }

    show(){
        fill(255,0,100);
        rect(this.x,this.y,scl,scl);
    }

    pickLocation(){
        let cols =floor(width/scl);
        let rows=floor(height/scl);
        this.x=floor(random(cols))*scl;
        this.y =floor(random(rows))*scl;
    }

}