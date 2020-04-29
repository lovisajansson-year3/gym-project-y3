$(document).ready(function () {
	console.log("ts")

	$("#FindTrainingSession").click( function() {
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
					$("#sessionError").text("session added" ); 
					buildTable();
					populateTrainingSessions();
					} 
				function ajaxAddReturnError(result, status, xhr) {
					if(result.status=="409"){
						console.log("this instructor already has a trainingsession at this time")
						$("#sessionError").text("this instructor already has a trainingsession at this time" ); 
					}else{
						console.log("Ajax-createsession: "+status); 
					}
					

					}
			}
		
	});//createbtn
	$("#UpdateTrainingSession").click( function() {
		    var sessionId = $("#sessionId").val();
		    var strInstructor = $("#instructor").val();
			var strStartDate = $("#startDate").val();
			console.log(strStartDate + strStartTime);
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
				$("#sessionError").text("session updated" ); 
				buildTable();
				populateTrainingSessions();
				}
			function ajaxUpdateReturnError(result, status, xhr) { 
				if(result.status=="404"){
					console.log("session doesnt exist");
					$("#sessionError").text("session doesnt exist" ); 
				}else{
					console.log(result.status);
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
					$("#sessionId").val("");
					$("#sessionError").text("Session deleted" );
					buildTable();
					populateTrainingSessions();
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					if(result.status=="404"){
						$("#sessionError").text("Session doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						$("#sessionError").text("cannot delete sessions that has bookings" );
						console.log(result.status);

					}else{
					alert("Error"); 
					console.log(result.status);
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
	var strInstructor = $("#instructor").val();
	var strStartDate = $("#startDate").val();
	var strStartTime = $("#startTime").val();
	var strType = $("#type").val();
	var strRoomNumber = $("#roomNumber").val();

	var b = true; 
	
	if (strInstructor == null || strInstructor == "") { //value blank?
		b=false;
		}
	if (strStartDate == null || strStartDate == "") { //value blank?
		b=false;
		}
	if (strStartTime == null || strStartTime == "") { //value blank?
		b=false;
		}
	if (strType == null || strType == "") { //value blank?
		b=false;
		 }
	if (strRoomNumber == null || strRoomNumber == "") { //value blank?
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
}