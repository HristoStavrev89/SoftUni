var processor = (function(){

    var text = '';

    function append(str) {
        text += str;
    }

    function removeStart(n) {
       text = text.substring(n);
    }

    function removeEnd(n) {
        if (text.length >= n) {
            text = text.substring(0, text.length - n)
        }
    }

    function print() {
        console.log(text);
        
    }

    return {

        append,
        removeEnd,
        removeStart,
        print
    };

})();

processor.print();

processor.append('Joro')

processor.print();

processor.removeEnd(3)

processor.print();


