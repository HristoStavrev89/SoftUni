let assert = require('chai').assert;
let { isOddOrEven } = require('./isOddOrEven')

describe('isOddOrEven', () => {
    it('Should return undefined with param different from string.', function() {
        assert.equal(undefined, isOddOrEven(5))
    });

    it('Should return undefined with param different from string. 2', function() {
        assert.equal(undefined, isOddOrEven({}))
    });

    it('Should return odd if the string length is odd number.', () => {
        assert.equal('odd', isOddOrEven('world'))
    })

    it('Should return even if the string length is even number.', () => {
        assert.equal('even', isOddOrEven('word'))
    });
})