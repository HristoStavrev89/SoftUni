function solve(data) {
    data.sort((a, b) => a.length - b.length || a.localeCompare(b))
        .map(name => {
            console.log(name)
        })
}


solve(['Ashton',
   'Kutcher',
   'Ariel',
   'Lilly',
   'Keyden',
   'Aizen',
   'Billy',
   'Braston']
)