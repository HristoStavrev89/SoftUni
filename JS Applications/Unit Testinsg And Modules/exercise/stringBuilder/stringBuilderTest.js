let { assert } = require('chai');
const { describe } = require('mocha');
let StringBuilder = require('./stringBuilder');

describe('StringBuilder', () => {

    let sb;
    beforeEach(() => {
        sb = new StringBuilder();
    })

    describe('verifyParams', () => {
        it('should throw exception when param is not a string', () => {
            assert.throw(() => {
                new StringBuilder({});
            }, 'Argument must be string')
        })
    })

    describe('constructor test', () => {

        it('Should work properly without argument', () => {
            assert.equal('', sb.toString());
        })

        it('Should work properly with argument', () => {
            sb = new StringBuilder('word');

            assert.equal('word', sb.toString());
        })
    })

    describe('append', () => {
        it('should converts the passed in string argument to an array and adds it to the end of the storage', () => {
            sb.append('Hello World')
            assert.equal('Hello World', sb.toString())
        })
    })


    describe('prepend', () => {
        it('should converts the passed in string argument to an array and adds it to the begin of the storage', () => {
            sb.append('World')
            sb.prepend('Hello ')
            assert.equal('Hello World', sb.toString())
        })
    })

    describe('InsertAt', () => {
        it('should converts the passed in string argument to an array and adds it at the given index', () => {
            sb.append('Helo World');
            sb.insertAt('l', 2);
            assert.equal('Hello World', sb.toString())
        })
    })

    describe('remove', () => {
        it('removes elements from the storage, starting at the given index (inclusive), length number of characters', () => {
            sb.append('Hello World');
            sb.remove(5, 6);
            assert.equal('Hello', sb.toString());
        })
    })
})