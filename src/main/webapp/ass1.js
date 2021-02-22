const box1 = document.getElementById("box1")
const box2 = document.getElementById("box2")

/*box1.addEventListener("click", () =>{
    console.log("Hi I am from " + box1.id)
})

box2.addEventListener("click", ()=>{
    console.log("Hi I am from " + box2.id)
})

 */

let nameList = ["Thomas", "Carsten", "Philip", "Tobias"]

const outer = document.getElementById("outer")
const text = document.getElementById("text")
const names = document.getElementById("names")
const nameInsert = document.getElementById("nameInsert")
const input = document.getElementById("input")
const butRmvFst = document.getElementById("removeFirst")
const butRmvLst = document.getElementById("removeLast")



outer.addEventListener("click", (e)=>{
    text.innerText = ("Hi I am from " + e.target.id)
})

const make = function (name) {
    const tmpName = name.map(name => "<li>" + name + "</li>");
    const newName = tmpName.join("");
    return "<ul>" + newName + "</ul>";
};

names.innerHTML = make(nameList)

nameInsert.addEventListener("submit",(e)=>{
    e.preventDefault()
    const newName = input.value
    nameList.push(newName)
    names.innerHTML = make(nameList)
    input.value = "";
})

butRmvFst.addEventListener("click", ()=>{
    nameList.shift();
    names.innerHTML = make(nameList)
})

butRmvLst.addEventListener("click",()=>{
    nameList.pop();
    names.innerHTML = make(nameList)
})