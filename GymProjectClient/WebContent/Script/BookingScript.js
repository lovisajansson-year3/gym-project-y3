$(document).ready(function () {
	console.log("bks")

	
		$("#FindBooking").click( function() {
			var strValue = $("#bookingId").val(); 
			if (strValue == ""||strValue==null||isNaN(strValue)) { 
				clearBookingFields();
				$("#bookingError").text("enter numeric bookingId" ); 
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
						$("#bookingError").text("booking doesnt exist" ); 
					}
				}
			}
				
				
				
			});//findbtn	

	$("#CreateBooking").click( function() {
	    var strBookingSessionId = $("#bookingSessionId").val();
		var strBookingMemberId = $("#bookingMemberId").val();
		var obj = { sessionId: strBookingSessionId, memberId: strBookingMemberId}; 
		var jsonString = JSON.stringify(obj); 
		if(isBookingFormValid()){
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
				$("#bookingError").text("booking added" );
				buildTable();
				populateBookings();
				} 
			function ajaxAddReturnError(result, status, xhr) {
				clearBookingFields();
				if(result.status=="404"){
					$("#bookingError").text("instructor or memberId doesnt exist" ); 
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
		if(bookingId==null||bookingId==""||isNaN(bookingId)){
			clearBookingFields();
			$("#bookingError").text("fill in a valid bookingId" ); 
		}else{
			$.ajax({ 
				method: "DELETE",   
				url: "http://localhost:8080/GymProjectClient/BookingServlet/"+bookingId,  
				error: ajaxDelReturnError,  
				success: ajaxDelReturnSuccess         
				})
				function ajaxDelReturnSuccess(result, status, xhr) { 
					clearBookingFields();
					$("#bookingError").text("Session deleted" );
					buildTable();
					populateBookings();
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					clearBookingFields();

					if(result.status=="404"){
						$("#bookingError").text("Session doesnt exist" );   
						console.log(result.status);

					}else if(result.status="409"){
						$("#bookingError").text("cannot delete sessions that has bookings" );
						console.log(result.status);

					}else{
					alert("Error"); 
					console.log(result.status);
					}
					}
				}	
	});//dltbtn
});
	
	function clearBookingFields(){
		$("#bookingMemberId").val("");
		$("#bookingSessionId").val("");
		$("bookingId").val("");
	
	}
	

	function  isBookingFormValid(){
		var strBookingMemberId = document.getElementById("bookingMemberId");
		var strBookingSessionId = document.getElementById("bookingSessionId");
		var b = true; 
		if (!strBookingMemberId.checkValidity()) { //value blank?
			strBookingMemberId.placeholder=strBookingMemberId.validationMessage;
			b=false;
			}
		if (!strBookingSessionId.checkValidity()) { //value blank?
			strBookingSessionId.placeholder=strBookingSessionId.validationMessage;
			b=false;
		}
		return b;
		
	}


	function ParseJsonFileBooking(result) { 
		$("#bookingSessionId").val(result.sessionId);
		$("#bookingMemberId").val(result.memberId);
	}

	
