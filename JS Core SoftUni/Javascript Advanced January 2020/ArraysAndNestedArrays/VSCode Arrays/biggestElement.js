function solve(matrix) {

let biggestElement = 0;

for (let index = 0; index < matrix.length; index++) {
   matrix[index].forEach(element => {
       let current = Number(element);
       if (current > biggestElement && current !== NaN) {
        biggestElement = current;
       }
   });
    
}
return biggestElement;

}

console.log(solve([[20, 50, 10],
    [8, 33, 145, 'gosho']]
   ));
