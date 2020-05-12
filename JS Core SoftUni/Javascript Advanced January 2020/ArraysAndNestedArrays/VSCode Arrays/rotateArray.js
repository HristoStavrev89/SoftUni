function solve(array) {
let rotations = Number(array.pop());


for (let index = 0; index < rotations % array.length; index++) {
    let current = array.pop();
    array.unshift(current);
}
console.log(array.join(' '));

}



solve(['Banana', 
'Orange', 
'Coconut', 
'Apple', 
'15']
)