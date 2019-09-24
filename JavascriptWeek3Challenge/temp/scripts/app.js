/*jslint browser, es6 */

/*global window */
window.onload = function () {
  const CSSPreProcessor = `Sass`;
  const JSVersion = `ES6`;
};

var url = "https://randomuser.me/api/?results=25";
var p = "";
document.getElementById('getText').addEventListener('click', getText);
fetch(url).then(response => response.json()).then(function (data) {
  let url = 'https://randomuser.me/api/?results=25';
  fetchInformation(url);
});

function getText() {
  fetch(url).then(response => response.json()).then(function (data) {
    data.results.forEach(person => {
      p = `<div class="card" style="color:black; padding:1%;background-color:black;color:white; opacity:0.7;">
           <img  class = "giphy-embed"src="${person.picture.medium}"  alt="Bio img">
           <ul>
           <li>Name: ${person.name.title} ${person.name.first} ${person.name.last}</li>
           <li>
           Nationality: ${person.nat}</li>
           <li>
           Address: ${person.location.street},${person.location.city},${person.location.state}</li>
           <li>Abilities: Classified </li>
           
           </ul>
            
           
           </div>`;
      $("#people").html(p);
    });
  });
}