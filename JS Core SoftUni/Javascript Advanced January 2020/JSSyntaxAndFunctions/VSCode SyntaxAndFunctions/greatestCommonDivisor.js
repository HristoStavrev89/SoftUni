function solve(a, b) {

    while(b !== 0) {
        let tempMod = a % b;
        a = b;
        b = tempMod;
    }

    return a;
    
} 
console.log(solve(2154, 458));

