let assert = require('chai').assert;
let { lookupChar } = require('./charLookup');

describe('charLookup, retrieves a character at a given index from a passed in string', () => {
    it('Should return `undefined` if the first parameter is not a string', () => {
        assert.equal(undefined, lookupChar(3, 2))
    });

    it('Should return `undefined` if the second parameter is not a number', () => {
        assert.equal(undefined, lookupChar(3, 'world'))
    });


    it('Should return `Incorrect index` when second parameter is bigger than length of the first parameter.', () => {
        assert.equal('Incorrect index', lookupChar('world', 10))
    })

    it('Should return `Incorrect index` when second parameter is equal with the length of the first parameter.', () => {
        assert.equal('Incorrect index', lookupChar('world', 5))
    })

    it('Should return `Incorrect index` when second parameter is negative number', () => {
        assert.equal('Incorrect index', lookupChar('world', -1))
    })

    it('Should return `r` ', () => {
        assert.equal('r', lookupChar('world', 2))
    })
})