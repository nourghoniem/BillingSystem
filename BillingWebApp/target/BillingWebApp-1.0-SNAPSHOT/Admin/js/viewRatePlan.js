/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function displayRateplans(rateplans){
    
    $.each(rateplans,function(index, value){
//        document.getElementById("rps").appendChild(appendRatePlan(value));
$("#rps").append(appendRatePlan(value));
$.each(value.sp,function(index, spvalue){
//        document.getElementById("rps").appendChild(appendRatePlan(value));
         let x=spvalue.amount+getDescription(spvalue);
  let xyz=`<div><i class="fas fa-check"></i><span> ${x}</span></div>`;
$("#card"+value.id).append(xyz);
    });
   $("#card"+value.id).append(addOthers(value));
    });
    
}

function appendRatePlan(value){
    let pid="card"+value.id.toString();
    let rp=`
                        <div class="col-md-4" id=${value.id}">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                <span style="font-size: 23px;" >${value.name}</span></div>
                                                     
                                                <div class="h5 mb-0 font-weight-bold text-gray-800" ><span>EGP ${value.price}\\month</span></div>
                                          <hr class="sidebar-divider my-0">
                                        </div>
                                        <div class="col-auto">
                                            <i class="fa fa-diamond fa-2x text-gray-300 " aria-hidden="true"></i>
                                        </div></div>
   
                                <div class="card mb-4" style="margin-top: 2%; user-select: auto;border: none;">
                                <div class="card-header" style="user-select: auto;" >
                                   <p style="display:inline;font-weight: bold;"><stong>Your Plan benefits</strong></p>
                                </div>
                                <div class="card-body details" id=${pid} style="user-select: auto;">
                                 
                                       
                                        
                               
                                </div>
                            </div>
                            
                                   
                                </div>
                            </div>
                        </div>
                    </div>`;
    
    return rp;
}

function getDescription(spvalue){
   
    let statement="";
    switch(spvalue.service_type){
        case "voice":
            statement+=" Mins"+"  "+"to  "+chkDestination(spvalue.service_destination);
            
            break;
        case "SMS":
           statement+=" Sms"+"  "+"to  "+chkDestination(spvalue.service_destination);
            break;
                case "data":
            statement+=" Mbs Data";
            break;
    }
    return statement;
    
}

function chkDestination(sd){
    let statement="";
    switch(sd){
    case "on-net":
        statement+="ORG Users";
        break;
    case "cross-net":
        statement+="Other Networks";
        break;
    case"international":
        statement+="Intenational calls";
        break;
        case"roaming":
        statement+="Roaming calls";
        break;}
    
    return statement;
}

function addOthers(value){
    let x=value.freeUnits.amount+getDescription(value.freeUnits);
 let st=  ` <p style="color:red;display:inline"> Other Services  </p>
 <hr class="sidebar-divider my-0">
                 <div>
                   <i class="fas fa-check"></i><span> ${value.nonrating.name+": EGP "+ value.nonrating.price}</span><br>
                <i class="fas fa-check"></i><span> Installement up to: EGP ${value.price *120}  </span><br>
                <i class="fas fa-check"></i><span> Shopping Online Up to:${value.price *50} </span></div>
    
   <p style="color:red;display:inline"> FreeUnits </p>
     <hr class="sidebar-divider my-0">
    <div><i class="fas fa-check"></i><span> ${x}</span></div>`;
   
    return st;
}