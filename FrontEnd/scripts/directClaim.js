


function setHospitalClaim(){
    console.log("Hospitral claim");
 
    let claim = {
        selected:"Hospital Claim"
    }
    localStorage.setItem('choosen_claim',JSON.stringify(claim));
    location.href="../html/claim_step1.html";
}
function setcallclaim(){
    console.log("call claim");
    
    let claim = {
        selected:"Call & Claim"
    };

    localStorage.setItem('choosen_claim',JSON.stringify(claim));
    location.href="../html/claim_step1.html";
}
