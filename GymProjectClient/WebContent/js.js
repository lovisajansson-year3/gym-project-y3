$(document).ready(function () {
	alert("laddat");
	$("#FindByMemberId").click( function() { 
		var strValue = $("#memberId").val(); 
		alert(strValue);
		if (strValue != "") { 
			$.ajax({
				type: 'GET', 
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strValue,  
				error: ajaxFindReturnError,  
				success: ajaxFindReturnSuccess 
			})
				
		function ajaxFindReturnSuccess(result, status, xhr) {
			ParseJsonFileMovie(result); 
		} 
		function ajaxFindReturnError(result, status, xhr) { 
			alert("Error"); 
			console.log("Ajax-find movie: "+status); 
			}
		}
	
	
	});//btnclick 
	$("#findAll").click( function() { 
	
			$.ajax({
				type: 'GET', 
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/",  
				error: ajaxFindReturnError,  
				success: ajaxFindReturnSuccess 
			})
				
		function ajaxFindReturnSuccess(result, status, xhr) {
			System.out.println("find all success");
			ParseJsonFileMovie(result); 
		} 
		function ajaxFindReturnError(result, status, xhr) { 
			alert("Error"); 
			console.log("Ajax-find movie: "+status); 
			}
		
	
	
	});//btnclick 
$("#DeleteByMemberId").click( function() {
	var strValue = $("#memberId").val();
	if (strValue != "") { 
		$.ajax({ 
			method: "DELETE",   
			url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strValue,  
			error: ajaxDelReturnError,  
			success: ajaxDelReturnSuccess         
			})
			function ajaxDelReturnSuccess(result, status, xhr) { 
				$("#memberId").attr("placeholder","Movie deleted" );           
			} function ajaxDelReturnError(result, status, xhr) { 
				alert("Error"); 
				console.log("Ajax-find movie: "+status);
				}
			}
	else{
		$("#memberId").attr("placeholder","enter memberId of member you would like to delete");
		
	}
	});//btnclick
	
	$("#CreateGymMember").click(    function(){     
        var strName = $("#name").val();
		var strAddress = $("#address").val();
		var strEmail = $("#email").val();
		var strPhoneNumber = $("#phoneNumber").val();
		var obj = { name: strName, address: strAddress, email: strEmail, phoneNumber: strPhoneNumber}; 
		var jsonString = JSON.stringify(obj); 
		if(isGymMemberFormValid()==true){
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
				$("#name").attr("placeholder","GymMember added" ); 
				console.log("gymmember added");
				} 
			function ajaxAddReturnError(result, status, xhr) {
				alert("Error Add"); 
				console.log("Ajax-find movie: "+status); 
				}
		}console.log("add failed");
		
		
    });
	$("#UpdateGymMember").click( function() { 
		var strMemberId = $("#memberId").val();
		var strName = $("#name").val();
		var strAddress = $("#address").val();
		var strEmail = $("#email").val();
		var strPhoneNumber = $("#phoneNumber").val();
		if(strMemberId==null||strMemberId==""){
			$("#memberId").attr("placeholder","enter memberId of member you'd like to update")
		}else{
		var obj = { name: strName, address: strAddress, email: strEmail, phoneNumber: strPhoneNumber}; 
		var jsonString = JSON.stringify(obj); 
		if (strMemberId != "") { 
			$.ajax({  
				type: "PUT", 
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strMemberId,   
				data: jsonString,  
				dataType:'json',  
				error: ajaxUpdateReturnError,   
				success: ajaxUpdateReturnSuccess      
				})
			function ajaxUpdateReturnSuccess(result, status, xhr) { 
				clearFields(); 
				$("#memberId").attr("placeholder","GymMember updated" ); 
				}
			function ajaxUpdateReturnError(result, status, xhr) { 
				alert("Error Update");  
				console.log("Ajax-find movie: "+status); 
				}
			}
		}
		});//btnclick
	
});
function ParseJsonFileMovie(result) { 
	$("#name").val(result.name); 
	$("#address").val(result.address);
	$("#email").val(result.email); 
	$("#phoneNumber").val(result.phoneNumber);
	$("#memberId").val(result.memberId);
		   
		

	

}
function clearFields() { 
	$("#name").val(""); 
	$("#address").val("");
	$("#email").val(""); 
	$("#phoneNumber").val("");
	$("#memberId").val("");
} 
function  isGymMemberFormValid(){
	alert(")");
	var strName = $("#name").val();
	var strAddress = $("#address").val();
	var strEmail = $("#email").val();
	var strPhoneNumber = $("#phoneNumber").val();
	var b = true; 
	
	if (strName == null || strName == "") { //value blank?
		
		$("#name").attr("placeholder","Movie id, please." );
		b=false;
		}
	if (strAddress == null || strAddress == "") { //value blank?
		$("#address").attr("placeholder","Movie id, please." );
		b=false;
		}
	if (strEmail == null || strEmail == "") { //value blank?
		$("#email").attr("placeholder","Movie id, please." );
		b=false;
		}
	if (strPhoneNumber == null || strPhoneNumber == "") { //value blank?
		$("#phoneNumber").attr("placeholder","phoneNumber, please." );
		b=false;
		 }
	return b;
}
