
// var dt = new Date();

// document.getElementById("time").innerHTML = `${dt.getHours()}:${dt.getMinutes()}`;

let input_regis_log = document.querySelectorAll(".input_regis_log");

input_regis_log.forEach((input) => {
    input.addEventListener('click', (e) => {
        e.target.style.borderBottom = "1px solid #063035";
        input_regis_log.forEach((i) =>{
            if(i != e.target && i.value.length <= 0){
                i.style.borderBottom = "1px solid #C4C4C4";
            }
        })
    });
});

let email_symb = document.getElementById("email_symb");
let email_error = document.getElementById("email_error");
let mobile_symb = document.getElementById("mobile_symb");
let mobile_error = document.getElementById("mobile_error");
let name_symb = document.getElementById("name_symb");
let name_error = document.getElementById("name_error");
let pass_symb = document.getElementById("pass_symb");
let pass_error = document.getElementById("pass_error");

let name_in = document.getElementById("name_input");
let email_in = document.getElementById("email_input");
let mob_in = document.getElementById("mob_input");
let pass_in = document.getElementById("pass_input");
let confirm_pass_in = document.getElementById("confirm_pass_input");


let submit_btn = document.getElementById("submit_btn");

submit_btn.addEventListener('click', async(e) =>{
    let name_input = name_in.value;
    let email_input = email_in.value;
    let mob_input = mob_in.value;
    let pass_input = pass_in.value;
    let confirm_pass_input = confirm_pass_in.value;
    let otp_input = document.getElementById("otp").value;

    e.preventDefault();

    clearAllErrors();

    if(pass_input == confirm_pass_input){

        const loginData = {
            userName : name_input,
            userEmail : email_input,
            userMobile : mob_input,
            userPass : pass_input,
            otp : otp_input
        };
    
        fetch("http://localhost:8070/user/authenticate", {
            method:"POST",
            body: JSON.stringify(loginData),
            mode: 'cors',
            headers:{
                "Content-Type":"application/json; charset=UTF-8"
            },
        })
        .then((res) => {
           if(res.status == 200){
               showOTPEnter();
               disableInput();
           }
           else if(res.status == 406){
                email_symb.style.visibility = "visible";
                email_error.style.visibility = "visible";
                email_error.innerText = "Enter correct email";
           }
           else if(res.status == 417){
                mobile_symb.style.visibility = "visible";
                mobile_error.style.visibility = "visible";
                mobile_error.innerText = "Enter correct mobile number";
           }
           else{
                res.json().then((r) =>{
                    if(r.message == "Enter name"){
                        name_symb.style.visibility = "visible";
                        name_error.style.visibility = "visible";
                        name_error.innerText = "Enter name";
                    }
                    else if(r.message == "Name should be more than 2 characters"){
                        name_symb.style.visibility = "visible";
                        name_error.style.visibility = "visible";
                        name_error.innerText = "Name should be more than 2 characters";
                    }
                    else if(r.message == "Enter email"){
                        email_symb.style.visibility = "visible";
                        email_error.style.visibility = "visible";
                        email_error.innerText = "Enter email";
                    }
                    else if(r.message == "Email Already Registered"){
                        email_symb.style.visibility = "visible";
                        email_error.style.visibility = "visible";
                        email_error.innerText = "Email Already Registered";
                    }
                    else if(r.message == "Enter mobile"){
                        mobile_symb.style.visibility = "visible";
                        mobile_error.style.visibility = "visible";
                        mobile_error.innerText = "Enter mobile";
                    }
                    else if(r.message == "Mobile Already Registered"){
                        mobile_symb.style.visibility = "visible";
                        mobile_error.style.visibility = "visible";
                        mobile_error.innerText = "Mobile Already Registered";
                    }
                    else if(r.message == "Enter pass"){
                        pass_symb.style.visibility = "visible";
                        pass_error.style.visibility = "visible";
                        pass_error.innerText = "Enter password";
                    }
                    else if(r.message == "Password should be more that 4 characters"){
                        pass_symb.style.visibility = "visible";
                        pass_error.style.visibility = "visible";
                        pass_error.innerText = "Password should be more that 4 characters";
                    }
                })
            }
        })
        
    }
    else{
        document.getElementById("confirm_symb").style.visibility = "visible";
        document.getElementById("confirm_error").style.visibility = "visible";
        document.getElementById("confirm_error").innerText = "Password does not match";
    }
})

let otp_error = document.getElementById("otp_error");

let enter_btn = document.getElementById("enter_btn");

enter_btn.addEventListener('click', async(e) =>{
    let name_input = name_in.value;
    let email_input = email_in.value;
    let mob_input = mob_in.value;
    let pass_input = pass_in.value;
    let otp_input = document.getElementById("otp").value;

    clearAllErrors();

    e.preventDefault();

    const loginData = {
        userName : name_input,
        userEmail : email_input,
        userMobile : mob_input,
        userPass : pass_input,
        otp : otp_input
    };

    fetch("http://localhost:8070/user/authenticate", {
        method:"POST",
        body: JSON.stringify(loginData),
        mode: 'cors',
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
    })
    .then((res) => {
        if(res.status == 201){
            res.json().then((r) => {
                localStorage.setItem("UserID", JSON.stringify(r));
                window.location = "./home_navigation.htm";
            })
        }
        else{
            res.json().then((r) =>{
                if(r.message == "Incorrect OTP entered"){
                    otp_error.style.visibility = "visible";
                    otp_error.innerText = "Incorrect OTP entered";
                }
                else if(r.message == "OTP not entered"){
                    otp_error.style.visibility = "visible";
                    otp_error.innerText = "OTP not entered";
                }
            })
        }

    })

})

let cancel = document.getElementById("cancel");

cancel.addEventListener('click', async(e) =>{
    let name_input = name_in.value;
    let email_input = email_in.value;
    let mob_input = mob_in.value;
    let pass_input = pass_in.value;
    let otp_input = document.getElementById("otp").value;

    e.preventDefault();

    const loginData = {
        userName : name_input,
        userEmail : email_input,
        userMobile : mob_input,
        userPass : pass_input,
        otp : otp_input
    };

    fetch("http://localhost:8070/user/phoneotp", {
        method:"POST",
        body: JSON.stringify(loginData),
        mode: 'cors',
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
    })
    .then((res) =>{
        showRegister();
        enableInput();
    })
})


let clearAllErrors = () =>{
    let vanish = document.querySelectorAll(".vanish");
    vanish.forEach((e) => {
        e.style.visibility = "hidden";
    })
}

let showOTPEnter = () =>{
    document.getElementById("regis").style.visibility = "hidden";
    document.getElementById("otp_enter").style.visibility = "visible";
}

let showRegister = () =>{
    document.getElementById("regis").style.visibility = "visible";
    document.getElementById("otp_enter").style.visibility = "hidden";
}

let disableInput = () =>{
    name_in.disabled = true;
    email_in.disabled = true;
    mob_in.disabled = true;
    pass_in.disabled = true;
    confirm_pass_in.disabled = true;
}

let enableInput = () =>{
    name_in.disabled = false;
    email_in.disabled = false;
    mob_in.disabled = false;
    pass_in.disabled = false;
    confirm_pass_in.disabled = false;
}

