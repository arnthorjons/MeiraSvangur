
var restaurants;
function getRestaurants() {
    // set variables into javascript object which you need to send to spring controller
    // the variable name here should be same as it is in your java class UserDetails.java

    var restaur = {};
    restar.search = "ble";

    $.ajax({
        type : 'GET',
        url : 'http://localhost:8080/getRestaurants',
        dataType : 'json',
        data : JSON.stringify(restaurants),
        contentType : 'application/json',
        success : function(data) {
            //here in data variable, you will get list of all users sent from
            // spring controller in json format, currently its object
            // iterate it and show users on page

            showUsers(data);
        },
        error : function() {
            alert('error');
        }
    });
}

function showUsers(data) {
    // and here you show users on page
    //following code just example
    restaurants = data;
    console.log(restaurants);
    console.log(data);
}

function rest() {
    getRestaurants();
}

rest();

document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM loaded');
    createElements();
});

/*
Nær í lista af veitingastöðum eftir týpu t.d pizza, burger, whatever, ...
Skilar lista af veitingastöðum
 function getRestaurants(type);*/


function configureElements(radar, type) {
    return restaurants;
}


//Býr til elements í main window
function createElements() {
    for(var i in restaurants) {
        var ni = document.querySelector(".res-data");
        var newdiv = document.createElement("div");
        //var name = restaurants[i].address;
        var elem = document.createElement("img");
        elem.setAttribute("width", "100%");
        elem.setAttribute("src", restaurants[i].logo);
        newdiv.setAttribute("class", "col-xs-6");
        ni.appendChild(newdiv);
        newdiv.appendChild(elem);
    }
}


//var restaurants = [
//    { name: "Subway", latitude: 1, longitude : 1, logo: "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcT2AkSSh8c7bgIpFi8R2M6pjSw8k5UKG4U8lnfisqdleHKD900S"},
//    { name: "MC", latitude: 1, longitude : 1, logo: "http://3.bp.blogspot.com/-IUOlJjfl3Gw/U3H85fu8EqI/AAAAAAAACRs/pDTU4sywkk0/s1600/MacDonald+Middle+East+Job+Vacancies.png"},
//    { name: "MC", latitude: 1, longitude : 1,  logo: "http://3.bp.blogspot.com/-IUOlJjfl3Gw/U3H85fu8EqI/AAAAAAAACRs/pDTU4sywkk0/s1600/MacDonald+Middle+East+Job+Vacancies.png"},
//    { name: "Dominos", latitude: 1, longitude : 1,  logo: "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Dominos_pizza_logo.svg/2000px-Dominos_pizza_logo.svg.png"},
//    { name: "Starbucks", latitude: 2, longitude : 1,  logo: "https://upload.wikimedia.org/wikipedia/en/thumb/3/35/Starbucks_Coffee_Logo.svg/1024px-Starbucks_Coffee_Logo.svg.png"},
//    { name: "MC", latitude: 2, longitude : 1,  logo: "http://3.bp.blogspot.com/-IUOlJjfl3Gw/U3H85fu8EqI/AAAAAAAACRs/pDTU4sywkk0/s1600/MacDonald+Middle+East+Job+Vacancies.png"},
//    { name: "MC", latitude: 2, longitude : 1,  logo: "http://3.bp.blogspot.com/-IUOlJjfl3Gw/U3H85fu8EqI/AAAAAAAACRs/pDTU4sywkk0/s1600/MacDonald+Middle+East+Job+Vacancies.png"},
//    { name: "DD", latitude: 3, longitude : 1,  logo: "https://pbs.twimg.com/profile_images/463795543215308800/aWjYe13J_400x400.jpeg"},
//    { name: "KFC", latitude: 3, longitude : 1,  logo: "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/KFC_logo.svg/1024px-KFC_logo.svg.png"},
//    { name: "MC", latitude: 3, longitude : 1,  logo: "http://3.bp.blogspot.com/-IUOlJjfl3Gw/U3H85fu8EqI/AAAAAAAACRs/pDTU4sywkk0/s1600/MacDonald+Middle+East+Job+Vacancies.png"}
//];
