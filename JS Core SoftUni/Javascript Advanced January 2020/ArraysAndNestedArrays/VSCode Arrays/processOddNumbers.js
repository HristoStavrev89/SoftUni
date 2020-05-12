function solve(arr) {
    let result = [];
    let resIndex = 0;

    arr.forEach((element, index) => {
        
        if (index % 2 !== 0) {
            result[resIndex] = Number(element) * 2;
            resIndex++;
        }
    });

    return result.reverse();
}

console.log(solve([10, 15, 20, 25]));
