function sortArray(arr, order) {

    let arrayToSort = arr;

    function sortAsc() {
        return arrayToSort.sort((a, b) => a - b);
    }
    
    function sortDesc() {
        return arrayToSort.sort((a, b) => b - a);
    }

        return {
            sortAsc: sortAsc(),
            sortDesc: sortDesc()
        }
}

console.log(sortArray([14, 7, 17, 6, 8], 'asc'));
