/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function Dis(values){
    
     $.each(values,function(index, value){
        
        switch(value.service_type){
            case "voice":
                
           getStatement(value);
              
                break;
          
            case "data":
                getStatement(value);
                break;
            case "SMS":
              getStatement(value);
          break;
        };
        
    });    
}
function getStatement(value){
   
                 let stmt="";
      $.getScript("js/viewRatePlan.js", function () {
        stmt+=getDescription(value);
         let elem=`<br><input type="checkbox"  name=svpid value=${value.id}>
                               <label for=svpid> ${value.amount+" "+stmt}</label>`;
          
        $("#"+value.service_type).append(elem);
    });    
}

function getFreeUnits(arrayServices){
    console.log(arrayServices)
    $.each(arrayServices,function(index, value){
        let stmt="";
      $.getScript("js/viewRatePlan.js", function () {
        stmt+=getDescription(value);
         let elem=`<input type="radio"  name="freePkgs" value=${value.id} required>
                               <label for="freePkgs"> ${value.amount+" "+stmt}</label><br>`;
        $("#fpk").append(elem);
    });    
    });
    
}
function getnonRating(arrayServices){
      console.log(arrayServices)
    $.each(arrayServices,function(index, value){

         let elem=`<input type="radio"  name="otherPkgs" value=${value.id} required>
                               <label for="otherPkgs"> ${value.name+":EGP "+value.price}</label><br>`;
        $("#opk").append(elem);
    });    

    
    
}
function valthisform()
{
    var checkboxs=document.getElementsByName("svpid");
    var okay=false;
    for(var i=0,l=checkboxs.length;i<l;i++)
    {
        if(checkboxs[i].checked)
        {
            okay=true;
            break;
        }
    }
    if(!okay)alert("you have to choose at least one service package");
   
}