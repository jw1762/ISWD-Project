//Checks & enable/disable button if form is empty/filled
function doCheck() {
	var allFilled = true;
	$('.OrderForm').each(function() {
		if ($(this).val() == '') {
			allFilled = false;
		}
	});

	$('input[type=submit]').prop('disabled', !allFilled);
	if (allFilled) {
		$('input[type=submit]').removeAttr('disabled');
	}
}

$(document).ready(function() {
	doCheck(); //Calls doCheck to check if form is empty
	$('.OrderForm').keyup(doCheck); //Calls doCheck again if form is filled & on key press
	
	//Saves input values  to JS localStorage/cookies when clicked on getPrice
	$('#getPrice').on('click', function(){
		$('.OrderForm').each(function(){    
			var id = $(this).attr('id');
			var value = $(this).val();
			localStorage.setItem(id, value);
		}); 
		
	});
	
	//Loads input values from JS localStorage/cookies onto HTML form
	$('#load').on('click', function(){
		$('.OrderForm').each(function(){    
			var id = $(this).attr('id');
			var value = localStorage.getItem(id);
			$(this).val(value);
		}); 
		doCheck(); //Calls doCheck to enable button
	});
	
	//Clears the JS localStorage/cookies when clicked on submit
	$('#submit').on('click', function(){
		localStorage.clear();
	});
});