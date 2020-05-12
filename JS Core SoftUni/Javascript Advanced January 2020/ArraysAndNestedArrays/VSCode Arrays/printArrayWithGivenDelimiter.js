function solve(arr) {
    let delimiter = arr.pop(arr.length);
    return arr.join(delimiter);
}
console.log(solve(['One', 
'Two', 
'Three', 
'Four', 
'Five', 
'-']
));
