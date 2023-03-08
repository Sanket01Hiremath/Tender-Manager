	// Admin api_url
	const getTenders ="http://localhost:8088/Admin/getTenders";
	const getVendors ="http://localhost:8088/Admin/getVendors";
	/*const addTender ="http://localhost:8088/Admin/NewTender";
	const addVendor ="http://localhost:8088/Admin/NewVendor";*/
	  
	// Defining async function
	async function getapi(url,str) {
	    // Storing response
	    const response = await fetch(url);
	    
	    // Storing data in form of JSON
	    var data = await response.json();
	    console.log(data);
	    let heading=document.getElementById("tableHead");
	    if(str=="tender"){
			showTenders(data);
			heading.innerText="Tenders";
		}else if(str=="vendor"){
			showVendors(data);
			heading.innerText="Vendors";
		}
	}
	// Calling that async function
	
	
	 
	// Function to define innerHTML for HTML table
	function showTenders(data) {
	    let tab = 
	        `<tr>
	          <th>Id</th>
	          <th>Name</th>
	          <th>Type</th>
	          <th>Amount</th>
	         </tr>`;
	    
	    // Loop to access all rows 
	    for (let r of data) {
	        tab += `<tr> 
					    <td>${r.tid} </td>
					    <td>${r.name}</td>
					    <td>${r.type}</td> 
					    <td>${r.minBidAmount}</td>          
					</tr>`;
	    }
	    // Setting innerHTML as tab variable
	    document.getElementById("table").innerHTML = tab;
	}
	
	function showVendors(data) {
	    let tab = 
	        `<tr>
	          <th>User Id</th>
	          <th>UserName</th>
	          <th>Password</th>
	         </tr>`;
	    
	    // Loop to access all rows 
	    for (let r of data) {
	        tab += `<tr> 
					    <td>${r.uid} </td>
					    <td>${r.username}</td>
					    <td>${r.password}</td>        
					</tr>`;
	    }
	    // Setting innerHTML as tab variable
	    document.getElementById("table").innerHTML = tab;
	}