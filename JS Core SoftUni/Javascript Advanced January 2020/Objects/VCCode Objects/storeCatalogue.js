function solve(input) {
    
    let catalogue = {};


    for (const line of input) {
        let [ name, price ] = line.split(' : ');
        price = Number(price)
        let letter = name[0];


        if (!catalogue.hasOwnProperty(letter)) {
            catalogue[letter] = {};
        }

        let products = catalogue[letter];

        if (!products.hasOwnProperty(name)) {
            products[name] = price;
        }

    }
    
   Object.keys(catalogue).sort()
    .map(letter => {
        console.log(letter);

        Object.keys(catalogue[letter]).sort()
        .map(x => {
            
           let products = catalogue[letter]
            
            console.log(`  ${x}: ${products[x]}`);
            
        })
        
    })




// let sortedInitials = Object.keys(catalogue).sort();

// for (const initial of sortedInitials) {
//     let products = catalogue[initial];
//     let sortedProducts = Object.keys(products).sort();

//     console.log(initial);
    
//     for (const p of sortedProducts) {
//         console.log(` ${p}: ${products[p]}`);
        
//     }
// }


    
}

solve(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
);

// console.log(solve(['Appricot : 20.4',
// 'Fridge : 1500',
// 'TV : 1499',
// 'Deodorant : 10',
// 'Boiler : 300',
// 'Apple : 1.25',
// 'Anti-Bug Spray : 15',
// 'T-Shirt : 10']
// ));


