let { assert } = require('chai');
let PaymentPackage = require('./paymentPackage');

describe('PaymentPackage', () => {
    let paymentPackage;
    describe('constructor', () => {

        it('constructor should work properly with 2 params', () => {
            paymentPackage = new PaymentPackage('Chris', 15);
            let expected = new PaymentPackage('Chris', 15);

            assert.deepEqual(paymentPackage, expected);
        })

        it('should throw exception with incorrect name', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage(3, 13);
            }, 'Name must be a non-empty string')
        })

        it('should throw exception with incorrect name length 0', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('', 13);
            }, 'Name must be a non-empty string')
        })


        it('should throw exception with incorrect value', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('Chris', 'Chris');
            }, 'Value must be a non-negative number')
        })

        it('should throw exception with incorrect value', () => {
            assert.throw(() => {
                paymentPackage = new PaymentPackage('Chris', -7);
            }, 'Value must be a non-negative number')
        })
    })

})