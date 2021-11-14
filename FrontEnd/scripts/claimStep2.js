let selected_claim=JSON.parse(localStorage.getItem("choosen_claim"));
document.getElementById("claim_heading").innerText=selected_claim.selected;
if(selected_claim.selected=="Call & Claim"){
    document.getElementById("call_icon").classList.remove('d-none');

}
function submit(){
    console.log("submit");
    document.getElementById("form_claim").classList.remove("d-block");
document.getElementById("form_claim").classList.add('d-none');
document.getElementById("nav_steps_img").classList.add('d-none'); 
document.getElementById("processing").classList.remove('d-none');
setTimeout(()=>{
    let img=document.getElementById("nav_steps_img");
    img.src="../icons/Component 8payment_success.svg";
    img.classList.remove('d-none');
    img.classList.add("d-block"); 
    document.getElementById("processing").classList.add('d-none');
   document.getElementById("content_success").classList.remove('d-none');

  },2000);
  storedetails();

}
function removelclstg(){
    localStorage.removeItem('choosen_claim');
    location.href="../html/home_navigation.htm"
}

function storedetails(){
   let claim_details=JSON.parse(localStorage.getItem('claim_details'));
     claim_details.name=document.getElementById("select_name").value,
    claim_details.aadharNo=document.getElementById("select_aadharno").value,
    claim_details.membershipno=document.getElementById('select_membershipno').value
    
    localStorage.setItem('claim_details',JSON.stringify(claim_details));
    
}

function post_claim_data(){
 let claim=localStorage.getItem("claim_details");
    // let response = await fetch(`http://localhost:8070/claim/{policyBookingId}/{userId}/{memberId}`,{
    //     method: "POST",
    //     body: JSON.stringify({
    //          type:null,
    //         aadharNumber:
    //         nameOfMember:
    //         hospitalName:
    //         dateOfTreatment:
    //         submissionDate:
    //         status:
    //         claimItem:
    //         amountToClaim:
    //         preauthorizedConfirmation:
    //         followUpVisits:
    //     }),
//         headers:{"Content-Type": "application/json"}
//   });
}