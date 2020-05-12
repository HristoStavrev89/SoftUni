function solve(numbers) {
    
    let result = [];

    numbers.forEach(element => {
        if (Number(element) >= 0) {
            result.push(element);
        } else if (element < 0) {
            result.unshift(element);
        }
    });
return result;
}
console.log(solve([3, -2, 0, -1]));

