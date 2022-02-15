function validate() {
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var secondPassword = document.getElementById("secondPassword").value;

    var loginPassNameSurnamePattern = /.{2}.*/

    if(!loginPassNameSurnamePattern.test(name)) {
        return false;
    }

    if(!loginPassNameSurnamePattern.test(surname)) {
        return false;
    }

    if(!loginPassNameSurnamePattern.test(login)) {
        return false;
    }

    if(!loginPassNameSurnamePattern.test(password)) {
        return false;
    }

    if(password != secondPassword) {
        return false;
    }

    return true;
}

function validate2() {
        var name = document.getElementById("name").value;
        var description = document.getElementById("description").value;
        var price = document.getElementById("price").value;
        var quantity = document.getElementById("quantity").value;

        var nameDescriptionPattern = /.{2}.*/

        if(!nameDescriptionPattern.test(name)) {
            return false;
        }

        if(!nameDescriptionPattern.test(description)) {
            return false;
        }

        if(price < 1 || price > 9999) {
            return false;
        }

        if(quantity < 1 || quantity > 999) {
            return false;
        }

        return true;
}


