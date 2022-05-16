/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function displayRateplans(rateplans){
    
    $.each(rateplans,function(index, value){
//        document.getElementById("rps").appendChild(appendRatePlan(value));
$("#rps").append(appendRatePlan(value));
    });
    
}

function appendRatePlan(value){
    let rp=`
                        <div class="col-xl-3 col-md-6 mb-4" id=${value.id} onclick="showDetails(${value.id})">
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
                                        </div>
   
                                <div class="card mb-4" style="margin-top: 2%; user-select: auto;border: none;">
                                <div class="card-header" style="user-select: auto;">
                                   <p style="display:inline;font-weight: bold;"><stong>Your Plan benefits</strong></p>
                                </div>
                                <div class="card-body details" style="user-select: auto;">
                                 
                                        <i class="fas fa-check"></i><span>\  hello</span>
                               
                                </div>
                            </div>
                            
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`;
    
    return rp;
}

function showDetails(id){
    console.log(id);
    
}