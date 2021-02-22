let cars = [
    {id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000},
    {id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900},
    {id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000},
    {id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799},
    {id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799}
];

const carsTable = document.getElementById("cars")
const search = document.getElementById("search")
const inputValue = document.getElementById("input")

function generateTable(cars) {
    const carsList = cars.map(car => `
<tr>
<th scope="row">${car.id}</th>
<td>${car.year}</td>
<td>${car.make}</td>
<td>${car.model}</td>
<td>${car.price}</td>
</tr>`).join("")
    return `<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">year</th>
      <th scope="col">make</th>
      <th scope="col">model</th>
      <th scope="col">price</th>
    </tr>
  </thead>
  <tbody>
    ${carsList}
  </tbody>
</table>`
}

carsTable.innerHTML = generateTable(cars)

search.addEventListener("submit",(e)=>{
    e.preventDefault()
    const newCars = cars.filter(car => car.price < input.value)
    carsTable.innerHTML = generateTable(newCars)
    input.value = ""
})