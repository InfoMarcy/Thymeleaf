//create a variable to count how many times the buttom on the page is clicked
var pageCounter = 1;
// get the button from the page
var btn = document.getElementById('btn_handlebar');

// get the div in which we want to work with the data  
var animalContainer = document.getElementById('hadleBars-html');
//add and event to listen when the button is clicked
btn.addEventListener('click', function(){

	// XMLHttpRequest will stablish a connection with the url we specify and then it let us send or receive data
	var ourRequest = new XMLHttpRequest();

	// get the data from url
	ourRequest.open('GET', 'https://learnwebcode.github.io/json-example/pets-data.json');
	

	// define what we want to do once the data is loaded
	ourRequest.onload = function (){
		
		//console.log(ourRequest.responseText);
		
		
		if(ourRequest.status >= 200 && ourRequest.status < 400){
			//save the data retrieve form the url on a variable
			var ourData = JSON.parse(ourRequest.responseText);
			
			// call a function that will work with the data retrieved
			  createHtml(ourData);
		} else {
			
			console.log("We connected to the server, but it returned an error");
		}
		
		
		
		  
		
		// console.log(ourData[0]); get the first object data from the json data
	};
	
	//  handler ajax error
	ourRequest.onerror = function (){
		console.log("connection error");
	}
	// send the request
	ourRequest.send();
	// increase the counter to change the url automatically
	pageCounter++;
	
	// if the button is click more than 1 times it will create  a class that we can manipulate with css
	if(pageCounter > 1){
		btn.classList.add("hide-me");
		
	}
});







//build a helper to help us calculate the age
Handlebars.registerHelper("calculateAge", function(birthYear){
	// get the current year - the year of the pet
	var age = new Date().getFullYear() - birthYear;
	
	if(age > 0){
		return age + " year old";
		
	}else {
		
		return "Less than a year old";
	}
	return age;
});


//handles the html data
function createHtml(data){
	
	// get the id of the script tag for the handleBar Template
	var rawTemplate = document.getElementById('handleBar-template').innerHTML;
	
	// compile the template to be use with HandleBars
	var compiledTemplate = Handlebars.compile(rawTemplate);
	
	
	// get the data to be used on the template
	var ourGeneratedHtml = compiledTemplate(data);
	
	
	//get the div element by id in which we want to display the data
	var handlerbarContainer = document.getElementById('hadleBars-html');
	handlerbarContainer.innerHTML = ourGeneratedHtml;
}













