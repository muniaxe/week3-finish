let cars = [
    {id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000},
    {id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900},
    {id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000},
    {id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799},
    {id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799}
];

let list = document.getElementsByTagName("div")
const element1 = document.getElementById("1")
const element2 = document.getElementById("2")
const element3 = document.getElementById("3")

for (let i = 0; i < list.length; i++){
    list.item(i).style.backgroundColor = "red"
}

const btn1 = document.getElementById("btn1")
btn1.onclick = () => {
    element1.style.color = "blue"
    element2.style.color = "green"
    element3.style.color = "purple"
}

btn1.addEventListener("click", ()=>{

})

element3.innerHTML =  make(cars)
