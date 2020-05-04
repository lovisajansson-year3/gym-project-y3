$(document).ready(function () {
	console.log("bks");

	
		$("#bookingId").change( function() {
			var strValue = $(this).val(); 
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
					if(result.status=="409"){
						console.log("this member is already booked for this session")
						$("#bookingError").text("this member is already booked for this session" ); 
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
				console.log("booking added")
				$("#bookingCreateSuccess").text("booking added" );
				buildTable();
				populateBookings();
				} 
			function ajaxAddReturnError(result, status, xhr) {
				clearBookingFields();
				if(result.status=="404"){
					$("#bookingCreateError").text("instructor or memberId doesnt exist" ); 
					console.log("member or session doesnt exist");
				}if(result.status=="409"){
					$("#bookingCreateError").text("this booking already exist" ); 
					console.log("member or session doesnt exist");
				}else{
					$("#bookingCreateError").text("couldn't add booking"); 
					console.log("error when adding booking" +result.status); 
				}
			
			}
		}else{
		$("#bookingCreateError").text("select an instructor and member" ); 
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
					$("#bookingSuccess").text("booking deleted" );
					buildTable();
					populateBookings();
				} 
				function ajaxDelReturnError(result, status, xhr) { 
					clearBookingFields();

					if(result.status=="404"){
						$("#bookingError").text("booking doesnt exist" );   
						console.log("session doesn't exist"+result.status);

					}else{
						$("#bookingError").text("error when deleting");
					console.log("error when deleting booking "+result.status);
					}
					}
				}	
	});//dltbtn
});
	
	function clearBookingFields(){
		$('#bookingMemberId option:first').text();
		$('#bookingSessionId option:first').text();
		$("bookingId").val("");
		$("#bookingError").text("");
		$("#bookingSuccess").text("");
		$("#bookingCreateError").text("");
		$("#bookingCreateSuccess").text("");
		
	}
	

	function  isBookingFormValid(){
		var strBookingMemberId = document.getElementById("bookingMemberId");
		var strBookingSessionId = document.getElementById("bookingSessionId");
		var b = true; 
		if (!strBookingMemberId.checkValidity()) { //value blank?
			$("#bookingMemberId").addClass("inputError");

			b=false;
		
			}
		if (!strBookingSessionId.checkValidity()) { //value blank?
			$("#bookingSessionId").addClass("inputError");

			b=false;
		}
		return b;
		
	}


	function ParseJsonFileBooking(result) { 
		$("#bookingSessionId").val(result.sessionId);
		$("#bookingMemberId").val(result.memberId);
	}

	
