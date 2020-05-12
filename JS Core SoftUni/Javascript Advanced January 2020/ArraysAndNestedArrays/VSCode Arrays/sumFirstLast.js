function solve(arr) {
    return arr.length === 1 ? Number(arr[0]) + Number(arr[0]) : Number(arr.shift()) + Number(arr.pop());
}
console.log(solve([5]));

