let url = "https://jsonplaceholder.typicode.com/users/"

fetch(url)
    .then(res => res.json()) //in flow1, just do it
    .then(data => {
        // Inside this callback, and only here, the response data is available
        console.log("data",data);
        /* data now contains the response, converted to JavaScript
           Observe the output from the log-output above
           Now, just build your DOM changes using the data*/
    })

const fetchThis = document.getElementById("fetchthis")
const userInput = document.getElementById("userinput")
const getUser = document.getElementById("getUser")
const getAll = document.getElementById("getAll")

fetchThis.addEventListener("submit", (e)=>{
    e.preventDefault()
    const thisValue = userInput.value

})