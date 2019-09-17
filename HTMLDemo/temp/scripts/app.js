/*jslint browser, es6 */

/*global window */
window.onload = function () {
  const CSSPreProcessor = `Sass`;
  const JSVersion = `ES6`;
};

function changeFontColor() {
  var thisColor = document.getElementById("currentColor");
  var newColor = document.getElementById("newColor").value;
  thisColor.style.color = newColor;
}