function setLink(value) {
	location.href = value;
}

function toggleDaily() {
  var dailyRent = document.getElementById("dailyRent");
  var periodRent = document.getElementById("periodRent");

  dailyRent.classList.remove("hidden");
  periodRent.classList.add("hidden");

  var dailyPrice = document.getElementById("dailyPrice");
  var periodPrice = document.getElementById("periodPrice");
  var penalty = document.getElementById("penalty");
  var allowedRentalDays = document.getElementById("allowedRentalDays");

  dailyPrice.setAttribute("required", "");
  periodPrice.removeAttribute("required");
  penalty.removeAttribute("required");
  allowedRentalDays.removeAttribute("required");

}

function togglePeriod() {
  var dailyRent = document.getElementById("dailyRent");
  var periodRent = document.getElementById("periodRent");

  dailyRent.classList.add("hidden");
  periodRent.classList.remove("hidden");

  var dailyPrice = document.getElementById("dailyPrice");
  var periodPrice = document.getElementById("periodPrice");
  var penalty = document.getElementById("penalty");
  var allowedRentalDays = document.getElementById("allowedRentalDays");

  dailyPrice.removeAttribute("required");
  periodPrice.setAttribute("required", "");
  penalty.setAttribute("required", "");
  allowedRentalDays.setAttribute("required", "");
}

function toggleGenre() {
  var genreSelect = document.getElementById("genreSelect");
  var genreInput = document.getElementById("genreInput");

  let checkbox = document.getElementById("newGenre");
    if(checkbox.checked) {
      genreInput.setAttribute("name", "movieType.genre");
      genreInput.classList.remove("hidden");
      genreSelect.removeAttribute("name", "movieType.genre");
      genreSelect.classList.add("hidden");
      genreSelect.removeAttribute ("required");
      genreInput.setAttribute("required", "");
    } else {
      genreSelect.setAttribute("name", "movieType.genre");
      genreSelect.classList.remove("hidden");
      genreInput.removeAttribute("name", "movieType.genre");
      genreInput.classList.add("hidden");
      genreInput.removeAttribute("required");
      genreSelect.setAttribute("required", "");
    }
}


function setBonusDaysField() {
  var bonusCheckbox = document.getElementById("bonus");
  var bonusBox = document.getElementById("bonusBox");
  var bonusDays = document.getElementById("bonusDays");

    if(bonusCheckbox.checked) {
      bonusBox.classList.remove("hidden");
      bonusDays.removeAttribute("required");
    } else {
      bonusBox.classList.add("hidden");
      bonusDays.setAttribute("required", "");
    }

}