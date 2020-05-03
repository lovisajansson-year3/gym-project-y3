$(document).ready(function () {
	console.log("main")
populateGymMembers();
populateTrainingSessions();
populateBookings();
buildTable();

var inputs = document.querySelectorAll('input, textarea,select');
for(var i=0;i<inputs.length;i++) {
 inputs[i].addEventListener('blur', function(){
   if(!this.checkValidity()) {
     this.classList.add("inputError");  
   } else {
     this.classList.remove("inputError");
     this.classList.add("inputSuccess");  
   }
 }); 

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
        			  .append($("<td>").append(member.memberId))
        			  .append($("<td>").append(member.name)))
          })		
	})
	$.getJSON("http://localhost:8080/GymProjectClient/TrainingSessionServlet/",
			function(result){ 
		
				$(result).each(function(i,session){
              	  $("#trainingSessionBody").append($("<tr>")
              			  .append($("<td>").append(session.sessionId))
              			  .append($("<td>").append(session.instructor)))
                })
	})
	$.getJSON("http://localhost:8080/GymProjectClient/BookingServlet/",
			function(result){ 
                $(result).each(function(i,booking){
              	  $("#bookingBody").append($("<tr>")
              			  .append($("<td>").append(booking.bookingId))
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
			  $('#memberId option:not(:first)').remove();
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
			  $('#sessionId option:not(:first)').remove();              
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
			  $('#bookingId option:not(:first)').remove();              for( var i = 0; i<len; i++){
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


