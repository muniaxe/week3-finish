//Functions and callbacks

//Observe: no return type, no type on parameters
function add(n1, n2) {
    return n1 + n2;
};

var sub = function (n1, n2) {
    return n1 - n2;
};

var cb = function (n1, n2, callback) {
    try{
        if (typeof n1 !== "number" || typeof n2 !== "number") {
            throw new Error("Not a number");
        }
    return "Result from the two numbers: " + n1 + "+" + n2 + "=" + callback(n1, n2);
    } catch (error) {
        console.error(error);
    }
};

//1.
console.log( add(1,2) );

//2
console.log ( add );

//3
console.log( add(1,2,3) );

//4
console.log( add(1) );

//5
console.log( cb(3,3,add) );

//6
console.log( cb(4,3,sub) );

//7
console.log(cb(3,3,add()));

//8
console.log(cb(3,"hh",add));

//Filter, map & forEach

let name = ["Lars", "Thomas", "Carsten", "Jan", "Bo", "Anders", "Tobias"];

let bigNames = name.filter(word => word.length > 3);

const bigNamesUpper = bigNames.map(name => name.toUpperCase());

const hn = function (name) {
    const tmpName = name.map(name => "<li>" + name + "</li>");
    const newName = tmpName.join("");
    return "<ul>" + newName + "</ul>";
};

let cars = [
    {id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000},
    {id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900},
    {id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000},
    {id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799},
    {id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799}
];

console.log(cars)

const carByYear = cars.filter(car => car.year > 1999)

const carByMake = cars.filter(car => car.make === 'Volvo')

const carByPrice = cars.filter(car => car.price < 5000)

 function mysql (list) {
    const statement = list.map(item => `INSERT INTO cars (id, year, make, model, price) VALUES (${item.id}, ${item.year},${item.make},${item.model},${item.price})`)
    return statement;
}

console.log(mysql(cars))

var msgPrinter = function(msg,delay){
    setTimeout(function(){
        console.log(msg);
    },delay);
};
console.log("aaaaaaaaaa");
msgPrinter ("bbbbbbbbbb",2000);
console.log("dddddddddd");
msgPrinter ("eeeeeeeeee",1000);
console.log("ffffffffff");
