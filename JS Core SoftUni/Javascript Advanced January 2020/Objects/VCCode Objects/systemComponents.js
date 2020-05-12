function solve(params) {
    let generalSystem = {};

    for (let line of params) {
        let [system, component, subComponent] = line.split(" | ");
        
        if (!generalSystem.hasOwnProperty(system)) {
            generalSystem[system] = {};
        } 

        

        let currentSystem = generalSystem[system];

        if (!currentSystem.hasOwnProperty(component)) {
            currentSystem[component] = [];
        }

        currentSystem[component].push(subComponent)

    }

    Object.keys(generalSystem).sort((a, b) => Object.keys(generalSystem[b]).length - Object.keys(generalSystem[a]).length || a.localeCompare(b)).map(system => {
        console.log(system);

        let systemComponents = generalSystem[system];

        Object.keys(systemComponents).sort((a, b) => Object.keys(systemComponents[b]).length - Object.keys(systemComponents[a]).length).map(component => {
            console.log(`|||${component}`);

            let subComponents = systemComponents[component];

            subComponents.forEach(sub => {
                console.log(`||||||${sub}`)
            })
        })
    })
}

solve(['SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security']
)