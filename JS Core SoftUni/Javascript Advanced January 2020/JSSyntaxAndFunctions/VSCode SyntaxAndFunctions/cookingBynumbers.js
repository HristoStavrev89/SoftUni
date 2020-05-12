function solve(arr) {

    let num = Number(arr[0]);

    let operations = {
        chop: (x) => { return (x / 2) },
        dice: (x) => { return Math.sqrt(x) },
        spice: (x) => { return x + 1 },
        bake: (x) => { return x * 3 },
        fillet: (x) => { return x - (x * 0.20) }
    };

    for (let i = 1; i < arr.length; i++) {
        num = operations[arr[i]](num);
        console.log(num);
    }
}

solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);

// function solveSecond(arr) {
//     let number = parseInt(arr.shift());
//     let operations = {
//         chop: (x) => {return (x / 2)},
//         dice: (x) => {return Math.sqrt(x)},
//         spice: (x) => {return x+1},
//         bake: (x) => {return x * 3},
//         fillet: (x) => {return number - (number * 0.20)}
//     };
//     for (let i = 0; i < arr.length; i++) {
//        number = operations[arr[i]](number);
//         console.log(number);
//     }
// }

// solveSecond(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);
