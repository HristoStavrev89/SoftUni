function argumentInfo(...params) {

    let argsInfo = {};
    
    params.forEach(current => {
        console.log(typeof current + ": " + current);

        let type = typeof current;

        if (!argsInfo[type]) {
            argsInfo[type] = 0;
        }
        argsInfo[type]++;
    })

    Object.entries(argsInfo)
    .sort((a, b) => {
        const [ aKey , aValue] = a;
        const [ bKey , bValue] = b;

        return bValue - aValue;
    })
    .forEach(element => {
        
        let [ key,  value ] = element;

        console.log(`${key} = ${value}`);
        
    });
}

argumentInfo('cat', 42, function () { console.log('Hello world!'); })


