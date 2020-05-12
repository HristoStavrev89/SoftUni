function solve(arr) {


    return arr.reduce((acc, x) => acc + x, 0);
    

}

console.log(solve([1, 2, 3, 100]));
