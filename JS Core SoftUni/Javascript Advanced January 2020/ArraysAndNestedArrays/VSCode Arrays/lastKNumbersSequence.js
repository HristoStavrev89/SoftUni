function solve(n ,k) {
    let arr = [1];
    let sum = arr.reduce((acc, x) => acc + x, 0);


    for (let i = 0; i < n; i++) {
        if (sum !== i) {
            arr[i] = i;
        }
        
    }



}