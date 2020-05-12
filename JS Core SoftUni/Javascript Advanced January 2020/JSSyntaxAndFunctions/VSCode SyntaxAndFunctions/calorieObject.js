function solve(array){
    let obj = {};
    for (let i = 0; i < array.length; i+=2) {
        obj[array[i]] = parseInt(array[i + 1]); // filling the object
    }
   
    
    return obj;
}
console.log(solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']));
