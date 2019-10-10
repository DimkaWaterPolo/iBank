/**
 * 
 */

function isNumber(n) {
	return (!isNaN(parseFloat(n)) && isFinite(n));
}

function isAccountFormat(element) {
	var result = (element.value.length == 20);
	result = (result && isNumber(element.value));
	return result;	
}

function isSumFormat(value) {
	
	if (value.length == 0)
		return false;
	
	for (var i = 0; i < value.length; i++) {
		if (!isNumber(value[i]) && (value[i] != '.') && (value[i] != ','))
			return false;
	}
	
	return true;	
}

function isEmptyFormat(value) {
	return (value.length == 0);
}

function doAjax(source){
	
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
     if (this.readyState == 4 && this.status == 200) {
	   document.getElementById("content-wrapper").innerHTML = this.responseText; 
	 }
  };
    
  xhttp.open("GET", "ajax" + source.id.toUpperCase(), true);
  xhttp.send();
}

function getDocsAjax(){
	
	  var xhttp = new XMLHttpRequest();
	  	  
	  xhttp.onreadystatechange = function() {
	     if (this.readyState == 4 && this.status == 200) {
		   document.getElementById("content-wrapper").innerHTML = this.responseText; 
		 }
	  };
	    
	  var form = document.getElementById("form-filter-docs");
	  
	  var body = 'direct=' + encodeURIComponent(form.elements['direct'].value)
	  				+'&strStartDate=' + encodeURIComponent(form.elements['startDate'].value)
	  					+'&strEndDate=' + encodeURIComponent(form.elements['endDate'].value);
	  
	  xhttp.open("POST", "getDocsAjax", true);
	  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhttp.send(body);
}

function validatePayment() {
	
	var result = true;
	
	var form = document.getElementById("form-payment");
	
	document.getElementById('error_'+form.elements['account_payer_payment'].id).innerHTML = "";
	document.getElementById('error_'+form.elements['account_receiver_payment'].id).innerHTML = "";
	document.getElementById('error_'+form.elements['sum_payment'].id).innerHTML = "";
	document.getElementById('error_'+form.elements['ground_payment'].id).innerHTML = "";
	
	if (! isAccountFormat(form.elements['account_payer_payment'])) {
		document.getElementById('error_'+form.elements['account_payer_payment'].id).innerHTML = "Ошибка валидации (Ожидается 20 числовых символов)";
		result = false;
	} 

	if (! isAccountFormat(form.elements['account_receiver_payment'])) {
		document.getElementById('error_'+form.elements['account_receiver_payment'].id).innerHTML = "Ошибка валидации (Ожидается 20 числовых символов)";
		result = false;
	} 

	if (! isSumFormat(form.elements['sum_payment'].value)) {
		document.getElementById('error_'+form.elements['sum_payment'].id).innerHTML = "Ошибка валидации (Ожидается числовой формат)";
		result = false;
	}

	if (isEmptyFormat(form.elements['ground_payment'].value)) {
		document.getElementById('error_'+form.elements['ground_payment'].id).innerHTML = "Ошибка валидации (Ожидается не пустое значение)";
		result = false;
	}

	return result;
}

function doPayment(){
 
	  if (! validatePayment()){
		  return false
	  }

	  var xhttp = new XMLHttpRequest();
	  	  
	  xhttp.onreadystatechange = function() {
	     if (this.readyState == 4 && this.status == 200) {
		   document.getElementById("content-wrapper").innerHTML = this.responseText; 
		 }
	  };
	    
	  var form = document.getElementById("form-payment");
	  
	  var body = 'payerAccount=' + encodeURIComponent(form.elements['account_payer_payment'].value)
	  				+'&receiverAccount=' + encodeURIComponent(form.elements['account_receiver_payment'].value)
	  					+'&sum=' + encodeURIComponent(form.elements['sum_payment'].value)
	  						+'&ground=' + encodeURIComponent(form.elements['ground_payment'].value);
	  
	  xhttp.open("POST", "doPayment", true);
	  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhttp.send(body);
}