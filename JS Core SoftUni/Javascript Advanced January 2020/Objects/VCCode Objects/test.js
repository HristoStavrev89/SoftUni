let person = {
    firstName: 'Gosho',
    lastName: 'Petrov',

    fullName: function() {
        
        return `${this.firstName} ${this.lastName}`
    },

    returnThis: function() {
        return this
    },

    bodyStats: {
        height: 170,
        weight: 80,
        hair: 'brown',
        eyeColour: 'brown'
    }

}

delete person.bodyStats;

person.bodyStats = {
    body: 'slim', height: 180
}

console.log(person.fullName());

Object.freeze(person)
Object.seal(person)

person.firstName = 'Petkan';

console.log(person.fullName());

for (const key in person) {
    console.log(person[key]);
    
}


for (const iterator of object) {
    
}








