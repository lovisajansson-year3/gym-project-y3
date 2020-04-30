$(document).ready(function () {
	console.log("main")
populateGymMembers();
populateTrainingSessions();
populateBookings();
buildTable();

const inputs = document.querySelectorAll('input, select, textarea');
	for(let input of inputs) {
	  // Just before submit, the invalid event will fire, let's apply our class there.
	  input.addEventListener('invalid', (event) => {
	    input.classList.add('error');    
	  }, false);
	  input.addEventListener('change', (event) => {
		    input.classList.add('valid');    
		  }, false);
	  
	  // Optional: Check validity onblur
	  input.addEventListener('blur', (event) => {
	    input.checkValidity();
	  })

	}
	

})

function buildTable(){
	$("#trainingSessionBody").empty();
	$("#gymMemberBody").empty();
	$("#bookingBody").empty();
	$.getJSON("http://localhost:8080/GymProjectClient/GymMemberServlet/",
			function(result){ 
			  $(result).each(function(i,member){
          	  $("#gymMemberBody").append($("<tr>")
        			  .append($("<td>").append(member.name))
        			  .append($("<td>").append(member.memberId)))
          })		
	})
	$.getJSON("http://localhost:8080/GymProjectClient/TrainingSessionServlet/",
			function(result){ 
		
				$(result).each(function(i,session){
              	  $("#trainingSessionBody").append($("<tr>")
              			  .append($("<td>").append(session.instructor))
              			  .append($("<td>").append(session.sessionId)))
                })
	})
	$.getJSON("http://localhost:8080/GymProjectClient/BookingServlet/",
			function(result){ 
                $(result).each(function(i,booking){
              	  $("#bookingBody").append($("<tr>")
              			  .append($("<td>").append(booking.sessionId))
              			  .append($("<td>").append(booking.memberId)))
                })
	})
}
function populateGymMembers(){
	$.ajax({
        	type: 'GET', 
			url: "http://localhost:8080/GymProjectClient/GymMemberServlet/",  
			error: ajaxFindReturnError,  
			success: ajaxFindReturnSuccess 
		});
			
		function ajaxFindReturnSuccess(result, status, xhr) {
			  console.log("members found")
			  var len = result.length;
              $("#memberId").empty();
              for( var i = 0; i<len; i++){
                    var id = result[i].memberId;
                    console.log(id+name);
                $("#memberId").append("<option value='"+id+"'>"+id+"</option>");
                $("#bookingMemberId").append("<option value='"+id+"'>"+id+"</option>");

              }
             
         } 
		function ajaxFindReturnError(result, status, xhr) { 
			console.log("couldn't load members");
	} 	
  }
function populateTrainingSessions(){
	$.ajax({
        	type: 'GET', 
			url: "http://localhost:8080/GymProjectClient/TrainingSessionServlet/",  
			error: ajaxFindReturnError,  
			success: ajaxFindReturnSuccess 
		});
			
		function ajaxFindReturnSuccess(result, status, xhr) {
			  console.log("sessions found")
			  var len = result.length;
              $("#sessionId").empty();
              for( var i = 0; i<len; i++){
                    var id = result[i].sessionId;
                $("#sessionId").append("<option value='"+id+"'>"+id+"</option>");
                $("#bookingSessionId").append("<option value='"+id+"'>"+id+"</option>");

              } 
              
             
         } 
		function ajaxFindReturnError(result, status, xhr) { 
			console.log("couldn't load sessions");
	} 	
  }
function populateBookings(){
	console.log("popbookings");
	$.ajax({
        	type: 'GET', 
			url: "http://localhost:8080/GymProjectClient/BookingServlet/",  
			error: ajaxFindReturnError,  
			success: ajaxFindReturnSuccess 
		});
			
		function ajaxFindReturnSuccess(result, status, xhr) {
			  console.log("bookings found")
			  var len = result.length;
              $("#bookingId").empty();
              for( var i = 0; i<len; i++){
                    var id = result[i].bookingId;
                $("#bookingId").append("<option value='"+id+"'>"+id+"</option>");
                
              }
         } 
		function ajaxFindReturnError(result, status, xhr) { 
			
			if(result.status=="400"){
				console.log(" bad request");	
			}else if(result.status=="404"){
				console.log("no bookings exist");
			}
			else{
				console.log(result.status);} 	
			}
  }


