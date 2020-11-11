let { assert } = require('chai');
let mathEnforcer = require('./mathEnforcer');

describe('mathEnforcer, testing `addFive` function', () => {
    it('Should return `undefined` if the parameter is NOT a number', () => {
        assert.equal(undefined, mathEnforcer.addFive('word'));
    });

    it('Should add 5 to the given number', () => {
        assert.equal(10, mathEnforcer.addFive(5));
    })
});

describe('mathEnforcer, testing `subtract` function', () => {
    it('Should return `undefined` if the parameter is NOT a number', () => {
        assert.equal(undefined, mathEnforcer.subtractTen('word'));
    });

    it('Should subtract 10 from a given number', () => {
        assert.equal(5, mathEnforcer.subtractTen(15));
    })
})

describe('mathEnforcer, testing `sum` function', () => {
    it('Should return `undefined` if the first parameter is NOT a number', () => {
        assert.equal(undefined, mathEnforcer.sum('notNum', 2))
    })

    it('Should return `undefined` if the second parameter is NOT a number', () => {
        assert.equal(undefined, mathEnforcer.sum(16, 'notNum'))
    })

    it('Should return the sum from the both numbers', () => {
        assert.equal(17, mathEnforcer.sum(12, 5))
    })
})