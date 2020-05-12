function solve(n) {

let areTheySame = n.toString().split('').filter(x => n.toString()[0] === x).length === n.toString().length;

let sum = n.toString().split('').reduce((acc, x) => acc + Number(x) ,0);

console.log(areTheySame);
console.log(sum);

}

solve(3333);