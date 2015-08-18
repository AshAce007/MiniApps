/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
var timer = function() { //showing the moving bar after 3-4 seconds
    time=0;
    var display = setInterval(function() {
        time ++;
        if(time > Math.random()*4+3)
            $("#myJS").css("visibility","visible");
        //clearInterval(display);
    },1000);
};
timer();
    
var movingBar = function() { // moving bar on the chart
    var posX = 0;
    setInterval(function() {
        posX = Math.random()*450+400;
        //posY = (Math.random()*(50)+(10));
        document.getElementById("myJS").style.left = posX+"px";
        //document.getElementById("myJS").style.bottom = posY+"px";
        //document.getElementById("myJS").style.top = posY+"px";
    },Math.random()*700+500);
    
    $("#hideBar").click(function() {
        $("#myJS").hide();
    });
};
movingBar();

