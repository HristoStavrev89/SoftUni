function solve(n) {

    
    if (n === undefined) {
        n = 5;
    }


    for (let index = 0; index < n; index++) {
        console.log('* '.repeat(n).trim());
    }
}
solve();

