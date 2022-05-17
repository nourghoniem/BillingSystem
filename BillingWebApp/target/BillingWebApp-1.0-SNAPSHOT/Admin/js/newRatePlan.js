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
         let elem=`<br><input type="checkbox"  name=${value.service_type} value=${value.id}>
                               <label for=${value.service_type}> ${value.amount+" "+stmt}</label>`;
          
        $("#"+value.service_type).append(elem);
    });    
}

function getFreeUnits(arrayServices){
    console.log(arrayServices)
    $.each(arrayServices,function(index, value){
        let stmt="";
      $.getScript("js/viewRatePlan.js", function () {
        stmt+=getDescription(value);
         let elem=`<input type="radio"  name="freePkgs" value=${value.id}>
                               <label for="freePkgs"> ${value.amount+" "+stmt}</label><br>`;
        $("#fpk").append(elem);
    });    
    });
    
}
function getnonRating(arrayServices){
      console.log(arrayServices)
    $.each(arrayServices,function(index, value){

         let elem=`<input type="radio"  name="otherPkgs" value=${value.id}>
                               <label for="otherPkgs"> ${value.name+":EGP "+value.price}</label><br>`;
        $("#opk").append(elem);
    });    

    
    
}