//create a variable to count how many times the buttom on the page is clicked
var pageCounter = 1;

// get the button from the page
var btn = document.getElementById('btn_callAjaxHtml');

// get the div in which we want to work with the data
var animalContainer = document.getElementById('animal-info');  
//add and event to listen when the button is clicked
btn.addEventListener('click', function(){

	// XMLHttpRequest will stablish a connection with the url we specify and then it let us send or receive data
	var ourRequest = new XMLHttpRequest();

	// get the data from url
	ourRequest.open('GET', 'https://learnwebcode.github.io/json-example/animals-' + pageCounter + '.json');
	

	// define what we want to do once the data is loaded
	ourRequest.onload = function (){
		
		//console.log(ourRequest.responseText);
		
		
		if(ourRequest.status >= 200 && ourRequest.status < 400){
			//save the data retrieve form the url on a variable
			var ourData = JSON.parse(ourRequest.responseText);
			
			// call a function that will work with the data retrieved
			  rederHtml(ourData);
			  
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
	
	// if the button is click more than 3 times it will create  a class that we can manipulate with css
	if(pageCounter > 3){
		btn.classList.add("hide-me");
		
	}
});


// handles the html data
function rederHtml(data){
	
	// create a variable that will hold the html code
	var htmlString = "";
	//loop though the data and show it using html
	for(i=0; i< data.length; i++){
		htmlString += "<p>" + data[i].name + " is a " + data[i].species + " that likes to eat ";
		
		// loop though the list  favorites food likes
		for(a =0; a<  data[i].foods.likes.length; a++){
			// if it is the first element
			if(a == 0){
				
				htmlString +=	data[i].foods.likes[a];
			} else { // otherwise
				htmlString +=	" and " + data[i].foods.likes[a];
				
			}
			
			htmlString += ' and dislikes ';
			
			// loop though the list  dislikes food
			for(a =0; a<  data[i].foods.dislikes.length; a++){
				// if it is the first element
				if(a == 0){
					
					htmlString +=	data[i].foods.dislikes[a];
				} else { // otherwise
					htmlString +=	" and " + data[i].foods.dislikes[a];
					
				}
			
			
		}
		}
		htmlString += "</p> <hr />";
		
	}
	
	// append html to the page
	animalContainer.insertAdjacentHTML('beforeend', htmlString);
}