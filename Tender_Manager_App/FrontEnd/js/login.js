function login(){


let username = document.getElementById("username").value;
let password = document.getElementById("password").value;

fetch("http://localhost:8088/Login", {
    method: 'GET',
    headers: {
      'Authorization': 'Basic ' + btoa(username + ':' + password)
    }
  })
  .then(response => {

    if(response.status == 200 | response.status == 202){
        const token= response.headers.get("Authorization");
        console.log(token);
        localStorage.setItem("jwtToken", token);


        response.json().then(data => {

        localStorage.setItem("customerName", data.name);

        const url = "customerHome.html";

        location.href= url;


        })
    }else{
        alert("Invalid username or password.");
    }
  } )

}