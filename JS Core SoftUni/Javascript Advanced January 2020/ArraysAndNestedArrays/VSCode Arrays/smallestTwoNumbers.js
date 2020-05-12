function solve(arr) {
let res = [];

    let index = 0;
    while(res.length !== 2) {
        res[index] = Math.min.apply(Math, arr);
        arr.splice(arr.indexOf(Math.min.apply(Math, arr)), 1);
        index++;
    }
    return res;
}

console.log(solve([30, 15, 50, 5]));
