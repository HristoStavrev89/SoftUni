function solution(num) {
    return function (numToAdd) {
        return num + numToAdd;
    }
}


let firstN = solution(5);
console.log(firstN(15));
console.log(firstN(3.5));



// IIFE example
// let addFunction = (function (num) {
// let privateData = num;

//     return function (numToAdd) {
//         return num + numToAdd;
//     }
// })(5);


