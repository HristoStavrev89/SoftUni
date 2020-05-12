function solve(data) {
    let heroes = [];
for (const line of data) {
    let[name, level, items] = line.split(" / ");
    level = Number(level);
    items = items ? items.split(", ") : [];
    heroes.push({name, level, items})
}
return JSON.stringify(heroes)
}

// Second solutions

function solveSecond(data) {
    return JSON.stringify(data.reduce((result, currentLine) => {
        let[name, level, items] = currentLine.split(" / ");
        items = items ? items.split(", ") : [];
        result.push({name, level: Number(level), items})
        return result;
    }, []))
}


console.log(solveSecond(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']
));



