function solve(input) {

    let[town, latitude, longitude] = input.shift().split(/([A-Z][a-z]+)/).filter(x => !x.includes("|"));

    let townsObj = {town: '', latitude: '', longitude: ''};

    for (const iterator of Object.keys(input)) {
        console.log(input[iterator]);
        
    }
    

    
    

} 

console.log(solve(['| Town | Latitude | Longitude |',
'| Sofia | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
));
