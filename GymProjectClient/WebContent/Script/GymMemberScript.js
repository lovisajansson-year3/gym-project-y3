$(document).ready(function () {
	console.log("gms");
	
$("#memberId").change(function(){
	var strValue =$(this).val(); 
	if (strValue == ""||isNaN(strValue)) { 
			$("#memberId").attr("placeholder","enter valid memberid"); 	

		}else{
			$.ajax({
				type: 'GET', 
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strValue,  
				error: ajaxFindReturnError,  
				success: ajaxFindReturnSuccess 
			})
		}
				
		function ajaxFindReturnSuccess(result, status, xhr) {
			ParseJsonFileMovie(result); 
			console.log("member found");
		} 
		function ajaxFindReturnError(result, status, xhr) { 
			if(result.status=="404"){
				clearFields();
				$("#memberId").attr("placeholder","member doesnt exist")
			}else{
				alert("Error"); 
				console.log(result.status); 
			}
		}
		

	
	});//btnclick 

$("#DeleteByMemberId").click( function() {
		var strValue = $("#memberId").val();
		alert(strValue);
		if (strValue ==""||strValue==null||isNaN(strValue)) { 
			$("#memberError").text("enter valid numeric memberId of member you would like to delete");

		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strValue,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
				$("#memberSuccess").text("GymMember deleted" ); 
				buildTable();
				populateGymMembers();
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					if(result.status=="404"){
						clearFields();
						$("#memberError").text("member doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						clearFields();
						$("#memberError").text("cannot delete member that has bookings" );
						console.log(result.status);

					}else{
						clearFields();
					alert("Error"); 
					console.log(result.status);
					}
				}		
		}
		});//btnclick
		
		$("#CreateGymMember").click(    function(){     
	        var strName = $("#name").val();
			var strAddress = $("#address").val();
			var strEmail = $("#email").val();
			var strPhoneNumber = $("#phoneNumber").val();
			var obj = { name: strName, address: strAddress, email: strEmail, phoneNumber: strPhoneNumber}; 
			var jsonString = JSON.stringify(obj); 
			if(isGymMemberFormValid(null)){
				$.ajax({
					type: "POST", 
					url: "http://localhost:8080/GymProjectClient/GymMemberServlet/",  
					data: jsonString, 
					dataType:'json', 
					error: ajaxAddReturnError,  
					success: ajaxAddReturnSuccess 
					}); 
				function ajaxAddReturnSuccess(result, status, xhr) {
					clearFields();
					$("#memberCreateSuccess").text("GymMember added" ); 
					console.log("gymmember added");
					buildTable();
					populateGymMembers();
					} 
				function ajaxAddReturnError(result, status, xhr) {
					$("#memberCreateError").text("GymMember couldn't be added" ); 
					console.log("error when adding gym member: "+result.status); 
					}
			}else{
				$("#memberCreateError").text("please fill in fields" ); 

			}
			
			
	    });
		$("#UpdateGymMember").click( function() { 
			var strMemberId = $("#memberId").val();
			var strName = $("#name").val();
			var strAddress = $("#address").val();
			var strEmail = $("#email").val();
			var strPhoneNumber = $("#phoneNumber").val();
			console.log(strMemberId);
			if(strMemberId==null||strMemberId==""){
				$("#memberError").text("enter memberId of member you'd like to update")
			}else{
			var obj = { memberId: strMemberId ,name: strName, address: strAddress, email: strEmail, phoneNumber: strPhoneNumber}; 
			var jsonString = JSON.stringify(obj); 
				$.ajax({  
					type: 'PUT', 
					url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strMemberId,   
					data: jsonString,  
					dataType:'json',  
					error: ajaxUpdateReturnError,   
					success: ajaxUpdateReturnSuccess      
					})
				function ajaxUpdateReturnSuccess(result, status, xhr) { 
					clearFields(); 
					$("#memberSuccess").text("GymMember updated" );
					buildTable();
					populateGymMembers();
					}
				function ajaxUpdateReturnError(result, status, xhr) {
					if(result.status=="404"){
						$("#memberError").text("GymMember doesnt exist" ); 
						console.log("gymmember doesn't exist");
					}
					else{
						$("#memberError").text("GymMember couldn't be updated" ); 
						console.log("error when updating gym member: "+result.status); 
				}
				
				}
			}
			});//btnclick
		
})
function  isGymMemberFormValid2(){
	console.log("ej");
	var strName = document.getElementById("name2");
	var strAddress = document.getElementById("address2");
	var strEmail = document.getElementById("email2");
	var strPhoneNumber = document.getElementById("phoneNumber2");
	var b = true; 		
	if (!strName.checkValidity()) { //value blank?
		$("#name2").addClass("inputError");
		b=false;
		}
	if (!strAddress.checkValidity()) { //value blank?
		$("#address2").addClass("inputError");

		b=false;
		}
	if (!strEmail.checkValidity()) { //value blank?
		$("#email2").addClass("inputError");
		b=false;
		}
	if (!strPhoneNumber.checkValidity()) { //value blank?
		$("#phoneNumber2").addClass("inputError");

		b=false;
		 }

	return b;
}
function  isGymMemberFormValid(){
	
	
		var strName = document.getElementById("name");
		var strAddress = document.getElementById("address");
		var strEmail = document.getElementById("email");
		var strPhoneNumber = document.getElementById("phoneNumber");
		var b = true; 
				
		if (!strName.checkValidity()) { //value blank?
			$("#name").addClass("inputError");
			b=false;
			}
		if (!strAddress.checkValidity()) { //value blank?
			$("#address").addClass("inputError");

			b=false;
			}
		if (!strEmail.checkValidity()) { //value blank?
			$("#email").addClass("inputError");
			b=false;
			}
		if (!strPhoneNumber.checkValidity()) { //value blank?
			$("#phoneNumber").addClass("inputError");

			b=false;
		}
	
		
	
}

function clearFields() { 
	$("#name").val(""); 
	$("#address").val("");
	$("#email").val(""); 
	$("#phoneNumber").val("");
	$("#memberId").val("");
	$("#memberError").text("");
	$("#memberSuccess").text("");
	$("#memberCreateError").text("");
	$("#memberCreateSuccess").text("");

	
} 
function ParseJsonFileMovie(result) { 
	$("#name").val(result.name); 
	$("#address").val(result.address);
	$("#email").val(result.email); 
	$("#phoneNumber").val(result.phoneNumber);
	$("#memberId").val(result.memberId);


}