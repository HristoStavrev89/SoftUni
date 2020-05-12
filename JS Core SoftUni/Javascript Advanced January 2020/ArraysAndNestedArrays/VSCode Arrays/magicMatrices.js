function solve(matrix) {

    let isMagic = true;

    

    for (let index = 0; index < matrix.length; index++) {

        
        let rowSum = matrix[index].reduce((acc, x) => acc + x, 0);

        let colSum = 0;

        for (let j = 0; j < matrix[index].length; j++) {
            colSum = matrix[j].reduce((acc, x) => acc + x, 0);
        }

        if (rowSum !== colSum) {
            isMagic = false;
        }
        
    }
return isMagic;
}

console.log(solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
   ));

   console.log(solve([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
   ));

   console.log(solve([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]
   ));
   
   
