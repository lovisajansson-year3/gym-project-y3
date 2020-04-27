$(document).ready(function () {
	$("#FindTrainingSession").click( function() {
		var strValue = $("#sessionId").val(); 
		if (strValue == ""|| strValue.isNaN()||strValue==null) { 
			$("#sessionId").attr("placeholder","enter valid sessionId" ); 
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
			$("#sessionId").val("");
			if(result.status=="404"){
				console.log("doesnt exist")
				$("#sessionId").attr("placeholder","Session doesnt exist" ); 
		}
		}
		}
		
	});//findbtn
	$("#CreateTrainingSession").click( function() {
		    var strInstructor = $("#instructor").val();
			var strStartDate = $("#startDate").val();
			var strStartTime = $("#startTime").val();
			var strType = $("#type").val();
			var strRoomNumber = $("#roomNumber").val();
			var date = strStartDate+" "+strStartTime;
			var obj = { instructor: strInstructor, startTime: date, type: strType, roomNumber: strRoomNumber}; 
			var jsonString = JSON.stringify(obj); 
			if(isTrainingSessionFormValid()==true){
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
					$("#sessionId").attr("placeholder","session added" ); 
					} 
				function ajaxAddReturnError(result, status, xhr) {
					clearTrainingSessionFields();
					if(result.status=="409"){
					$("#sessionId").attr("placeholder","this instructor already has a trainingsession at this time" ); 
					}else{
						alert("Error post");  
						console.log("Ajax-createsession: "+status); 
					}
					

					}
			}else{
				$("#sessionId").val("");
				$("#sessionId").attr("placeholder","fill in session details" ); 
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
		if(sessionId==null||sessionId==""||sessionId.isNaN()){
			$("#sessionId").val("");
			$("#sessionId").attr("placeholder","fill in a valid sessionid" ); 
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
				$("#sessionId").attr("placeholder","session updated" ); 
				}
			function ajaxUpdateReturnError(result, status, xhr) { 
				if(result.status=="404"){
					$("#sessionId").val("");
					$("#sessionId").attr("placeholder","session doesnt exist" ); 
				}else{
					alert("Error updating"); 
					console.log(result.status);
				}
				
		}
		}
	})//updatebtn
	$("#DeleteTrainingSession").click( function() {
		var sessionId = $("#sessionId").val();
		if(sessionId==null||sessionId==""||sessionId.isNaN()){
			$("#sessionId").val("");
			$("#sessionId").attr("placeholder","fill in a valid sessionid" ); 
		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/"+strValue,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
					$("#sessionId").val("");
					$("#sessionId").attr("placeholder","Session deleted" );           
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					if(result.status=="404"){
						$("#sessionId").attr("placeholder","Session doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						$("#sessionId").attr("placeholder","cannot delete sessions that has bookings" );
						console.log(result.status);

					}else{
					alert("Error"); 
					console.log(result.status);
					}
					}
				}	
	});//dltbtn
		$("#FindByMemberId").click( function() { 
			var strValue = $("#memberId").val(); 
			if (strValue == ""||strValue.isNaN()) { 
				$("#memberId").attr("placeholder","enter memberid"); 	

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
		alert("hej");
		var strValue = $("#memberId").val();
		alert(strValue);
		if (strValue ==""||strValue==null||strValue.isNaN()) { 
			$("#memberId").attr("placeholder","enter valid numeric memberId of member you would like to delete");

		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/GymMemberServlet/"+strValue,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
					$("#memberId").attr("placeholder","Movie deleted" );           
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					if(result.status=="404"){
						clearFields();
						$("#memberId").attr("placeholder","member doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						clearFields();
						$("#memberId").attr("placeholder","cannot delete member that has bookings" );
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
			}
			
			
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
					$("#memberId").val("");
					if(result.status=="404"){
					$("#memberId").attr("placeholder","GymMember doesnt exist" ); 

					}
				}
				}
			}
			});//btnclick
		$("#FindBooking").click( function() {
			var strValue = $("#bookingId").val(); 
			if (strValue == ""||strValue==null||strValue.isNaN()) { 
				clearBookingFields();
				$("#bookingId").attr("placeholder","enter numeric bookingId" ); 
			}else{
				$.ajax({
					type: 'GET', 
					url: "http://localhost:8080/GymProjectClient/BookingServlet/"+strValue,  
					error: ajaxFindReturnError,  
					success: ajaxFindReturnSuccess 
				})
					
			function ajaxFindReturnSuccess(result, status, xhr) {
					console.log("booking found")
					ParseJsonFileBooking(result); 
				
			} 
				function ajaxFindReturnError(result, status, xhr) { 
					clearBookingFields();
					if(result.status=="404"){
						console.log("doesnt exist")
						$("#sessionId").attr("placeholder","booking doesnt exist" ); 
					}
				}
			}
				
				
				
			});//findbtn	

	$("#CreateBooking").click( function() {
		alert("create booking");
	    var strBookingSessionId = $("#bookingSessionId").val();
		var strBookingMemberId = $("#bookingMemberId").val();
		var obj = { sessionId: strBookingSessionId, memberId: strBookingMemberId}; 
		var jsonString = JSON.stringify(obj); 
		if($("#bookingSessionId").val()==""||$("#bookingMemberId").val()==""
			||$("#bookingSessionId").val().isNaN()||$("#bookingMemberId").val().isNaN()
			 ||$("#bookingSessionId").val()==null||$("#bookingMemberId").val()==null){
			clearBookingFields();
			$("#bookingMemberId").attr("placeholder","fill in details" ); 
			$("#bookingSessionId").attr("placeholder","fill in details" ); 

		}else{
			$.ajax({
				type: "POST", 
				url: "http://localhost:8080/GymProjectClient/BookingServlet/",  
				data: jsonString, 
				dataType:'json', 
				error: ajaxAddReturnError,  
				success: ajaxAddReturnSuccess 
				}); 
			function ajaxAddReturnSuccess(result, status, xhr) {
				clearBookingFields();
				console.log("booking created")
				$("#bookingId").attr("placeholder","booking added" ); 
				} 
			function ajaxAddReturnError(result, status, xhr) {
				clearBookingFields();
				if(result.status=="404"){
					$("#bookingId").attr("placeholder","instructor or memberId doesnt exist" ); 
					console.log("member or session doesnt exist")
				}else{
					alert("Error post");  
					console.log("Ajax-createsession: "+status); 
				}
			}
		}
	});//createbtn
	$("#DeleteBooking").click( function() {
		var bookingId = $("#bookingId").val();
		if(bookingId==null||bookingId==""||!bookingId.isNaN()){
			clearBookingFields();
			$("#bookingId").attr("placeholder","fill in a valid bookingId" ); 
		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/BookingServlet/"+strValue,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
					clearBookingFields();
					$("#bookingId").attr("placeholder","Session deleted" );           
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					clearBookingFields();

					if(result.status=="404"){
						$("#bookingId").attr("placeholder","Session doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						$("#bookingId").attr("placeholder","cannot delete sessions that has bookings" );
						console.log(result.status);

					}else{
					alert("Error"); 
					console.log(result.status);
					}
					}
				}	
	});//dltbtn
		
});
	function ParseJsonFileMovie(result) { 
		$("#name").val(result.name); 
		$("#address").val(result.address);
		$("#email").val(result.email); 
		$("#phoneNumber").val(result.phoneNumber);
		$("#memberId").val(result.memberId);


	}
	function clearBookingSessionFields(){
		$("#bookingMemberId").val("");
		$("#bookingSessionId").val("");
		$("bookingId").val("");
	
	}
	function clearTrainingSessionFields(){
		$("#instructor").val("");
		$("#startDate").val("");
		$("#startTime").val("");
		$("#type").val("");
		$("#roomNumber").val("");
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
function ParseJsonFileBooking(result) { 
	$("#bookingSessionId").val(result.sessionId);
	$("#bookingMemberId").val(result.memberId);
}