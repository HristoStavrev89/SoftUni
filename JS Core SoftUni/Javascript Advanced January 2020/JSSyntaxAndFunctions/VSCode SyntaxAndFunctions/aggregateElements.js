function solve(arr) {


    let sum = 0;
    let inverseSum = 0;
    let concatSum = '';

    for (let index = 0; index < arr.length; index++) {

        sum += arr[index];
        inverseSum += 1 / arr[index];
        concatSum += arr[index];

    }

    console.log(sum);
    console.log(inverseSum);
    console.log(concatSum);
}
solve([1 , 2, 3])