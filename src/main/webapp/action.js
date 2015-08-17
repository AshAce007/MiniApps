/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    var posX = 0, posY = 0, time=0;
     var timer = function() { //showing the moving bar after 3-4 seconds
        var display = setInterval(function() {
            time ++;
            if(time > Math.random()*4+3)
                $("#myJS").css("visibility","visible");
            //clearInterval(display);
        },1000);
    };
    timer();
    setInterval(function() {
        posX = Math.random()*450+400;
        document.getElementById("myJS").style.left = posX+"px";
        //document.getElementById("myJS").style.top = posY+"px";
    },Math.random()*700+500);
});

