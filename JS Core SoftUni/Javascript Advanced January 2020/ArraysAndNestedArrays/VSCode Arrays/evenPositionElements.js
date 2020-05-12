function solve(arr) {
    let result = [];
    arr.forEach((element, index) => {
        if (index % 2 === 0) {
            result.push(element);
        }
    });
    return result.join(' ');
}
console.log(solve(['20', '30', '40']));
