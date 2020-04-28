$(document).ready(function () {
populate();
getWeather();
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
function populate(){
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
             }
         } 
		function ajaxFindReturnError(result, status, xhr) { 
			console.log("couldn't load members");
	} 	
  }
	
function getWeather(){	
	var lat;
	var long;
	$.ajax({
		method: "GET",
		url: "http://api.ipstack.com/194.47.249.17?access_key=d88d508efc896b6eb4b24f06724b8930", 
		error: ajaxReturn_Error,
		success: ajaxReturn_Success
		});
	function ajaxReturn_Success(result, status, xhr) { 
			ParseJsonFileWeather(result); 
			getLocation();
			}
	function ajaxReturn_Error(result, status, xhr) { 
			console.log("Find ip-address: "+status);
	}
	function ParseJsonFileWeather(result) { 
		lat = result.latitude;
		long = result.longitude; 
		var city = result.city;
		var ipNbr = result.ip
		$("#city").text(city);
		$("#ipNbr").text(ipNbr);
	 }
	function getLocation(){
		$.ajax({
		method: "GET", 
		url: "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units= metric"+ "&APPID=f6acadbe8101f56f69b6f616a99403fa",
		error: ajaxWeatherReturn_Error,
		success: ajaxWeatherReturn_Success 
		});
	}
	

	
			
	function ajaxWeatherReturn_Success(result, status, xhr) { 
		var sunrise = result.sys.sunrise;
		var sunset = result.sys.sunset;
		var sunriseDate = new Date(sunrise*1000);
		var timeStrSunrise = sunriseDate.toLocaleTimeString(); 
		var sunsetDate = new Date(sunset*1000);
		var timeStrSunset = sunsetDate.toLocaleTimeString();
		$("#sunrise").text("Sunrise: "+timeStrSunrise); $("#sunset").text("Sunset: "+timeStrSunset);
		$("#weather").text(result.weather[0].main);
		$("#degree").text(result.main.temp+" \u2103"); 
		}
	function ajaxWeatherReturn_Error(result, status, xhr) {
		alert("Error i OpenWeaterMap Ajax"); 
		console.log("Ajax-find movie: "+status);
		}
		
	}		 
	$("#FindTrainingSession").click( function() {
		var strValue = $("#sessionId").val(); 
		if (strValue == ""|| isNaN(strValue)||strValue==null) { 
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
		if(sessionId==null||sessionId==""||isNaN(sessionId)){
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
			if (strValue == ""||isNaN(strValue)) { 
				$("#memberId").attr("placeholder","enter valid memberid"); 	

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
		if (strValue ==""||strValue==null||isNaN(strValue)) { 
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
			if(isGymMemberFormValid()){
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
			console.log(strMemberId);
			if(strMemberId==null||strMemberId==""){
				$("#memberId").attr("placeholder","enter memberId of member you'd like to update")
			}else{
			var obj = { memberId: strMemberId ,name: strName, address: strAddress, email: strEmail, phoneNumber: strPhoneNumber}; 
			var jsonString = JSON.stringify(obj); 
				$.ajax({  
					type: 'PUT', 
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
			});//btnclick
		$("#FindBooking").click( function() {
			var strValue = $("#bookingId").val(); 
			if (strValue == ""||strValue==null||isNaN(strValue)) { 
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
		if(bookingId==null||bookingId==""||isNaN(bookingId)){
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

	function  isGymMemberFormValid(){
		var strName = document.getElementById("name");
		var strAddress = document.getElementById("address");
		var strEmail = document.getElementById("email");
		var strPhoneNumber = document.getElementById("phoneNumber");
		var b = true; 
		
		if (!strName.checkValidity()) { //value blank?
			strName.placeholder=strName.validationMessage;
			b=false;
			}
		if (!strAddress.checkValidity()) { //value blank?
			strAddress.placeholder=strAddress.validationMessage;
			b=false;
			}
		if (!strEmail.checkValidity()) { //value blank?
			strEmail.placeholder=strEmail.validationMessage;
			b=false;
			}
		if (!strPhoneNumber.checkValidity()) { //value blank?
			strPhoneNumber.value="";
			strPhoneNumber.placeholder=strPhoneNumber.validationMessage;
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