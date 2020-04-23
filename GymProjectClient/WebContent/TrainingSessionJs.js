$(document).ready(function () {
	$("#FindTrainingSession").click( function() {
		var strValue = $("#sessionId").val(); 
		if (strValue != "") { 
			$.ajax({
				type: 'GET', 
				url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/"+strValue,  
				error: ajaxFindReturnError,  
				success: ajaxFindReturnSuccess 
			})
				
		function ajaxFindReturnSuccess(result, status, xhr) {
			ParseJsonFileTrainingSession(result); 
		} 
		function ajaxFindReturnError(result, status, xhr) { 
			alert("Error"); 
			console.log("Ajax-find movie: "+status); 
			}
		}
	});//findbtn
	$("#CreateTrainingSession").click( function() {
		alert("Error"); 

	});//createbtn
	$("#UpdateTrainingSession").click( function() {
		alert("Error"); 

	})//updatebtn
	$("#DeleteTrainingSession").click( function() {
		alert("Error"); 

	});//dltbtn
	
});
function ParseJsonFileTrainingSession(result) { 
	$("#instructor").val(result.instructor);

	$("#roomNumber").val(result.roomNumber);
	var str = result.startTime;
	
	var dt = str.substr(0,10);
	console.log(dt);
	$("#startDate").val(dt);
	$("#sessionId").val(result.sessionId);
	$("#type").val(result.type);
	$("#roomNumber").val(result.roomNumber);

		   
		

	

}
function clearFields() { 
	$("#name").val(""); 
	$("#address").val("");
	$("#email").val(""); 
	$("#phoneNumber").val("");
	$("#memberId").val("");
} 
