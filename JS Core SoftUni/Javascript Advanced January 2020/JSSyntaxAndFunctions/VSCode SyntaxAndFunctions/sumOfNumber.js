function solve(n, m) {

    let sum = 0;
    
for (let index = Number(n); index <= Number(m); index++) {
    sum += Number(index);
}
return sum;
}

console.log(solve('1', '5'));
