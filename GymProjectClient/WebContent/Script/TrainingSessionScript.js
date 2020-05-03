$(document).ready(function () {
	console.log("ts")

	$("#sessionId").change( function() {
		var strValue = $("#sessionId").val(); 
		if (strValue == ""|| isNaN(strValue)||strValue==null) { 
			$("#sessionError").text("enter valid sessionId" ); 
		}else{
			$.ajax({
				type: 'GET', 
				url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/"+strValue,  
				error: ajaxFindReturnError,  
				success: ajaxFindReturnSuccess 
			})
				
		function ajaxFindReturnSuccess(result, status, xhr) {
				console.log("session found")
				ParseJsonFileTrainingSession(result); 
			
		} 
		function ajaxFindReturnError(result, status, xhr) { 
			
			if(result.status=="404"){
				console.log("doesnt exist")
				$("#sessionError").text("Session doesnt exist" ); 
			}else{
				$("#sessionError").text("error when retrieving session");
			}
		}
		}
		
	});//findbtn
	$("#CreateTrainingSession").click( function() {
		    var strInstructor = $("#instructor").val();
			var strStartDate = $("#startDate").val();
			var strStartTime = $("#startTime").val();
			var	strType = $("#type").val();
			var strRoomNumber = $("#roomNumber").val();
			var date = strStartDate+" "+strStartTime;
			var obj = { instructor: strInstructor, startTime: date, type: strType, roomNumber: strRoomNumber}; 
			var jsonString = JSON.stringify(obj); 
			if(isTrainingSessionFormValid()){
				$.ajax({
					type: "POST", 
					url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/",  
					data: jsonString, 
					dataType:'json', 
					error: ajaxAddReturnError,  
					success: ajaxAddReturnSuccess 
					}); 
				function ajaxAddReturnSuccess(result, status, xhr) {
					clearTrainingSessionFields();
					console.log("session created")
					$("#sessionCreateSuccess").text("session added" ); 
					buildTable();
					populateTrainingSessions();
					} 
				function ajaxAddReturnError(result, status, xhr) {
					clearTrainingSessionFields();

					if(result.status=="409"){
						console.log("this instructor already has a trainingsession at this time")
						$("#sessionCreateError").text("this instructor already has a trainingsession at this time" ); 
					}else{
						$("#sessionCreateError").text("error when trying to add session" ); 

						console.log("error when addind session: "+result.status); 
					}
					

					}
			}else{$("#sessionCreateError").text("please fill out fields" ); 
			}
		
	});//createbtn
	$("#UpdateTrainingSession").click( function() {
		    var sessionId = $("#sessionId").val();
		    var strInstructor = $("#instructor").val();
			var strStartDate = $("#startDate").val();
			var strStartTime = $("#startTime").val();
			var strType = $("#type").val();
			var strRoomNumber = $("#roomNumber").val();
			var date = strStartDate+strStartTime
		if(sessionId==null||sessionId==""||isNaN(sessionId)){
			
			$("#sessionError").text("fill in a valid sessionid" ); 
		}else{
			var obj = { instructor: strInstructor, startTime: date, type: strType, roomNumber: strRoomNumber}; 
		var jsonString = JSON.stringify(obj); 
		
			$.ajax({  
				type: "PUT", 
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strSessionId,   
				data: jsonString,  
				dataType:'json',  
				error: ajaxUpdateReturnError,   
				success: ajaxUpdateReturnSuccess      
				})
			function ajaxUpdateReturnSuccess(result, status, xhr) { 
				clearTrainingSessionFields(); 
				console.log("session updated");
				$("#sessionSuccess").text("session updated" ); 
				buildTable();
				populateTrainingSessions();
				}
			function ajaxUpdateReturnError(result, status, xhr) { 
				if(result.status=="404"){
					console.log("session doesnt exist");
					$("#sessionError").text("session doesnt exist" ); 
				}else{
					$("#sessionError").text("error when trying to update session" );
					console.log("error when trying to update session"+result.status);
				}
				
		}
		}
	})//updatebtn
	$("#DeleteTrainingSession").click( function() {
		var sessionId = $("#sessionId").val();
		if(sessionId==null||sessionId==""||isNaN(sessionId)){
			
			$("#sessionError").text("fill in a valid sessionid" ); 
		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/"+sessionId,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
					clearTrainingSessionFields();
					$("#sessionSuccess").text("Session deleted" );
					buildTable();
					populateTrainingSessions();
				} 
				function ajaxDelReturnError(result, status, xhr) {
					clearTrainingSessionFields();
					if(result.status=="404"){
						$("#sessionError").text("Session doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						$("#sessionError").text("cannot delete sessions that has bookings" );
						console.log(result.status);

					}else{
					$("#sessionError").text("error when trying to delete session" );
					console.log("error when trying to delete session" +result.status);
					}
					}
				}	
	});//dltbtn
})
function ParseJsonFileTrainingSession(result) { 
	$("#instructor").val(result.instructor);

	$("#roomNumber").val(result.roomNumber);
	var str = result.startTime;
	var tm = str.slice(11,16);
	var dt = str.substr(0,10);
	$("#startDate").val(dt);
	$("#startTime").val(tm);
	$("#sessionId").val(result.sessionId);
	$("#type").val(result.type);
	$("#roomNumber").val(result.roomNumber);

}
function  isTrainingSessionFormValid(){
	var strInstructor = document.getElementById("instructor");
	var strStartDate = document.getElementById("startDate");
	var strRoomNumber = document.getElementById("roomNumber");
	var strStartTime = document.getElementById("startTime");
	var strType = document.getElementById("type");
	var b = true; 
	
	if (!strInstructor.checkValidity()) { //value blank?
		$("#instructor").addClass("inputError");
		b=false;
		}
	if (!strStartDate.checkValidity()) { //value blank?
		$("#startDate").addClass("inputError");

		b=false;
		}
	if (!strStartTime.checkValidity()) { //value blank?
		$("#startTime").addClass("inputError");

		b=false;
		}
	if (!strType.checkValidity()) { //value blank?
		$("#type").addClass("inputError");

		b=false;
		 }
	if (!strRoomNumber.checkValidity()) { //value blank?
		$("#roomNumber").addClass("inputError");

		b=false;
		 }
	return b;
}
function clearTrainingSessionFields(){
	$("#instructor").val("");
	$("#startDate").val("");
	$("#startTime").val("");
	$("#type").val("");
	$("#roomNumber").val("");
	$("#sessionError").text("");
	$("#sessionSuccess").text("");
	$("#sessionCreateError").text("");
	$("#sessionCreateSuccess").text("");
}