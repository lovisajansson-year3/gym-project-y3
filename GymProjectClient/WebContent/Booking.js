$("#FindTrainingSession").click( function() {
		var strValue = $("#bookingId").val(); 
		if (strValue != ""&& strValue.isNumeric()) { 
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
				$("#bookingId").val("");
				if(result.status=="404"){
					console.log("doesnt exist")
					$("#sessionId").attr("placeholder","booking doesnt exist" ); 
				}
			}
			}else if(!strValue.isNumeric()){
				$("#bookingId").val("");
				$("#bookingId").attr("placeholder","enter numeric bookingId" ); 
			}else{
				$("#bookingId").val("");
				$("#bookingId").attr("placeholder","enter bookingId" ); 
			}
			
		});//findbtn	

$("#CreateBooking").click( function() {
    var strBookingSessionId = $("#bookingSessionId").val();
	var strBookingMemberId = $("#bookingMemberId").val();
	var obj = { sessionId: strBookingSessionId, memberId: strBookingMemberId}; 
	var jsonString = JSON.stringify(obj); 
	if($("#bookingSessionId").val()!=""&&$("#bookingMemberId").val()!=""
		&&$("#bookingSessionId").val().isNumeric()&&$("#bookingMemberId").val().isNumeric()){
		$.ajax({
			type: "POST", 
			url: "http://localhost:8080/GymProjectClient/BookingServlet/",  
			data: jsonString, 
			dataType:'json', 
			error: ajaxAddReturnError,  
			success: ajaxAddReturnSuccess 
			}); 
		function ajaxAddReturnSuccess(result, status, xhr) {
			$("#bookingSessionId").val("");
			$("#bookingMemberId").val("");
			$("#bookingId").val("");
			console.log("booking created")
			$("#bookingId").attr("placeholder","booking added" ); 
			} 
		function ajaxAddReturnError(result, status, xhr) {
			$("#bookingSessionId").val("");
			$("#bookingMemberId").val("");
			$("#bookingId").val("");
			if(result.status=="404"){
				$("#bookingId").attr("placeholder","instructor or memberId doesnt exist" ); 
				console.log("member or session doesnt exist")
			}else{
				alert("Error post");  
				console.log("Ajax-createsession: "+status); 
			}
			

			}
	}else{
		$("#bookingId").val("");
		$("#bookingIs").attr("placeholder","fill in session details" ); 
	}

});//createbtn
$("#DeleteTrainingSession").click( function() {
	var bookingId = $("#bookingId").val();
	if(bookingId==null||bookingId==""||!bookingId.isNumeric()){
		$("#bookingId").val("");
		$("#bookingId").attr("placeholder","fill in a valid bookingId" ); 
	}else{
		$.ajax({ 
			method: "DELETE",   
			url: "http://localhost:8080/GymProjectClient/BookingServlet/"+strValue,  
			error: ajaxDelReturnError,  
			success: ajaxDelReturnSuccess         
			})
			function ajaxDelReturnSuccess(result, status, xhr) { 
				$("#bookingId").val("");
				$("#bookingId").attr("placeholder","Session deleted" );           
			} 
			function ajaxDelReturnError(result, status, xhr) { 
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
