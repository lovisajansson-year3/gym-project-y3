$(document).ready(function () {
	/*$("#GymMemberRegistration").validate({});
	$("#TrainingSessionRegistration").validate({		});
	$("#BookingRegistration").validate({		});*/
	$("#find").click( function() { 
		var strValue = $("#memberId").val(); 
		if (strValue != "") { 
			$.ajax({       
				method: "GET", 
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
	
	
	})//btnclick 
		
});
function ParseJsonFileMovie(result) { 
	$("#memberId").val(result.memberId); 
	$("#name").val(result.name); 
	$("#address").val(result.address); 
	$("#email").val(result.email); 
	$("#phoneNumber").val(result.phoneNumber); 


}
function clearFields() { 
	
} 

