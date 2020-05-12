function solve(x, y, operator) {
    return eval(`${x}${operator}${y}`);
}
console.log(solve(5, 6, '+'));

